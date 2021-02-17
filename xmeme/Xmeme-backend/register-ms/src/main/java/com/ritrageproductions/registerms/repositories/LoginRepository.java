package com.ritrageproductions.registerms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ritrageproductions.registerms.models.Login;

public interface LoginRepository extends MongoRepository<Login, String> {

}
