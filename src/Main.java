import simulation.Simulation;
import worldMap.WorldMap;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    WorldMap worldMap = new WorldMap(4, 4);
    Simulation simulation = new Simulation(worldMap);
    simulation.start();
  }
}
