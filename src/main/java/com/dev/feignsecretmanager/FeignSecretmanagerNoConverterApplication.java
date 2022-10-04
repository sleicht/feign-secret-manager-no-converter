package com.dev.feignsecretmanager;

import com.dev.feignsecretmanager.configuration.GcpStringGenericConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.support.DefaultConversionService;

@SpringBootApplication
public class FeignSecretmanagerNoConverterApplication {

	public static void main(String[] args) {
		//------WORK AROUND ---//
		//This way we added the missing converter for the feing client custom configuration
		DefaultConversionService dcs = (DefaultConversionService) DefaultConversionService.getSharedInstance();
		dcs.addConverter(new GcpStringGenericConverter());
		//--------------------//
		SpringApplication.run(FeignSecretmanagerNoConverterApplication.class, args);
	}

}
