package actions.turnActions;

import actions.Action;
import actions.SpawnAction;
import entities.Entity;
import entities.creatures.Herbivore;
import entities.environment.Grass;
import worldMap.Coordinates;
import worldMap.WorldMap;

import java.util.function.Supplier;

public class RefillActions extends Action {
  private final WorldMap worldMap;
  private final int REDUCTION_FACTOR = 1;

  public RefillActions(WorldMap worldMap) {
    this.worldMap = worldMap;
  }

  @Override
  public void execute() {
    refillEntity(Grass.class, () -> new Grass());
    refillEntity(Herbivore.class, () -> new Herbivore());
  }

  private void refillEntity(Class<? extends Entity> entityClass, Supplier<Entity> entitySupplier) {
    if (getEntityCount(entityClass) == 0) {
      new SpawnAction(worldMap, entitySupplier).execute();
    }
  }

  private int getEntityCount(Class<? extends Entity> entityClass) {
    int entityCount = 0;
    for (Coordinates coordinates : worldMap.getEntitiesCoordinates()) {
      Entity entity = worldMap.getEntity(coordinates);
      if (entityClass.isInstance(entity)) {
        entityCount++;
      }
    }
    if (entityCount > 1) {
      entityCount -= REDUCTION_FACTOR;
    }
    return entityCount;
  }
}
