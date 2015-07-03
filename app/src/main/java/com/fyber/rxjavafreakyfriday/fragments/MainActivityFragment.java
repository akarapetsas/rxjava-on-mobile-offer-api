package com.fyber.rxjavafreakyfriday.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ListView;

import com.fyber.rxjavafreakyfriday.R;
import com.fyber.rxjavafreakyfriday.adapters.OffersBaseAdapter;
import com.fyber.rxjavafreakyfriday.models.Offers;
import com.fyber.rxjavafreakyfriday.service.OfferService;
import com.fyber.rxjavafreakyfriday.util.Utils;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

	private ListView offersList;
	private ProgressDialog dialog;
	private ViewStub errorMessage;

	public static String URL_PARAMS = "appid=[APP_ID]&uid=[USER_ID]&ip=[IP_ADDRESS]&locale=[LOCALE]&device_id=[DEVICE_ID]&pub0=[CUSTOM]&timestamp=[UNIX_TIMESTAMP]&offer_types=[OFFER_TYPES]";


	private static final String IP_ADDRESS = "109.235.143.113";
	private static final String LOCALE = "de";
	private static final String OFFER_TYPES = "112";

	private String app_id = "2070";
	private String user_id = "spiderman";
	private String custom = "whatever";
	private String hashkey = "";

	private CompositeSubscription mCompositeSubscription;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View returnView = inflater.inflate(R.layout.fragment_main, container, false);

		//display a progress dialog while the user is waiting
		dialog = ProgressDialog.show(getActivity(), "Downloading offers", "Please wait...", true);

		offersList = (ListView) returnView.findViewById(R.id.listview);
		errorMessage = ((ViewStub) returnView.findViewById(R.id.stub_import));

		mCompositeSubscription = new CompositeSubscription();


		getAndroidIDAndGenerateHashKey();

		return returnView;
	}

	private void displayErrorMessage() {
		errorMessage.setVisibility(View.VISIBLE);
	}


	private void getAndroidIDAndGenerateHashKey() {

		Observable
				.create(new Observable.OnSubscribe<String>() {
					@Override
					public void call(Subscriber<? super String> subscriber) {
						String id = Utils.getAndroidAdId();
						subscriber.onNext(id);
					}
				})
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<String>() {
					@Override
					public void onCompleted() {
					}

					@Override
					public void onError(Throwable e) {
					}

					@Override
					public void onNext(String s) {
						String concatParams = URL_PARAMS;

						String timestamp = String.valueOf(Utils.getUnixTimeStamp());
						concatParams = concatParams.replace("[APP_ID]", app_id);
						concatParams = concatParams.replace("[USER_ID]", user_id);
						concatParams = concatParams.replace("[CUSTOM]", custom);
						concatParams = concatParams.replace("[IP_ADDRESS]", IP_ADDRESS);
						concatParams = concatParams.replace("[LOCALE]", LOCALE);
						concatParams = concatParams.replace("[DEVICE_ID]", s);
						concatParams = concatParams.replace("[UNIX_TIMESTAMP]", timestamp);
						concatParams = concatParams.replace("[OFFER_TYPES]", OFFER_TYPES);

						hashkey = Utils.generateHashKeyFromAlphabeticallySortedParameters(concatParams);

						subscriber(hashkey, s, timestamp);
					}
				});
	}


	public void subscriber(String hashkey, String token, String timestamp) {

		OfferService offerService = new OfferService();
		mCompositeSubscription.add(offerService.fetchOffers(app_id, user_id, IP_ADDRESS, LOCALE, token, custom, timestamp, OFFER_TYPES, hashkey)
						.subscribeOn(Schedulers.newThread())
						.observeOn(AndroidSchedulers.mainThread())
						.subscribe(new Subscriber<ArrayList<Offers>>() {
							@Override
							public void onNext(ArrayList<Offers> offers) {
								dialog.dismiss();

								if (offers != null) {

									//in case that we have offers pass the list
									// to the offers adapter and it will display them
									if (offers.size() > 0) {
										OffersBaseAdapter adapter = new OffersBaseAdapter(offers);
										offersList.setAdapter(adapter);
										adapter.notifyDataSetChanged();
									} else {
										displayErrorMessage();
									}
								} else {
									displayErrorMessage();
								}
							}

							@Override
							public void onCompleted() {
							}

							@Override
							public void onError(final Throwable error) {

								dialog.dismiss();
								displayErrorMessage();
							}
						})
		);
	}

}
