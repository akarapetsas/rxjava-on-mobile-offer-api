/**
 * Fyber Android SDK
 * <p/>
 * Copyright (c) 2015 Fyber. All rights reserved.
 */

package com.fyber.rxjavafreakyfriday.models;

import java.util.ArrayList;

public class BaseJSONResponse {

	private String code;

	private String message;

	private int count;

	private int pages;

	private Information information;

	private ArrayList<Offers> offers;

	public BaseJSONResponse(String code, String message, int count, int pages, Information information, ArrayList<Offers> offers) {
		this.code = code;
		this.message = message;
		this.count = count;
		this.pages = pages;
		this.information = information;
		this.offers = offers;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public ArrayList<Offers> getOffers() {
		return offers;
	}

	public void setOffers(ArrayList<Offers> offers) {
		this.offers = offers;
	}

}