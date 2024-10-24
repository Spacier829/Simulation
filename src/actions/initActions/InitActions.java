package actions.initActions;

import entities.creatures.Herbivore;
import entities.creatures.Predator;
import entities.environment.Grass;
import entities.environment.Rock;
import entities.environment.Tree;
import worldMap.WorldMap;

public class InitActions {
  private static final double PREDATOR_POPULATION_COEFFICIENT = 0.12;
  private static final double HERBIVORE_POPULATION_COEFFICIENT = 0.12;
  private static final double TREE_POPULATION_COEFFICIENT = 0.11;
  private static final double ROCK_POPULATION_COEFFICIENT = 0.09;
  private static final double GRASS_POPULATION_COEFFICIENT = 0.09;

  public void initSpawns(WorldMap worldMap) {
    int predatorCount = (int) (worldMap.getMapSize() * PREDATOR_POPULATION_COEFFICIENT);
    int herbivoreCount = (int) (worldMap.getMapSize() * HERBIVORE_POPULATION_COEFFICIENT);
    int treeCount = (int) (worldMap.getMapSize() * TREE_POPULATION_COEFFICIENT);
    int rockCount = (int) (worldMap.getMapSize() * ROCK_POPULATION_COEFFICIENT);
    int grassCount = (int) (worldMap.getMapSize() * GRASS_POPULATION_COEFFICIENT);

    SpawnAction predatorSpawnAction = new SpawnAction(predatorCount, () -> new Predator());
    predatorSpawnAction.spawnEntities(worldMap);
    SpawnAction herbivoreSpawnAction = new SpawnAction(herbivoreCount, () -> new Herbivore());
    herbivoreSpawnAction.spawnEntities(worldMap);
    SpawnAction treeSpawnAction = new SpawnAction(treeCount, () -> new Tree());
    treeSpawnAction.spawnEntities(worldMap);
    SpawnAction rockSpawnAction = new SpawnAction(rockCount, () -> new Rock());
    rockSpawnAction.spawnEntities(worldMap);
    SpawnAction grassSpawnAction = new SpawnAction(grassCount, () -> new Grass());
    grassSpawnAction.spawnEntities(worldMap);
  }
}
