/**
 * Fyber Android SDK
 * <p/>
 * Copyright (c) 2015 Fyber. All rights reserved.
 */

package com.fyber.rxjavafreakyfriday.models;


public class OfferTypes {

	private String offer_type_id;

	private String readable;

	public OfferTypes(String offer_type_id, String readable){
		this.offer_type_id = offer_type_id;
		this.readable = readable;
	}

	public String getOffer_type_id() {
		return offer_type_id;
	}
	public void setOffer_type_id(String offer_type_id) {
		this.offer_type_id = offer_type_id;
	}
	public String getReadable() {
		return readable;
	}
	public void setReadable(String readable) {
		this.readable = readable;
	}

}