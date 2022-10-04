package com.dev.feignsecretmanager.configuration;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class CustomBasicAuthConfiguration {

  @Value("${AUTH_CREDENTIALS}")
  private String authCredentials;

  @Bean
  public RequestInterceptor basicAuthRequestInterceptor(){
    return new CustomBasicAuthRequestInterceptor(authCredentials);
  }
}
