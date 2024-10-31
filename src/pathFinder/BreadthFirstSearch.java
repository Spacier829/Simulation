package pathFinder;

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
  private Map<Coordinates, Coordinates> coordinateConnections;

  public List<Coordinates> findPath(WorldMap worldMap, Coordinates startCoordinates, Entity target) {
    queue = new LinkedList<>();
    visitedCells = new ArrayList<>();
    coordinateConnections = new HashMap<>();
    WorldMapRenderer renderer = new WorldMapRenderer();

    queue.add(startCoordinates);

    while (!queue.isEmpty()) {
      startCoordinates = queue.remove();
      visitedCells.add(startCoordinates);

      int x = startCoordinates.getX();
      int y = startCoordinates.getY();

      List<Coordinates> coordinateShifts = new ArrayList<>();

      coordinateShifts.add(new Coordinates(x + 1, y));
      coordinateShifts.add(new Coordinates(x - 1, y));
      coordinateShifts.add(new Coordinates(x, y + 1));
      coordinateShifts.add(new Coordinates(x, y - 1));

      for (Coordinates shift : coordinateShifts) {
        if (WorldMapUtils.isValidCoordinates(worldMap, shift) &&
            isCanVisit(shift) &&
            worldMap.isCellEmpty(shift)) {
          worldMap.setEntity(shift, new DebugVisited());
          renderer.render(worldMap);
          System.out.println();
          queue.offer(shift);
          coordinateConnections.put(shift, startCoordinates);
        }
      }
    }
    return visitedCells;
  }

  private boolean isCanVisit(Coordinates coordinates) {
    return !visitedCells.contains(coordinates) && !queue.contains(coordinates);
  }

//  private boolean isCanMove(WorldMap worldMap) {
//    return worldMap.isCellEmpty();
//  }
}
