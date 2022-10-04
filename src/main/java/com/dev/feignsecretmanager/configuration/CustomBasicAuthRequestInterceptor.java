package com.dev.feignsecretmanager.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class CustomBasicAuthRequestInterceptor implements RequestInterceptor {

    private String headerValue;

    public CustomBasicAuthRequestInterceptor(String authCredentials) {
        this(authCredentials, StandardCharsets.UTF_8);
    }

    public CustomBasicAuthRequestInterceptor(String authCredentials, Charset charset) {
        this.headerValue = "Basic " + new String(Base64.getEncoder().encode(authCredentials.getBytes(charset)));
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", headerValue);
    }
}
