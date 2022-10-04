package com.dev.feignsecretmanager.repository;

import com.dev.feignsecretmanager.configuration.CustomBasicAuthConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "restClient", url = "${REST_URL}", configuration = CustomBasicAuthConfiguration.class)
public interface RestClient {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String request();
}
