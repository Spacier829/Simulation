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

public class Simulation {
  private WorldMap map;
  private int stepsCounter;

  public static void main(String[] args) {
    WorldMap worldMap = new WorldMap(5,5);
    WorldMapRenderer renderer = new WorldMapRenderer();

    Creature zebra = new Herbivore();
    Entity grass = new Grass();
    Entity rock = new Rock();
    String test = Grass.class.getSimpleName();

    worldMap.setEntity(new Coordinates(2,2), zebra);
    worldMap.setEntity(new Coordinates(1,2), grass);
    worldMap.setEntity(new Coordinates(1,3), rock);

    BreadthFirstSearch bfs = new BreadthFirstSearch(worldMap);
    bfs.findPath(worldMap, new Coordinates(2,2), zebra);
  }
  // WorldMapRenderer
  // Actions - список действий, исполняемых перед стартом симуляции
}
