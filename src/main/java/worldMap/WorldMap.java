package worldMap;

import entities.Entity;

import java.util.*;

public class WorldMap {
  private final int MIN_WIDTH = 5;
  private final int MIN_HEIGHT = 5;
  private final int width;
  private final int height;
  private Map<Coordinates, Entity> entities = new HashMap<>();

  public WorldMap(int width, int height) {
    if (width < MIN_WIDTH || height < MIN_HEIGHT) {
      throw new IllegalArgumentException("Width and height must be at least " + MIN_WIDTH + " and " + MIN_HEIGHT);
    }
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
      throw new IllegalArgumentException("Entity not set. Invalid " + coordinates);
    }
    entities.put(coordinates, entity);
  }

  public void removeEntity(Coordinates coordinates) {
    boolean isRemoved = entities.remove(coordinates) != null;
    if (!isRemoved) {
      throw new IllegalArgumentException("Entity not found. Invalid " + coordinates);
    }
  }

  public Entity getEntity(Coordinates coordinates) {
    Entity entity = entities.get(coordinates);
    if (entity == null) {
      throw new IllegalArgumentException("Coordinates not found. Invalid " + coordinates);
    }
    return entities.get(coordinates);
  }

  public Set<Coordinates> getEntitiesCoordinates() {
    if (entities.isEmpty()) {
      throw new IllegalArgumentException("Entities is empty.");
    }
    return entities.keySet();
  }

  public boolean isCellEmpty(Coordinates coordinates) {
    return !entities.containsKey(coordinates);
  }

  public boolean isMapFilled() {
    return entities.size() == width * height;
  }
}