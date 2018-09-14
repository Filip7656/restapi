package com.vps.restapi;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vps.restapi.model.User;
import com.vps.restapi.model.UserRepository;

//mapowanie rest
@RestController
@RequestMapping("/json")
public class Api {
	public static String data;
	public static String data_log;
	private static final Logger LOG = LoggerFactory.getLogger(Api.class);

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {
		System.out.println("Startuje komponent api");

	}

	public Api() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method = { RequestMethod.POST })
	public User create(@RequestBody User userData) {
		return userRepository.insert(userData);
		// sprawdzic metody
	}

	@RequestMapping(method = RequestMethod.GET)

	public List<User> getAll() {
		return userRepository.findAll();
	}

}
