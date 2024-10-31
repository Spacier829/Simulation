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
    entities.remove(coordinates);
  }

  public Entity getEntity(Coordinates coordinates) {
    return entities.get(coordinates);
  }

  public boolean isCellEmpty(Coordinates coordinates) {
    return !entities.containsKey(coordinates);
  }

  public boolean isMapFilled() {
    return entities.size() == mapSize;
  }
}