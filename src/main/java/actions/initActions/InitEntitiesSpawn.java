package actions.initActions;

import actions.Action;
import actions.spawnActions.SpawnAction;
import entities.Entity;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import entities.environment.Grass;
import entities.environment.Rock;
import entities.environment.Tree;
import worldMap.WorldMap;

import java.util.List;
import java.util.function.Supplier;

public class InitEntitiesSpawn extends Action {
  private final WorldMap worldMap;

  public InitEntitiesSpawn(WorldMap worldMap) {
    this.worldMap = worldMap;
  }

  @Override
  public void execute() {
    List<Supplier<Entity>> spawnActions = List.of(
        () -> new Predator(),
        () -> new Herbivore(),
        () -> new Tree(),
        () -> new Rock(),
        () -> new Grass()
    );
    for (Supplier<Entity> entitySupplier : spawnActions) {
      new SpawnAction(worldMap, entitySupplier).execute();
    }
  }
}