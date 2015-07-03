/**
 * Fyber Android SDK
 * <p/>
 * Copyright (c) 2015 Fyber. All rights reserved.
 */

package com.fyber.rxjavafreakyfriday.models;


public class Information {

	private String app_name;

	private String appid;

	private String virtual_currency;

	private String country;

	private String language;

	private String support_url;


	public Information(String app_name, String appid, String virtual_currency, String country, String language, String support_url) {
		this.app_name = app_name;
		this.appid = appid;
		this.virtual_currency = virtual_currency;
		this.country = country;
		this.language = language;
		this.support_url = support_url;
	}

	public String getApp_name() {
		return app_name;
	}
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}

	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getCurrency() {
		return virtual_currency;
	}
	public void setCurrency(String currency) {
		this.virtual_currency = currency;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSupport_url() {
		return support_url;
	}
	public void setSupport_url(String support_url) {
		this.support_url = support_url;
	}

}