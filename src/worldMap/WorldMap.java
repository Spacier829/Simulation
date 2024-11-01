package worldMap;

import entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {
  private final int width;
  private final int height;
  private final int mapSize;
  private Map<Coordinates, Entity> entities = new HashMap<>();

  public WorldMap(int width, int height) {
    this.width = width;
    this.height = height;
    this.mapSize = width * height;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getMapSize() {
    return mapSize;
  }

  public void setEntity(Coordinates coordinates, Entity entity) {
    entities.put(coordinates, entity);
  }

  public void removeEntity(Coordinates coordinates) {
    boolean isRemoved = entities.remove(coordinates) != null;
    if (!isRemoved) {
      throw new IllegalArgumentException("Coordinates not removed " + coordinates);
    }
  }

  public Entity getEntity(Coordinates coordinates) {
    Entity entity = entities.get(coordinates);
    if (entity == null) {
      throw new IllegalArgumentException("Coordinates not found " + coordinates);
    }
    return entities.get(coordinates);
  }

  public boolean isCellEmpty(Coordinates coordinates) {
    return !entities.containsKey(coordinates);
  }

  public boolean isMapFilled() {
    return entities.size() == mapSize;
  }
}