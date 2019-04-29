package com.example.service;

import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.Game;
import com.example.repositories.GameRepository;
import com.example.dto.GameMongoDbDTO;
import com.example.exception.GameNotFoundException;
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
    @Override
    public List getTopRank(Integer rank) {
        List<Game> game = gameRepository.findGameByRank(rank);
        return game;
    }
    @Override
    public GameMongoDbDTO getRankHistory(String name,String market) {
        Optional<Game> game = gameRepository.findGameByNameAndMarket(name,market);
        System.out.println("game is valid "+game.isPresent());
        if (!game.isPresent()) {
           throw new GameNotFoundException(Game.class, name);
        }
        return new GameMongoDbDTO().build(game);
    }

    @Override
    public List getFavorites() {
        List<Game> game = gameRepository.findFavoriteGames();
        return game;
    }

    @Override
    public GameMongoDbDTO setFavorites(ObjectId id) {
        Optional<Game> game = gameRepository.findById(id);
        if (!game.isPresent()) {
            throw new GameNotFoundException(Game.class, id);
         }
        game.ifPresent(game1->{
            game1.setFavorite(true);
            gameRepository.save(game1);
        });
        return new GameMongoDbDTO().build(game);
    }
    
}