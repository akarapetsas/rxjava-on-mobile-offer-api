/**
 * Fyber Android SDK
 * <p/>
 * Copyright (c) 2015 Fyber. All rights reserved.
 */

package com.fyber.rxjavafreakyfriday;

import android.app.Application;
import android.content.Context;

public class FyberApplication extends Application{
	public static FyberApplication instance;

	public void onCreate() {
		super.onCreate();

		instance = this;
	}

	public static Context getContext() {
		return instance;
	}

}

