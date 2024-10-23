package actions.initActions;

import entities.creatures.Herbivore;
import entities.creatures.Predator;
import entities.environment.Grass;
import entities.environment.Rock;
import entities.environment.Tree;
import worldMap.WorldMap;

public class InitActions {

  public void initSpawns(WorldMap worldMap) {
    int predatorCount = (int) (worldMap.getMapSize() * 0.12);
    int herbivoreCount = (int) (worldMap.getMapSize() * 0.12);
    int treeCount = (int) (worldMap.getMapSize() * 0.11);
    int rockCount = (int) (worldMap.getMapSize() * 0.09);
    int grassCount = (int) (worldMap.getMapSize() * 0.09);

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
