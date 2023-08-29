package com.iftm.startexample.repositories;

import com.iftm.startexample.models.Developer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeveloperRepository extends MongoRepository<Developer, ObjectId> {
}
