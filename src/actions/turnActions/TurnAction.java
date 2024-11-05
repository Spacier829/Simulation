package actions.turnActions;

import entities.Entity;
import entities.creatures.Creature;
import pathFinder.BreadthFirstSearch;
import worldMap.Coordinates;
import worldMap.WorldMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurnAction {
  private final WorldMap worldMap;
  private final BreadthFirstSearch breadthFirstSearch;

  public TurnAction(WorldMap worldMap, BreadthFirstSearch path) {
    this.worldMap = worldMap;
    this.breadthFirstSearch = path;
  }

  public void makeMove() {
    Map<Coordinates, Creature> creatures = getAllCreatures();
    for (Map.Entry<Coordinates, Creature> creature : creatures.entrySet()) {
      List<Coordinates> path = breadthFirstSearch.findPath(worldMap, creature.getKey(), creature.getValue());
      if (!path.isEmpty()) {
        creature.getValue().makeMove(worldMap, creature.getKey(), path.getFirst());
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

