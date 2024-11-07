package actions;

import entities.Entity;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import entities.environment.Grass;
import entities.environment.Rock;
import entities.environment.Tree;
import worldMap.Coordinates;
import worldMap.WorldMap;
import worldMap.WorldMapUtils;

import java.util.function.Supplier;

public class SpawnAction extends Action {
  private final WorldMap worldMap;
  private final Supplier<Entity> entitySupplier;

  public SpawnAction(WorldMap worldMap, Supplier<Entity> entitySupplier) {
    this.worldMap = worldMap;
    this.entitySupplier = entitySupplier;
  }

  @Override
  public void execute() {
    spawnEntities();
  }

  private void spawnEntities() {
    int entityCount = getEntityCount();
    for (int i = 0; i < entityCount; i++) {
      if (!worldMap.isMapFilled()) {
        Entity entity = entitySupplier.get();
        Coordinates coordinates = WorldMapUtils.getRandomEmptyCell(worldMap);
        worldMap.setEntity(coordinates, entity);
      }
    }
  }

  private int getEntityCount() {
    final double PREDATOR_POPULATION_COEFFICIENT = 0.1;
    final double HERBIVORE_POPULATION_COEFFICIENT = 0.1;
    final double TREE_POPULATION_COEFFICIENT = 0.08;
    final double ROCK_POPULATION_COEFFICIENT = 0.07;
    final double GRASS_POPULATION_COEFFICIENT = 0.12;

    int predatorCount = (int) (worldMap.getMapSize() * PREDATOR_POPULATION_COEFFICIENT);
    int herbivoreCount = (int) (worldMap.getMapSize() * HERBIVORE_POPULATION_COEFFICIENT);
    int treeCount = (int) (worldMap.getMapSize() * TREE_POPULATION_COEFFICIENT);
    int rockCount = (int) (worldMap.getMapSize() * ROCK_POPULATION_COEFFICIENT);
    int grassCount = (int) (worldMap.getMapSize() * GRASS_POPULATION_COEFFICIENT);

    if (entitySupplier.get() instanceof Predator) {
      return predatorCount;
    } else if (entitySupplier.get() instanceof Herbivore) {
      return herbivoreCount;
    } else if (entitySupplier.get() instanceof Tree) {
      return treeCount;
    } else if (entitySupplier.get() instanceof Rock) {
      return rockCount;
    } else if (entitySupplier.get() instanceof Grass) {
      return grassCount;
    }
    return 0;
  }
}
