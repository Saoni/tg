package com.example.service;

import java.util.List;
import com.example.dto.GameMongoDbDTO;
import org.bson.types.ObjectId;

public interface GameMongoDbService {
  public GameMongoDbDTO getGame(ObjectId id);
  public List getTopRank(Integer id);
  public GameMongoDbDTO getRankHistory(String name, String market);
  public List getFavorites();
  public GameMongoDbDTO setFavorites(ObjectId id);
}