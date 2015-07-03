/**
 * Fyber Android SDK
 * <p/>
 * Copyright (c) 2015 Fyber. All rights reserved.
 */

package com.fyber.rxjavafreakyfriday.models;

public class Thumbnails {

	private String lowres;
	private String hires;

	public Thumbnails(String lowres, String hires) {
		this.lowres = lowres;
		this.hires = hires;
	}

	public String getLowres() {
		return lowres;
	}
	public void setLowres(String lowres) {
		this.lowres = lowres;
	}

	public String getHires() {
		return hires;
	}
	public void setHires(String hires) {
		this.hires = hires;
	}

}
