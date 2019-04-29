package com.example.dto;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.models.Game;
import org.bson.types.ObjectId;
import java.util.Optional;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class GameMongoDbDTO {

/* used to send database id */
private ObjectId id;

@JsonProperty("name")
private String Name;

@JsonProperty("rank")
private int rank;

@JsonProperty("rankMonth")
private int rankMonth;

@JsonProperty("rankWeek")
private int rankWeek;

@JsonProperty("rankYesterday")
private int rankYesterday;

@JsonProperty("favorite")
private boolean favorite;

  public GameMongoDbDTO() {
  }

  public GameMongoDbDTO(ObjectId id, String Name, int rank, int rankMonth, int rankWeek,int rankYesterday,boolean favorite) {
    this.id = id;
    this.Name = Name;
    this.rank = rank;
    this.rankMonth = rankMonth;
    this.rankWeek = rankWeek;
    this.rankYesterday = rankYesterday;
    this.favorite = favorite;
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

  public int getRankYesterday() {
    return this.rankYesterday;
  }

  public void setRankYesterday(int rankYesterday) {
    this.rankYesterday = rankYesterday;
  }

  public boolean getFavorite() {
    return this.favorite;
  }

  public void setFavorite(boolean favorite) {
    this.favorite = favorite;
  }

  public GameMongoDbDTO id(ObjectId id) {
    this.id = id;
    return this;
  }

  public GameMongoDbDTO Name(String Name) {
    this.Name = Name;
    return this;
  }

  public GameMongoDbDTO rank(int rank) {
    this.rank = rank;
    return this;
  }

  public GameMongoDbDTO rankMonth(int rankMonth) {
    this.rankMonth = rankMonth;
    return this;
  }

  public GameMongoDbDTO rankWeek(int rankWeek) {
    this.rankWeek = rankWeek;
    return this;
  }

  public GameMongoDbDTO rankYesterday(int rankYesterday) {
    this.rankYesterday = rankYesterday;
    return this;
  }

  public GameMongoDbDTO favorite(boolean favorite) {
    this.favorite = favorite;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GameMongoDbDTO)) {
            return false;
        }
        GameMongoDbDTO gameMongoDbDTO = (GameMongoDbDTO) o;
        return Objects.equals(id, gameMongoDbDTO.id) && Objects.equals(Name, gameMongoDbDTO.Name) && rank == gameMongoDbDTO.rank && rankMonth == gameMongoDbDTO.rankMonth && rankWeek == gameMongoDbDTO.rankWeek && rankYesterday == gameMongoDbDTO.rankYesterday && favorite == gameMongoDbDTO.favorite;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, Name, rank, rankMonth, rankWeek, rankYesterday,favorite);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", Name='" + getName() + "'" +
      ", rank='" + getRank() + "'" +
      ", rankMonth='" + getRankMonth() + "'" +
      ", rankWeek='" + getRankWeek() + "'" +
      ", rankYesterday='" + getRankYesterday() + "'" +
      ", favorite='" + getFavorite() + "'" +
      "}";
  }

public GameMongoDbDTO build(Optional<Game> game) {
 game.ifPresent(newGame -> {
  this.id = newGame.getId();
  this.Name = newGame.getName();
  this.rank = newGame.getRank();
  this.rankWeek = newGame.getRankWeek();
  this.rankMonth = newGame.getRankMonth();
  this.rankYesterday = newGame.getRankYesterday();
  this.favorite = newGame.getFavorite();
 });
return this;
}
}