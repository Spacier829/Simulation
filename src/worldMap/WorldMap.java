package worldMap;

import entities.Entity;

import java.util.HashMap;

public class WorldMap {
  HashMap<Coordinates, Entity> entities = new HashMap<>();

  public void setEntity(Coordinates coordinates, Entity entity) {
    entities.put(coordinates, entity);
  }

  public void setupDefaultEntityPosition(Entity entity) {

  }
}