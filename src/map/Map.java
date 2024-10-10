package map;

import entities.Entity;

import java.util.HashMap;

public class Map {
  HashMap<Coordinates, Entity> entities = new HashMap<>();

  public void setEntity(Coordinates coordinates, Entity entity) {
    entity.coordinates = coordinates;
    entities.put(coordinates, entity);
  }

  public void setupDefaultEntityPosition(Entity entity) {

  }
}
