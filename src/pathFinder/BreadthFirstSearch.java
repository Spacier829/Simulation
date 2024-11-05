package pathFinder;

import entities.creatures.Creature;
import worldMap.Coordinates;
import worldMap.WorldMap;
import worldMap.WorldMapUtils;

import java.util.*;

public class BreadthFirstSearch {
  private Queue<Coordinates> queue;
  private List<Coordinates> visitedCells;
  private Map<Coordinates, Coordinates> coordinatesConnections;
  private final WorldMap worldMap;
  private Creature creature;

  public BreadthFirstSearch(WorldMap worldMap) {
    this.worldMap = worldMap;
  }

  public List<Coordinates> findPath(WorldMap worldMap, Coordinates startCoordinates, Creature creature) {
    queue = new LinkedList<>();
    visitedCells = new ArrayList<>();
    coordinatesConnections = new HashMap<>();
    this.creature = creature;

    queue.offer(startCoordinates);

    while (!queue.isEmpty()) {
      Coordinates coordinates = queue.remove();
      visitedCells.add(coordinates);

      if (isAchievedTarget(coordinates)) {
        return getResultPath(startCoordinates, coordinates);
      }

      int x = coordinates.getX();
      int y = coordinates.getY();

      List<Coordinates> coordinateShift = new ArrayList<>();
      coordinateShift.add(new Coordinates(x + 1, y));
      coordinateShift.add(new Coordinates(x - 1, y));
      coordinateShift.add(new Coordinates(x, y + 1));
      coordinateShift.add(new Coordinates(x, y - 1));

      for (Coordinates shift : coordinateShift) {
        if (WorldMapUtils.isValidCoordinates(worldMap, shift) &&
            isCanVisit(shift) && isCanMove(shift)
        ) {
          queue.offer(shift);
          coordinatesConnections.put(shift, coordinates);
        }
      }
    }
    visitedCells.clear();
    return visitedCells;
  }

  private List<Coordinates> getResultPath(Coordinates startCoordinates, Coordinates finishCoordinates) {
    List<Coordinates> path = new ArrayList<>();

    while (!finishCoordinates.equals(startCoordinates)) {
      path.add(finishCoordinates);
      finishCoordinates = coordinatesConnections.get(finishCoordinates);
    }
    return path.reversed();
  }

  private boolean isCanVisit(Coordinates coordinates) {
    return !visitedCells.contains(coordinates) && !queue.contains(coordinates);
  }

  private boolean isAchievedTarget(Coordinates coordinates) {
    if (!worldMap.isCellEmpty(coordinates)) {
      String entityClass = worldMap.getEntity(coordinates).getClass().getSimpleName();
      return (creature.getTargetClass().equals(entityClass));
    }
    return false;
  }

  private boolean isCanMove(Coordinates coordinates) {
    return worldMap.isCellEmpty(coordinates) || isAchievedTarget(coordinates);
  }
}
