package simulation;

import actions.initActions.InitActions;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulation {
  private WorldMap map;
  private int stepsCounter;

  public static void main(String[] args) {
    WorldMap worldMap = new WorldMap(5, 5);
    WorldMapRenderer renderer = new WorldMapRenderer();
//    InitActions.initSpawns(worldMap);

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

    Map<Coordinates, Creature> movableCreatures = new HashMap<>();
//    List<Coordinates> movableCreatures = new ArrayList<>();
    for (Coordinates coordinates : worldMap.getEntitiesCoordinates()) {
      Entity entity = worldMap.getEntity(coordinates);
      if (entity instanceof Creature creature) {
        movableCreatures.put (coordinates, creature);
      }
    }

    renderer.render(worldMap);

    BreadthFirstSearch bfs = new BreadthFirstSearch(worldMap);
    while (true) {
      movableCreatures.clear();
      for (Coordinates coordinates : worldMap.getEntitiesCoordinates()) {
        Entity entity = worldMap.getEntity(coordinates);
        if (entity instanceof Creature creature) {
          movableCreatures.put (coordinates, creature);
        }
      }
      for (Map.Entry<Coordinates, Creature> entry : movableCreatures.entrySet()) {
        List<Coordinates> path = bfs.findPath(worldMap, entry.getKey(), entry.getValue());
        if (!path.isEmpty()) {
          entry.getValue().makeMove(worldMap, entry.getKey(), path.getFirst());
        }
        System.out.println(path.size());
        renderer.render(worldMap);
        int a = 123;
      }
    }

    // Проверки пути, что он не равен 0, если равен - пути нет
  }
  // WorldMapRenderer
  // Actions - список действий, исполняемых перед стартом симуляции
}
