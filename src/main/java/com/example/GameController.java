package com.example;

import com.example.models.Game;
import com.example.repositories.GameRepository;
import org.bson.types.ObjectId;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import java.sql.Date;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@RestController
@RequestMapping("/games")
  public class GameController {
  @Autowired
  private GameRepository repository;
   
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List getAllGames() {
   return repository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Game getGamesById(@PathVariable("id") ObjectId id) {
    return repository.findBy_id(id);
   }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyGameById(@PathVariable("id") ObjectId id, @Valid @RequestBody Game games) {
   games.set_id(id);
   repository.save(games);
  }
}
  
  