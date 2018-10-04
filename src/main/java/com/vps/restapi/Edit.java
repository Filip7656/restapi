package com.vps.restapi;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vps.restapi.model.User;
import com.vps.restapi.model.UserRepository;

@RequestMapping("/update")
public class Edit {
	private static final Logger LOG = LoggerFactory.getLogger(Api.class);

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {
		LOG.info("Startuje api");

	}

	@RequestMapping(method = { RequestMethod.PUT })
	public ResponseEntity<User> create(@RequestBody User userData) {
		Optional<User> userFromDatabase = userRepository.findById(userData.getUid());
		if (userFromDatabase.equals(userData)) {
			LOG.info("No change in user");
		}

		return ResponseEntity.ok(userRepository.save(userData));

	}
}