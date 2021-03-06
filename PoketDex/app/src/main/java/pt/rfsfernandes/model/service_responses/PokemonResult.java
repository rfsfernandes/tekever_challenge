package pt.rfsfernandes.model.service_responses;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import pt.rfsfernandes.model.SimpleModelData;

/**
 * Class PokemonResult created at 1/16/21 15:47 for the project PoketDex
 * By: rodrigofernandes
 */
@Entity
public class PokemonResult extends SimpleModelData {
  @PrimaryKey
  private int listPosition;
  private String pokemonImage;
  private boolean selected = false;

  public PokemonResult(String name, String url, int listPosition, String pokemonImage, boolean selected) {
    super(name, url);
    this.listPosition = listPosition;
    this.pokemonImage = pokemonImage;
    this.selected = selected;
  }

  public int getListPosition() {
    return listPosition;
  }

  public void setListPosition(int listPosition) {
    this.listPosition = listPosition;
  }

  public String getPokemonImage() {
    return pokemonImage;
  }

  public void setPokemonImage(String pokemonImage) {
    this.pokemonImage = pokemonImage;
  }

  public boolean isSelected() {
    return selected;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
  }

  @Override
  public String toString() {
    return "PokemonResult{" +
        "listPosition=" + listPosition +
        '}';
  }
}
