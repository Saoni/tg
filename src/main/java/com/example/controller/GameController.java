package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.dto.GameMongoDbDTO;
import com.example.dto.GameUpdateDTO;
import com.example.models.Game;
import com.example.response.ErrorResponse;
import com.example.service.GameMongoDbService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/games") 
public class GameController {
  @Autowired
    private GameMongoDbService gameMongoDbService;

  @GetMapping
  public ResponseEntity<GameMongoDbDTO> getGame(@RequestParam String id) {
    ObjectId objId = new ObjectId(id);
    return ResponseEntity.ok(gameMongoDbService.getGame(objId));
  }
  @GetMapping("/getTop")
  public ResponseEntity<List> getTopRank(@RequestParam Integer topRank) {
    Integer topRankNumbers[]={10,20,50,100,200};
    List<Integer> topRankNumberList= Arrays.asList(topRankNumbers);

    if (topRankNumberList.contains(topRank)){
      return ResponseEntity.ok(gameMongoDbService.getTopRank(topRank));
    }
    return (ResponseEntity<List>) ResponseEntity.badRequest();
  }

  @GetMapping("/getRankHistory")
  public ResponseEntity<GameMongoDbDTO> getRankHistory(@RequestParam String name, String market) {
      return ResponseEntity.ok(gameMongoDbService.getRankHistory(name,market));
  }

  @GetMapping("/getTopEntry")
  public ResponseEntity<List> getTopEntry(@RequestParam Integer topEntry,Integer days){
    Integer topEntryNumbers[]={10,20,50};
    List<Integer> topEntryNumbersrList= Arrays.asList(topEntryNumbers);

    if (topEntryNumbersrList.contains(topEntry)){
      return ResponseEntity.ok(gameMongoDbService.getTopEntry(topEntry,days));
    }
    return (ResponseEntity<List>) ResponseEntity.badRequest();
  }

  @GetMapping("/getFavorites")
  public ResponseEntity<List> getFavorites(){
   return ResponseEntity.ok(gameMongoDbService.getFavorites());
  }

  @PutMapping("/setFavorites")
  public ResponseEntity<GameMongoDbDTO> setFavorites(@RequestParam String id){
  ObjectId objId = new ObjectId(id);
   return ResponseEntity.ok(gameMongoDbService.setFavorites(objId));
  }
}

  
  