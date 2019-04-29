package com.example.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
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

    @Override
    public List getTopEntry(Integer topEntry, Integer days) {
    List<Game> game=new ArrayList<Game>();
    LocalDate now = LocalDate.now();
    LocalDate sixDaysBehind = now.minusDays(days);
    Period period = Period.between(now, sixDaysBehind);
    Long months=period.toTotalMonths();
    System.out.println("period "+months);
    switch(topEntry){
        case 10:
        game = gameRepository.findTop10Entry(months);
        break;
        case 20:
        game = gameRepository.findTop20Entry(months);
        break;
        case 50:
        game = gameRepository.findTop50Entry(months);
        break;
    }
    return game;
    }
}