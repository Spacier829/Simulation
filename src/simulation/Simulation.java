package simulation;

import actions.initActions.InitActions;
import actions.turnActions.TurnAction;
import entities.Entity;
import entities.creatures.Creature;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import entities.environment.Grass;
import entities.environment.Rock;
import entities.environment.Tree;
import pathFinder.BreadthFirstSearch;
import worldMap.Coordinates;
import worldMap.WorldMap;
import worldMap.WorldMapRenderer;

public class Simulation {
  private WorldMap map;
  private int stepsCounter;

  public static void main(String[] args) {
    WorldMap worldMap = new WorldMap(5, 5);
    WorldMapRenderer renderer = new WorldMapRenderer();
//    InitActions.initSpawns(worldMap);
    BreadthFirstSearch bfs = new BreadthFirstSearch(worldMap);
    TurnAction turnAction = new TurnAction(worldMap, bfs);

    Creature zebra = new Herbivore();
    Entity grass = new Grass();
    Entity rock = new Rock();
    Entity tree = new Tree();
    Entity leo = new Predator();

    worldMap.setEntity(new Coordinates(4, 2), zebra);
    worldMap.setEntity(new Coordinates(4, 1), leo);
    worldMap.setEntity(new Coordinates(2, 2), grass);
//////    worldMap.setEntity(new Coordinates(8, 5), zebra);
//    worldMap.setEntity(new Coordinates(3, 4), rock);
//    worldMap.setEntity(new Coordinates(4, 3), rock);
//    worldMap.setEntity(new Coordinates(2, 3), rock);
//    worldMap.setEntity(new Coordinates(2, 2), tree);
//    worldMap.setEntity(new Coordinates(2, 1), tree);
    renderer.render(worldMap);

   
    // Проверки пути, что он не равен 0, если равен - пути нет
  }
  // WorldMapRenderer
  // Actions - список действий, исполняемых перед стартом симуляции
}
