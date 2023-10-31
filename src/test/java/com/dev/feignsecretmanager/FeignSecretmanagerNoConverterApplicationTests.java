package com.dev.feignsecretmanager;

import com.dev.feignsecretmanager.repository.RestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FeignSecretmanagerNoConverterApplicationTests {
	@Autowired
	private RestClient restClient;

	@Test
	void contextLoads() {
		assertNotNull(restClient.request());
	}
}
