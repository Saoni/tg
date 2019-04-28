package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.dto.GameMongoDbDTO;
import com.example.dto.GameUpdateDTO;
import com.example.service.GameMongoDbService;
import org.bson.types.ObjectId;

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

@GetMapping("/helloworld")
 public ResponseEntity sayHello(){
  return ResponseEntity.ok("Hello World");
 }
}

  
  