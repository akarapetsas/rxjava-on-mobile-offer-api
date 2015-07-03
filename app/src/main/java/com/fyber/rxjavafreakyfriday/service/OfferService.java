/**
 * Fyber Android SDK
 * <p/>
 * Copyright (c) 2015 Fyber. All rights reserved.
 */

package com.fyber.rxjavafreakyfriday.service;

import com.fyber.rxjavafreakyfriday.models.BaseJSONResponse;
import com.fyber.rxjavafreakyfriday.models.Offers;

import java.util.ArrayList;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;
import rx.functions.Func1;

public class OfferService {

	public static String WEB_SERVICE_BASE_URL = "http://api.sponsorpay.com/feed/v1";

	private final MobileOfferWebService mWebService;

	public OfferService() {

		RequestInterceptor requestInterceptor = new RequestInterceptor() {
			@Override
			public void intercept(RequestInterceptor.RequestFacade request) {
				request.addHeader("Accept", "application/json");
			}
		};

		RestAdapter restAdapter = new RestAdapter.Builder()
				.setEndpoint(WEB_SERVICE_BASE_URL)
				.setRequestInterceptor(requestInterceptor)
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.build();

		mWebService = restAdapter.create(MobileOfferWebService.class);
	}

	private interface MobileOfferWebService {
		@GET("/offers.json")
		Observable<BaseJSONResponse> fetchOffers(@Query("appid") String appID,
												 @Query("uid") String userID,
												 @Query("ip") String ipAddress,
												 @Query("locale") String locale,
												 @Query("device_id") String deviceID,
												 @Query("pub0") String pub0,
												 @Query("timestamp") String timestamp,
												 @Query("offer_types") String offerType,
												 @Query("hashkey") String hashKey);
	}

	public Observable<ArrayList<Offers>> fetchOffers(final String appID, final String userID, final String ipAddress, final String locale
			, final String deviceID, final String pub0, final String timestamp, final String offerType, final String hashKey) {

		return mWebService.fetchOffers(appID, userID, ipAddress, locale, deviceID, pub0, timestamp, offerType, hashKey)
				.flatMap(new Func1<BaseJSONResponse, Observable<ArrayList<Offers>>>() {
					@Override
					public Observable<ArrayList<Offers>> call(BaseJSONResponse baseJSONResponse) {
						return Observable.just(baseJSONResponse.getOffers());
					}
				});
	}

}