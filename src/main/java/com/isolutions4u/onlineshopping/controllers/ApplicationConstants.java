package com.isolutions4u.onlineshopping.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConstants {
	
	public static String oauth;
	public static String cookie;

	@Value("${env.oauth}")
	public void setOauth(String isLocal) {
		ApplicationConstants.oauth = isLocal;
	}
	
	@Value("${env.cookie}")
	public void setCookie(String isLocal) {
		ApplicationConstants.cookie = isLocal;
	}

}
