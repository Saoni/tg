package com.example.service;

import com.example.dto.GameMongoDbDTO;
import com.example.dto.GameUpdateDTO;
import org.bson.types.ObjectId;
public interface GameMongoDbService {
  public GameMongoDbDTO getGame(ObjectId id);
}