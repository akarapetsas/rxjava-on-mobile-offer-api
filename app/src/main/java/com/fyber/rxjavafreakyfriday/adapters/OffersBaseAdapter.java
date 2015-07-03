/**
 * Fyber Android SDK
 * <p/>
 * Copyright (c) 2015 Fyber. All rights reserved.
 */

package com.fyber.rxjavafreakyfriday.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fyber.rxjavafreakyfriday.FyberApplication;
import com.fyber.rxjavafreakyfriday.R;
import com.fyber.rxjavafreakyfriday.models.Offers;

import java.util.ArrayList;

public class OffersBaseAdapter extends BaseAdapter {

	private ArrayList<Offers> offers;

	public OffersBaseAdapter(ArrayList<Offers> offers) {
		this.offers = offers;
	}

	@Override
	public int getCount() {
		return offers.size();
	}

	@Override
	public Object getItem(int position) {
		return offers.get(position);
	}

	@Override
	public long getItemId(int position) {
		return offers.indexOf(getItem(position));
	}

	private class ViewHolder {
		TextView txtTitle;
		TextView txtTeaser;
		TextView txtPayout;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		LayoutInflater mInflater = (LayoutInflater) FyberApplication.getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.rowitem, null);
			holder = new ViewHolder();
			holder.txtTitle  = (TextView) convertView.findViewById(R.id.title);
			holder.txtTeaser = (TextView) convertView.findViewById(R.id.teaser);
			holder.txtPayout = (TextView) convertView.findViewById(R.id.payout);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		Offers rowItem = (Offers) getItem(position);

		holder.txtTeaser.setText(rowItem.getTeaser());
		holder.txtPayout.setText(rowItem.getPayout());
		holder.txtTitle.setText(rowItem.getTitle());

		return convertView;
	}

}

