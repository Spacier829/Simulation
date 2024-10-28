package worldMap;

import entities.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

  public Coordinates getRandomEmptyCell() {
    Random random = new Random();
    while (true) {
      int x = random.nextInt(this.width);
      int y = random.nextInt(this.height);

      Coordinates coordinates = new Coordinates(x, y);
      if (this.isCellEmpty(coordinates)) {
        return coordinates;
      }
    }
  }

  public boolean isMapFilled() {
    return entities.size() == mapSize;
  }
}