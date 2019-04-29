package com.example.repositories;

import java.time.Period;
import java.util.List;
import java.util.Optional;
import com.example.models.Game;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface GameRepository extends MongoRepository<Game, ObjectId> {
  @Query("{rank:{$lte : ?0}},{name:1}")
  List<Game> findGameByRank(Integer rank);

  @Query("{name:?0,market:?1},{rankWeek:1,rankMonth:1,rankYesterday:1}")
  Optional<Game> findGameByNameAndMarket(String name,String market);

  @Query("{favorite:true},{name:1}")
  List<Game> findFavoriteGames();

  @Query("{top10Entry:{$gte : ?0}},{name:1}")
  List<Game> findTop10Entry(long period);

  @Query("{top20Entry:{$gte : ?0}},{name:1}")
  List<Game> findTop20Entry(long period);

  @Query("{top50Entry:{$gte : ?0}},{name:1}")
  List<Game> findTop50Entry(long period);
}






