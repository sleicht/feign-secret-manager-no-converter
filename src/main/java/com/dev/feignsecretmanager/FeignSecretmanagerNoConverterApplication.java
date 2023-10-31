package com.dev.feignsecretmanager;

import com.dev.feignsecretmanager.configuration.GcpStringGenericConverter;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.convert.support.DefaultConversionService;

@SpringBootApplication
@EnableFeignClients
public class FeignSecretmanagerNoConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignSecretmanagerNoConverterApplication.class, args);
	}

	@PostConstruct
	public void postConstruct() {
		//------WORK AROUND ---//
		//This way we added the missing converter for the feing client custom configuration
		DefaultConversionService dcs = (DefaultConversionService) DefaultConversionService.getSharedInstance();
		dcs.addConverter(new GcpStringGenericConverter());
		//--------------------//
	}
}
