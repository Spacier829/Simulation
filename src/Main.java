import simulation.Simulation;
import worldMap.WorldMap;

public class Main {
  public static void main(String[] args) {
    WorldMap worldMap = new WorldMap(10,10);
    Simulation simulation = new Simulation(worldMap);
    simulation.start();
  }
}
