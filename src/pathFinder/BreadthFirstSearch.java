package pathFinder;

import entities.creatures.Creature;
import worldMap.Coordinates;
import worldMap.WorldMap;
import worldMap.WorldMapRenderer;
import worldMap.WorldMapUtils;

import java.util.*;

public class BreadthFirstSearch {
  private Queue<Coordinates> queue;
  private List<Coordinates> visitedCells;
  private Map<Coordinates, Coordinates> coordinatesConnections;

  public List<Coordinates> findPath(WorldMap worldMap, Coordinates coordinates, Creature creature) {
    queue = new LinkedList<>();
    List<Coordinates> visitedCells = new ArrayList<>();
    coordinatesConnections = new HashMap<>();
    WorldMapRenderer renderer = new WorldMapRenderer();

    queue.add(coordinates);

    return visitedCells;
  }
}
}
