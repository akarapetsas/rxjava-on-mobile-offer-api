/**
 * Fyber Android SDK
 * <p/>
 * Copyright (c) 2015 Fyber. All rights reserved.
 */

package com.fyber.rxjavafreakyfriday.util;

import com.fyber.rxjavafreakyfriday.FyberApplication;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

public class Utils {

	public static final String API_KEY = "1c915e3b5d42d05136185030892fbb846c278927";

	/**
	 * This method generates the hash key from the alphabetically sorted
	 * parameters. The parameters are sorted with the help of
	 * a tree map(the comparator could be used as an alternative).
	 * Then from the treemap we are creating the desired String
	 * which will be hashed afterwards.
	 *
	 * @param concatenatedString
	 * @return hashkey - the requested hash key
	 */
	public static String generateHashKeyFromAlphabeticallySortedParameters(String concatenatedString) {
		String[] splitAmber = concatenatedString.split("&");

		TreeMap<String, String> sortedParameters = new TreeMap<>();

		for (String pair : splitAmber) {
			String[] keyValue = pair.split("=");
			sortedParameters.put(keyValue[0], keyValue[1]);
		}
		String parametersInAlphabeticalOrder = "";
		for (Map.Entry<String, String> entry : sortedParameters.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();

			parametersInAlphabeticalOrder += key + "=" + value + "&";
		}

		parametersInAlphabeticalOrder += API_KEY;

		String hashkey = Utils.sha1Hash(parametersInAlphabeticalOrder);

		return hashkey.toLowerCase();
	}

	public static String sha1Hash(String toHash) {
		String hash = null;

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			byte[] bytes = toHash.getBytes("UTF-8");
			digest.update(bytes, 0, bytes.length);
			bytes = digest.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : bytes) {
				sb.append(String.format("%02X", b));
			}
			hash = sb.toString();
		} catch (NoSuchAlgorithmException |UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return hash.toLowerCase();
	}

	public static String getAndroidAdId() {
		AdvertisingIdClient.Info adInfo = null;
		try {
			adInfo = AdvertisingIdClient.getAdvertisingIdInfo(FyberApplication.getContext());

		} catch (IOException | IllegalStateException | GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
			e.printStackTrace();
		}

		return adInfo.getId();
	}

	public static long getUnixTimeStamp() {
		long unixTime = System.currentTimeMillis() / 1000L;
		return unixTime;
	}


}

