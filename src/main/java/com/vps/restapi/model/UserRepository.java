package com.vps.restapi.model;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	public Optional<User> findByEmail(String email);
	// empty

	public Optional<User> findByToken(int token);
	// empty
}