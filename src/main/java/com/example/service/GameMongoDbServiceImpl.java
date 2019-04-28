package com.example.service;

import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.Game;
import com.example.repositories.GameRepository;
import com.example.dto.GameMongoDbDTO;

//import com.javaquery.examples.springboot.rest.exception.EntityNotFoundException;
import com.example.service.GameMongoDbService;

@Service
public class GameMongoDbServiceImpl implements GameMongoDbService {
  @Autowired
    private GameRepository gameRepository;

  @Override
    public GameMongoDbDTO getGame(ObjectId id) {
        Optional<Game> game = gameRepository.findById(id);
        return new GameMongoDbDTO().build(game);
    }
}