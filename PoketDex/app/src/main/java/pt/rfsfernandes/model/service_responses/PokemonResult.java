package pt.rfsfernandes.model.service_responses;

import pt.rfsfernandes.custom.Constants;
import pt.rfsfernandes.model.SimpleModelData;

/**
 * Class PokemonResult created at 1/16/21 15:47 for the project PoketDex
 * By: rodrigofernandes
 */
public class PokemonResult extends SimpleModelData {
  private int listPosition;
  private String pokemonImage;

  public PokemonResult(String name) {
    super(name);
  }


  public int getListPosition() {
    return listPosition;
  }

  public String getPokemonImage() {
    return pokemonImage;
  }

  public void setListPosition(int listPosition) {
    this.listPosition = listPosition;
    this.pokemonImage = Constants.ARTWORK_URL.replace("{pokemonId}",
        String.valueOf(this.listPosition));
  }

  @Override
  public String toString() {
    return "PokemonResult{" +
        "listPosition=" + listPosition +
        '}';
  }
}