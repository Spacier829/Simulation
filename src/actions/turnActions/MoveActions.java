package actions.turnActions;

import actions.Action;
import entities.Entity;
import entities.creatures.Creature;
import pathFinder.BreadthFirstSearch;
import worldMap.Coordinates;
import worldMap.WorldMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveActions extends Action {
  private final WorldMap worldMap;
  private final BreadthFirstSearch breadthFirstSearch;

  public MoveActions(WorldMap worldMap, BreadthFirstSearch breadthFirstSearch) {
    this.worldMap = worldMap;
    this.breadthFirstSearch = breadthFirstSearch;
  }

  @Override
  public void execute() {
    moveEntities();
  }

  private void moveEntities() {
    Map<Coordinates, Creature> creatures = getAllCreatures();
    for (Map.Entry<Coordinates, Creature> creature : creatures.entrySet()) {
      Coordinates coordinates = creature.getKey();
      List<Coordinates> path = breadthFirstSearch.findPath(worldMap, coordinates, creature.getValue());
      if (!path.isEmpty()) {
        creature.getValue().makeMove(worldMap, coordinates, path);
      }
    }
  }

  private Map<Coordinates, Creature> getAllCreatures() {
    Map<Coordinates, Creature> creatures = new HashMap<>();
    for (Coordinates coordinates : worldMap.getEntitiesCoordinates()) {
      Entity entity = worldMap.getEntity(coordinates);
      if (entity instanceof Creature creature) {
        creatures.put(coordinates, creature);
      }
    }
    return creatures;
  }
}
