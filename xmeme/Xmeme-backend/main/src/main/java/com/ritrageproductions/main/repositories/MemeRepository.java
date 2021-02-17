package com.ritrageproductions.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ritrageproductions.main.models.Memes;

public interface MemeRepository extends MongoRepository<Memes, Long> {

}
