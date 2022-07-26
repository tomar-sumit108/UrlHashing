package com.example.UrlHashing.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlUtils {
	public static final String BASE_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	public static int decode(String url) {
		int id = 0;
		for(int i=0; i<url.length(); i++) {
			int ch = url.charAt(i);
			id = id*(BASE_STRING.length()) + BASE_STRING.indexOf(ch)
		}
		return id;
	}

	public static String encode(int id) {
		int base = BASE_STRING.length();
		StringBuilder sb = new StringBuilder();
		while(id > 0) {
			int index = id%base;
			sb.append(BASE_STRING.charAt(index));
			id = id/base;
		}
		return sb.toString();
	}
	
}
