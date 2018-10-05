package com.vps.restapi;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vps.restapi.model.User;
import com.vps.restapi.model.UserRepository;
import com.vps.restapi.utils.UserUtils;

//mapowanie rest
@RestController
@RequestMapping("/json")
public class Api {
	private static final Logger LOG = LoggerFactory.getLogger(Api.class);

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {
		LOG.info("Startuje api");
	}

	@RequestMapping(method = { RequestMethod.POST })
	public ResponseEntity<User> create(@RequestBody User userData) {
		// ==================================================================
		LOG.info("user received");
		// ==================================================================
		String email = userData.getEmail();
		if (email == null || email.isEmpty()) {
			// ==================================================================
			if (LOG.isDebugEnabled()) {
				LOG.debug("empty email");
			}
			// ==================================================================
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		Optional<User> userFromDatabase = userRepository.findById(userData.getUid());
		if (userFromDatabase.isPresent()) {
			// ==================================================================
			if (LOG.isDebugEnabled()) {
				LOG.debug("user already exist: " + email);
			}
			// ==================================================================
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.ok(userRepository.insert(userData));
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User userData) {
		Optional<User> userFromDatabase = userRepository.findById(userData.getUid());
		if (!userFromDatabase.isPresent()) {
			// ==================================================================
			if (LOG.isDebugEnabled()) {
				LOG.debug("User not found by: " + userData.getEmail());
			}
			// ==================================================================
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		User user = userFromDatabase.get();
		if (UserUtils.checkIfEqual(userData, user)) {
			LOG.info("No change in user");
			return ResponseEntity.status(HttpStatus.CONFLICT).build();

		}
		userData.setUid(user.getUid());
		return ResponseEntity.ok(userRepository.save(userData));

	}
}