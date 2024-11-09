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
  private int creaturesCount;
  private int moveStoppedCount;
  private HandleEndGameAction handleEndGameAction;

  public MoveActions(WorldMap worldMap, BreadthFirstSearch breadthFirstSearch, HandleEndGameAction handleEndGameAction) {
    this.worldMap = worldMap;
    this.breadthFirstSearch = breadthFirstSearch;
    this.handleEndGameAction = handleEndGameAction;
  }

  @Override
  public void execute() {
    moveEntities();
  }

  private void moveEntities() {
    moveStoppedCount = 0;
    Map<Coordinates, Creature> creatures = getAllCreatures();
    creaturesCount = creatures.size();
    for (Map.Entry<Coordinates, Creature> creature : creatures.entrySet()) {
      Coordinates coordinates = creature.getKey();
      Creature currentCreature = creature.getValue();
      List<Coordinates> path = breadthFirstSearch.findPath(worldMap, coordinates, currentCreature);
      if (!path.isEmpty()) {
        currentCreature.makeMove(worldMap, coordinates, path);
      } else {
        moveStoppedCount++;
      }
    }
    handleEndGameAction.setGameStopped(isAllMovesStopped());
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

  private boolean isAllMovesStopped() {
    return moveStoppedCount == creaturesCount;
  }
}
