package actions.initActions;

import entities.Entity;
import worldMap.Coordinates;
import worldMap.WorldMap;

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
        Coordinates coordinates = worldMap.getRandomEmptyCell();
        worldMap.setEntity(coordinates, entity);
      }
    }
  }
}
