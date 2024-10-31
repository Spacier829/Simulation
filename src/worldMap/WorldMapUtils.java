package worldMap;

import java.util.Random;

public class WorldMapUtils {
  public static Coordinates getRandomEmptyCell(WorldMap worldMap) {
    Random random = new Random();
    while (true) {
      int x = random.nextInt(worldMap.getWidth());
      int y = random.nextInt(worldMap.getHeight());

      Coordinates coordinates = new Coordinates(x, y);
      if (worldMap.isCellEmpty(coordinates)) {
        return coordinates;
      }
    }
  }
}
