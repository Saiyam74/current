package com.saiyam.login.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.saiyam.login.models.Login;

public interface LoginRepository extends MongoRepository<Login, String> {

}
