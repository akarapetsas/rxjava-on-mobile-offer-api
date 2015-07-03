/**
 * Fyber Android SDK
 * <p/>
 * Copyright (c) 2015 Fyber. All rights reserved.
 */

package com.fyber.rxjavafreakyfriday.models;

public class TimeToPayout {

	private String amount;

	private String readable;

	public TimeToPayout(String amount, String readable){
		this.amount = amount;
		this.readable = readable;
	}

	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getReadable() {
		return readable;
	}
	public void setReadable(String readable) {
		this.readable = readable;
	}

}
