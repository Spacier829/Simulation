package actions.initActions;

import entities.Entity;
import worldMap.Coordinates;
import worldMap.WorldMap;

import java.util.Random;
import java.util.function.Supplier;

public class SpawnAction {
  private final int entityCount;
  private final Supplier<Entity> entitySupplier;

  public SpawnAction(int entityCount, Supplier<Entity> entitySupplier) {
    this.entityCount = entityCount;
    this.entitySupplier = entitySupplier;
  }

  public void spawnEntities(WorldMap worldMap) {
    for (int i = 0; i < entityCount; i++) {
      if (!worldMap.isMapFilled()) {
        Entity entity = entitySupplier.get();
        Coordinates coordinates = getRandomEmptyCell(worldMap);
        worldMap.setEntity(coordinates, entity);
      }
    }
  }

  private Coordinates getRandomEmptyCell(WorldMap worldMap) {
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
