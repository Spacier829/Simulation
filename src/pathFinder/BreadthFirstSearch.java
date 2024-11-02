package pathFinder;

import entities.creatures.Creature;
import entities.environment.DebugVisited;
import entities.environment.Grass;
import entities.Entity;
import entities.environment.DebugVisited;
import worldMap.Coordinates;
import worldMap.WorldMap;
import worldMap.WorldMapRenderer;
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

  public List<Coordinates> findPath(WorldMap worldMap, Coordinates coordinates, Creature creature) {
    queue = new LinkedList<>();
    visitedCells = new ArrayList<>();
    coordinatesConnections = new HashMap<>();
    this.creature = creature;
    WorldMapRenderer renderer = new WorldMapRenderer();

    queue.offer(coordinates);

    while (!queue.isEmpty()) {
      coordinates = queue.remove();
      visitedCells.add(coordinates);

      // Проверка, что мы достигли необходимой цели
      if (isAchievedTarget(coordinates)){
        return visitedCells;
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
            isCanVisit(shift)
            //&& isCanMove(coordinates)
        ) {
          // Временная проверка, что мы достигли цели
          if (!isAchievedTarget(shift)) {
            worldMap.setEntity(shift, new DebugVisited());
          } else {
            coordinatesConnections.put(shift, coordinates);
            return visitedCells;
          }
          renderer.render(worldMap);
          System.out.println();
          queue.offer(shift);
          coordinatesConnections.put(shift, coordinates);
        }
      }
    }
    return visitedCells;
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
