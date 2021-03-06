package pt.rfsfernandes.model.pokemon;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import pt.rfsfernandes.data.local.PokemonTypeConverters;
import pt.rfsfernandes.model.SimpleModelData;
import pt.rfsfernandes.model.pokemon.moves.PokemonMoves;
import pt.rfsfernandes.model.pokemon.sprites.PokemonSprites;
import pt.rfsfernandes.model.pokemon.stats.Stats;
import pt.rfsfernandes.model.pokemon.types.PokemonType;

/**
 * Class Pokemon created at 1/16/21 14:45 for the project PoketDex
 * By: rodrigofernandes
 */
@Entity
@TypeConverters(PokemonTypeConverters.class)
public class Pokemon {

  @SerializedName("base_experience")
  private int baseExperience;

  @SerializedName("height")
  private int height;

  @SerializedName("weight")
  private int weight;

  @SerializedName("moves")

  private List<PokemonMoves> mMoveslist;

  @SerializedName("name")
  private String name;

  @SerializedName("id")
  @PrimaryKey
  private int id;

  @SerializedName("species")
  private SimpleModelData speciesInfo;

  @SerializedName("stats")
  private List<Stats> statsList;

  @SerializedName("types")
  private List<PokemonType> typeList;

  @SerializedName("sprites")
  private PokemonSprites sprites;

  public Pokemon(int baseExperience, int height, int weight, List<PokemonMoves> moveslist, String name, int id, SimpleModelData speciesInfo, List<Stats> statsList, List<PokemonType> typeList, PokemonSprites sprites) {
    this.baseExperience = baseExperience;
    this.height = height;
    this.weight = weight;
    this.mMoveslist = moveslist;
    this.name = name;
    this.id = id;
    this.speciesInfo = speciesInfo;
    this.statsList = statsList;
    this.typeList = typeList;
    this.sprites = sprites;
  }

  public int getBaseExperience() {
    return baseExperience;
  }

  public void setBaseExperience(int baseExperience) {
    this.baseExperience = baseExperience;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public List<PokemonMoves> getMoveslist() {
    return mMoveslist;
  }

  public void setMoveslist(List<PokemonMoves> moveslist) {
    this.mMoveslist = moveslist;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public SimpleModelData getSpeciesInfo() {
    return speciesInfo;
  }

  public void setSpeciesInfo(SimpleModelData speciesInfo) {
    this.speciesInfo = speciesInfo;
  }

  public List<Stats> getStatsList() {
    return statsList;
  }

  public void setStatsList(List<Stats> statsList) {
    this.statsList = statsList;
  }

  public List<PokemonType> getTypeList() {
    return typeList;
  }

  public void setTypeList(List<PokemonType> typeList) {
    this.typeList = typeList;
  }

  public PokemonSprites getSprites() {
    return sprites;
  }

  public void setSprites(PokemonSprites sprites) {
    this.sprites = sprites;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Pokemon{" +
        "baseExperience=" + baseExperience +
        ", height=" + height +
        ", weight=" + weight +
        ", moveslist=" + mMoveslist +
        ", name='" + name + '\'' +
        ", id=" + id +
        ", speciesInfo=" + speciesInfo +
        ", statsList=" + statsList +
        ", typeList=" + typeList +
        ", sprites=" + sprites +
        '}';
  }
}
