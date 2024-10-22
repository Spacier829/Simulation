package simulation;

import worldMap.WorldMap;
import worldMap.WorldMapRenderer;

public class Simulation {
  private WorldMap map;
  private int stepsCounter;

  public static void main(String[] args) {
    WorldMapRenderer worldMapRenderer = new WorldMapRenderer();
    WorldMap worldMap = new WorldMap(5, 5);
    worldMapRenderer.mockSpawnMethod(worldMap);
    worldMapRenderer.render(worldMap);
  }
  // WorldMapRenderer
  // Actions - список действий, исполняемых перед стартом симуляции
}
