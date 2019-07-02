package com.app.security;

import org.springframework.stereotype.Component;

@Component
public class SecurityContrains {
	
	public static final long EXPIRATION_TIME=864000000; //10DAYS
	public static final String TOKEN_PREFIX="Bearer ";
	public static final String HEADER_STRING="Authorization";
	public static final String TOKEN_SECRET="mahindra_9493929220";
	
	
	public static final String SIGN_UP_URL="/users";

}
