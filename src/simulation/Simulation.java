package simulation;

import actions.initActions.InitActions;
import entities.Entity;
import entities.creatures.Creature;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import entities.environment.Grass;
import worldMap.Coordinates;
import worldMap.WorldMap;
import worldMap.WorldMapRenderer;

public class Simulation {
  private WorldMap map;
  private int stepsCounter;

  public static void main(String[] args) {
    WorldMap worldMap = new WorldMap(3, 3);
    WorldMapRenderer renderer = new WorldMapRenderer();
//    Entity leo = new Predator();
    Creature zebra = new Herbivore();
    Entity grass = new Grass();
    worldMap.setEntity(new Coordinates(0,0), zebra);
    worldMap.setEntity(new Coordinates(2,2), grass);
    renderer.render(worldMap);
    System.out.println();
    zebra.makeMove(worldMap,new Coordinates(0,0), new Coordinates(1,0));
    renderer.render(worldMap);
    System.out.println();
    zebra.makeMove(worldMap,new Coordinates(1,0), new Coordinates(1,1));
    renderer.render(worldMap);
    System.out.println();
    zebra.makeMove(worldMap,new Coordinates(1,1), new Coordinates(1,2));

    renderer.render(worldMap);
//    InitActions.initSpawns(worldMap);
//    worldMap.setEntity(new Coordinates(2, 2), leo);
  }
}
