package actions.initActions;

import entities.creatures.Herbivore;
import entities.creatures.Predator;
import entities.environment.Grass;
import entities.environment.Rock;
import entities.environment.Tree;
import worldMap.Coordinates;
import worldMap.WorldMap;

import java.util.Random;

public class InitActions {
  public void mockSpawnMethod(WorldMap worldMap) {
    int mapSize = worldMap.getMapSize();
    int predatorCount = (int) (mapSize * 0.12);
    int herbivoreCount = predatorCount;
    int treeCount = predatorCount;
    int rockCount = predatorCount;
    int grassCount = (int) (mapSize * 0.22);

    for (int i = 0; i < predatorCount; i++) {
      Coordinates coordinates = mockGetRandomCoordinates(worldMap);
      worldMap.setEntity(coordinates, new Predator());
    }
    for (int i = 0; i < herbivoreCount; i++) {
      Coordinates coordinates = mockGetRandomCoordinates(worldMap);
      worldMap.setEntity(coordinates, new Herbivore());
    }
    for (int i = 0; i < treeCount; i++) {
      Coordinates coordinates = mockGetRandomCoordinates(worldMap);
      worldMap.setEntity(coordinates, new Tree());
    }
    for (int i = 0; i < rockCount; i++) {
      Coordinates coordinates = mockGetRandomCoordinates(worldMap);
      worldMap.setEntity(coordinates, new Rock());
    }
    for (int i = 0; i < grassCount; i++) {
      Coordinates coordinates = mockGetRandomCoordinates(worldMap);
      worldMap.setEntity(coordinates, new Grass());
    }
  }

  protected Coordinates mockGetRandomCoordinates(WorldMap worldMap) {
    Random random = new Random();
    while (true) {
      int x = random.nextInt(worldMap.getWidth());
      int y = random.nextInt(worldMap.getWidth());

      if (worldMap.isCellEmpty(new Coordinates(x, y))) {
        return new Coordinates(x, y);
      }
    }
  }
}
