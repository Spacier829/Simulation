package worldMap;

import entities.Entity;

import java.util.*;

public class WorldMap {
  private final int width;
  private final int height;
  private Map<Coordinates, Entity> entities = new HashMap<>();

  public WorldMap(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getMapSize() {
    return width * height;
  }

  public void setEntity(Coordinates coordinates, Entity entity) {
    if (!WorldMapUtils.isValidCoordinates(this, coordinates)) {
      throw new IllegalArgumentException("Entity not set. Invalid coordinates");
    }
    entities.put(coordinates, entity);
  }

  public void removeEntity(Coordinates coordinates) {
    boolean isRemoved = entities.remove(coordinates) != null;
    if (!isRemoved) {
      throw new IllegalArgumentException("Entity not removed");
    }
  }

  public Entity getEntity(Coordinates coordinates) {
    Entity entity = entities.get(coordinates);
    if (entity == null) {
      throw new IllegalArgumentException("Coordinates not found " + coordinates);
    }
    return entities.get(coordinates);
  }

  public Set<Coordinates> getEntitiesCoordinates() {
    return entities.keySet();
  }

  public boolean isCellEmpty(Coordinates coordinates) {
    return !entities.containsKey(coordinates);
  }

  public boolean isMapFilled() {
    return entities.size() == width * height;
  }
}