/**
 * Fyber Android SDK
 * <p/>
 * Copyright (c) 2015 Fyber. All rights reserved.
 */

package com.fyber.rxjavafreakyfriday.models;

import java.util.ArrayList;

public class Offers {

	private String link;

	private String title;

	private String offer_id;

	private String teaser;

	private String required_actions;

	private String payout;

	private Thumbnails thumbnail;

	private ArrayList<OfferTypes> offer_types;

	private TimeToPayout time_to_payout;

	public Offers(String link, String title, String offer_id, String teaser, String actions,
				  String payout, Thumbnails thumbnail, ArrayList<OfferTypes> offer_types,
				  TimeToPayout time_to_payout){

		this.link = link;
		this.title = title;
		this.offer_id = offer_id;
		this.teaser = teaser;
		this.required_actions = actions;
		this.payout = payout;
		this.thumbnail = thumbnail;
		this.offer_types = offer_types;
		this.time_to_payout = time_to_payout;


	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(String offer_id) {
		this.offer_id = offer_id;
	}

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getRequired_actions() {
		return required_actions;
	}

	public void setRequired_actions(String required_actions) {
		this.required_actions = required_actions;
	}

	public String getPayout() {
		return payout;
	}

	public void setPayout(String payout) {
		this.payout = payout;
	}

	public Thumbnails getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Thumbnails thumbnail) {
		this.thumbnail = thumbnail;
	}

	public ArrayList<OfferTypes> getOffer_types() {
		return offer_types;
	}

	public void setOffer_types(ArrayList<OfferTypes> offer_types) {
		this.offer_types = offer_types;
	}

	public TimeToPayout getTime_to_payout() {
		return time_to_payout;
	}

	public void setTime_to_payout(TimeToPayout time_to_payout) {
		this.time_to_payout = time_to_payout;
	}

}
