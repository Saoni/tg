package com.example.repositories;

import java.util.List;
import com.example.models.Game;
import org.bson.types.ObjectId;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends MongoRepository<Game, ObjectId> {
}






