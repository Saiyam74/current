package com.ritrageproductions.registerms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ritrageproductions.registerms.models.User;

public interface UserRepository extends MongoRepository<User, String> {

}
