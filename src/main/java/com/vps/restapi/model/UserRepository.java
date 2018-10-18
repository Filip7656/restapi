package com.vps.restapi.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	// empty

	public Optional<User> findByToken(int token);
	// empty
}
