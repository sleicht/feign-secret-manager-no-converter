package com.dev.feignsecretmanager.repository;

import com.dev.feignsecretmanager.configuration.CustomBasicAuthConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "restClient", url = "${REST_URL}", configuration = CustomBasicAuthConfiguration.class)
public interface RestClient {

    @GetMapping("/todos/1")
    String request();
}
