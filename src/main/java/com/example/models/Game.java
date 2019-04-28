package com.example.models;

import java.util.Objects;

import java.util.Date;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "games")
public class Game {
@Id
public ObjectId id;

@Field("name")
private String Name;

@Field("dataCreated")
private Long dataCreated = (new Date().getTime())/ 1000;
 
@Field("dataModified")
private Long dataModified  = (new Date().getTime())/ 1000;

@Field("rank")
private int rank;

@Field("rankMonth")
private int rankMonth;

@Field("rankWeek")
private int rankWeek;


  public Game() {
  }

  public Game(ObjectId id, String Name, Long dataCreated, Long dataModified, int rank, int rankMonth, int rankWeek) {
    this.id = id;
    this.Name = Name;
    this.dataCreated = dataCreated;
    this.dataModified = dataModified;
    this.rank = rank;
    this.rankMonth = rankMonth;
    this.rankWeek = rankWeek;
  }

  public ObjectId getId() {
    return this.id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getName() {
    return this.Name;
  }

  public void setName(String Name) {
    this.Name = Name;
  }

  public Long getDataCreated() {
    return this.dataCreated;
  }

  public void setDataCreated(Long dataCreated) {
    this.dataCreated = dataCreated;
  }

  public Long getDataModified() {
    return this.dataModified;
  }

  public void setDataModified(Long dataModified) {
    this.dataModified = dataModified;
  }

  public int getRank() {
    return this.rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public int getRankMonth() {
    return this.rankMonth;
  }

  public void setRankMonth(int rankMonth) {
    this.rankMonth = rankMonth;
  }

  public int getRankWeek() {
    return this.rankWeek;
  }

  public void setRankWeek(int rankWeek) {
    this.rankWeek = rankWeek;
  }

  public Game id(ObjectId id) {
    this.id = id;
    return this;
  }

  public Game Name(String Name) {
    this.Name = Name;
    return this;
  }

  public Game dataCreated(Long dataCreated) {
    this.dataCreated = dataCreated;
    return this;
  }

  public Game dataModified(Long dataModified) {
    this.dataModified = dataModified;
    return this;
  }

  public Game rank(int rank) {
    this.rank = rank;
    return this;
  }

  public Game rankMonth(int rankMonth) {
    this.rankMonth = rankMonth;
    return this;
  }

  public Game rankWeek(int rankWeek) {
    this.rankWeek = rankWeek;
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
        return Objects.equals(id, game.id) && Objects.equals(Name, game.Name) && Objects.equals(dataCreated, game.dataCreated) && Objects.equals(dataModified, game.dataModified) && rank == game.rank && rankMonth == game.rankMonth && rankWeek == game.rankWeek;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, Name, dataCreated, dataModified, rank, rankMonth, rankWeek);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", Name='" + getName() + "'" +
      ", dataCreated='" + getDataCreated() + "'" +
      ", dataModified='" + getDataModified() + "'" +
      ", rank='" + getRank() + "'" +
      ", rankMonth='" + getRankMonth() + "'" +
      ", rankWeek='" + getRankWeek() + "'" +
      "}";
  }
}
