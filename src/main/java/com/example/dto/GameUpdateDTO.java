package com.example.dto;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameUpdateDTO {
    
@JsonProperty("name")
private String Name;
 
@JsonProperty("rank")
private int rank;
 

  public GameUpdateDTO() {
  }

  public GameUpdateDTO(String Name, int rank) {
    this.Name = Name;
    this.rank = rank;
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

  public GameUpdateDTO Name(String Name) {
    this.Name = Name;
    return this;
  }

  public GameUpdateDTO rank(int rank) {
    this.rank = rank;
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
        return Objects.equals(Name, gameUpdateDTO.Name) && rank == gameUpdateDTO.rank;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Name, rank);
  }

  @Override
  public String toString() {
    return "{" +
      " Name='" + getName() + "'" +
      ", rank='" + getRank() + "'" +
      "}";
  }
 
}