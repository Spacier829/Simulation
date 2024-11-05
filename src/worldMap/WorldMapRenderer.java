package worldMap;

import entities.Entity;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import entities.environment.*;

public class WorldMapRenderer {
  public static final String HERBIVORE = "\uD83E\uDD93";
  public static final String PREDATOR = "\uD83E\uDD81";
  public static final String GROUND = "\uD83D\uDFEB";
  public static final String GRASS = "\uD83C\uDF3F";
  public static final String ROCK = "\uD83D\uDDFF";
  public static final String TREE = "\uD83C\uDF34";
  public static final String DEBUG = "\uD83D\uDD00";

  public void render(WorldMap worldMap) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int y = worldMap.getHeight() - 1; y >= 0; y--) {
      stringBuilder.setLength(0);
      for (int x = 0; x < worldMap.getWidth(); x++) {
        Coordinates coordinates = new Coordinates(x, y);
        if (!worldMap.isCellEmpty(coordinates)) {
          String entitySprite = getSpriteForEntity(worldMap.getEntity(coordinates));
          stringBuilder.append(entitySprite);
        } else {
          stringBuilder.append(GROUND);
        }
      }
      stringBuilder.append(y);
      System.out.println(stringBuilder);
    }
    // Потом удалить этот вывод
    stringBuilder.setLength(0);
    for (int i = 0; i < worldMap.getWidth(); i++) {
      stringBuilder.append(" " + i);
    }
    System.out.println(stringBuilder);
  }

  private String getSpriteForEntity(Entity entity) {
    if (entity instanceof Herbivore) {
      return HERBIVORE;
    } else if (entity instanceof Predator) {
      return PREDATOR;
    } else if (entity instanceof Grass) {
      return GRASS;
    } else if (entity instanceof Rock) {
      return ROCK;
    } else if (entity instanceof Tree) {
      return TREE;
    } else if (entity instanceof Debug) {
      return DEBUG;
    }
    throw new IllegalArgumentException("Unsupported entity type: " + entity.getClass().getName());
  }
}
