package com.example.repositories;

import java.util.List;
import com.example.models.Game;
import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.CrudRepository;

@RepositoryRestResource(collectionResourceRel = "games", path = "games")
public interface GameRepository extends MongoRepository<Game, ObjectId> {
 // Game findOne(String id);
 Game findBy_id(ObjectId _id);
// List<Game> findByName(@Param("name") String name);
}



