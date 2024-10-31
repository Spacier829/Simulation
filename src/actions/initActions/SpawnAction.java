package actions.initActions;

import entities.Entity;
import worldMap.Coordinates;
import worldMap.WorldMap;
import worldMap.WorldMapUtils;

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
        Coordinates coordinates = WorldMapUtils.getRandomEmptyCell(worldMap);
        worldMap.setEntity(coordinates, entity);
      }
    }
  }
}
