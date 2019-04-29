package com.example.dto;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameUpdateDTO {
    
@JsonProperty("name")
private String Name;
 
@JsonProperty("rank")
private int rank;

@JsonProperty("favorite")
private boolean favorite;
 

  public GameUpdateDTO() {
  }

  public GameUpdateDTO(String Name, int rank, boolean favorite) {
    this.Name = Name;
    this.rank = rank;
    this.favorite=favorite;
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

  public boolean getFavorite() {
    return this.favorite;
  }

  public void setFavorite(boolean favorite) {
    this.favorite = favorite;
  }

  public GameUpdateDTO Name(String Name) {
    this.Name = Name;
    return this;
  }

  public GameUpdateDTO rank(int rank) {
    this.rank = rank;
    return this;
  }

  public GameUpdateDTO favorite(boolean favorite) {
    this.favorite = favorite;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GameUpdateDTO)) {
            return false;
        }
        GameUpdateDTO gameUpdateDTO = (GameUpdateDTO) o;
        return Objects.equals(Name, gameUpdateDTO.Name) && rank == gameUpdateDTO.rank && favorite == gameUpdateDTO.favorite;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Name, rank, favorite);
  }

  @Override
  public String toString() {
    return "{" +
      " Name='" + getName() + "'" +
      ", rank='" + getRank() + "'" +
      ", favorite='" + getFavorite() + "'" +
      "}";
  }
 
}