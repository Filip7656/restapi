package com.vps.restapi.utils;

import static org.mockito.ArgumentMatchers.any;

import java.io.IOException;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.vps.restapi.model.User;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class RestApiTest {
	@MockBean
	private EmailSender emailSender;

	@Test
	public void check() {
		RestTemplate client = new RestTemplate();
		List<User> response = client.exchange("http://localhost:8080/user/active", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				}).getBody();
		System.out.println(response);
	}

	@Test
	public void checkRegister() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException,
			EmailException, IOException, TemplateException {
		Mockito.when(emailSender.newAccountEmail(any(User.class))).thenReturn(true);
		RestTemplate client = new RestTemplate();
		User request = new User();
		request.setEmail("test");
		request.setPassword("secret");
		ResponseEntity<User> postForEntity = client.postForEntity("http://localhost:8080/user", request, User.class);
		System.out.println(postForEntity);
	}
}
