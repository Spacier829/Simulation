package simulation;

import entities.Entity;
import entities.creatures.Predator;
import worldMap.Coordinates;
import worldMap.WorldMap;
import worldMap.WorldMapRenderer;

public class Simulation {
  private WorldMap map;
  private int stepsCounter;

  public static void main(String[] args) {
    WorldMap worldMap = new WorldMap(5, 5);
    WorldMapRenderer renderer = new WorldMapRenderer();
    Entity leo = new Predator();
    worldMap.setEntity(new Coordinates(2, 2), leo);
    renderer.render(worldMap);
  }

}
