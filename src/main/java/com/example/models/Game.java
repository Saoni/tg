package com.example.models;

import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "games")
public class Game {
 @Id
 ObjectId _id;
 String name;
 Integer rankWeek;
 Integer rank;


  public Game() {
  }

  public Game(ObjectId _id, String name, Integer rankWeek, Integer rank) {
    this._id = _id;
    this.name = name;
    this.rankWeek = rankWeek;
    this.rank = rank;
  }

  public ObjectId get_id() {
    return this._id;
  }

  public void set_id(ObjectId _id) {
    this._id = _id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getRankWeek() {
    return this.rankWeek;
  }

  public void setRankWeek(Integer rankWeek) {
    this.rankWeek = rankWeek;
  }

  public Integer getRank() {
    return this.rank;
  }

  public void setRank(Integer rank) {
    this.rank = rank;
  }


  public Game _id(ObjectId _id) {
    this._id = _id;
    return this;
  }

  public Game name(String name) {
    this.name = name;
    return this;
  }

  public Game rankWeek(Integer rankWeek) {
    this.rankWeek = rankWeek;
    return this;
  }

  public Game rank(Integer rank) {
    this.rank = rank;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Game)) {
            return false;
        }
        Game game = (Game) o;
        return Objects.equals(_id, game._id) && Objects.equals(name, game.name) && Objects.equals(rankWeek, game.rankWeek) && Objects.equals(rank, game.rank);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_id, name, rankWeek, rank);
  }

  @Override
  public String toString() {
    return "{" +
      " _id='" + get_id() + "'" +
      ", name='" + getName() + "'" +
      ", rankWeek='" + getRankWeek() + "'" +
      ", rank='" + getRank() + "'" +
      "}";
  }
  
  
 


 
 
 
 
 }
