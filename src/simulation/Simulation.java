package simulation;

import entities.Entity;
import entities.creatures.Creature;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import entities.environment.Grass;
import entities.environment.Rock;
import pathFinder.BreadthFirstSearch;
import worldMap.Coordinates;
import worldMap.WorldMap;
import worldMap.WorldMapRenderer;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
  private WorldMap map;
  private int stepsCounter;

  public static void main(String[] args) {
    WorldMap worldMap = new WorldMap(12, 12);
    WorldMapRenderer renderer = new WorldMapRenderer();

    Creature zebra = new Herbivore();
    Entity grass = new Grass();
    Entity rock = new Rock();

    worldMap.setEntity(new Coordinates(11, 11), zebra);
    worldMap.setEntity(new Coordinates(2, 0), zebra);
    worldMap.setEntity(new Coordinates(1, 1), grass);
    worldMap.setEntity(new Coordinates(8, 5), zebra);
    worldMap.setEntity(new Coordinates(1, 3), rock);
    worldMap.setEntity(new Coordinates(2, 6), rock);

    List<Coordinates> movableCreatures = new ArrayList<>();
    for (Coordinates coordinates : worldMap.getEntitiesCoordinates()) {
      Entity entity = worldMap.getEntity(coordinates);
      if (entity instanceof Creature) {
        movableCreatures.add(coordinates);
      }
    }

    renderer.render(worldMap);

    BreadthFirstSearch bfs = new BreadthFirstSearch(worldMap);
    for (Coordinates coordinates : movableCreatures) {
      List<Coordinates> path = bfs.findPath(worldMap, coordinates, zebra);
    }
    // Проверки пути, что он не равен 0, если равен - пути нет
    int a = 123;
  }
  // WorldMapRenderer
  // Actions - список действий, исполняемых перед стартом симуляции
}
