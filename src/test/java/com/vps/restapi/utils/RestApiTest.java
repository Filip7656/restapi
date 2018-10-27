package com.vps.restapi.utils;

import java.util.List;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.vps.restapi.model.User;

public class RestApiTest {
	@Test
	public void check() {
		RestTemplate client = new RestTemplate();
		List<User> response = client.exchange("http://localhost:8080/user/active", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				}).getBody();
		System.out.println(response);
	}

}
