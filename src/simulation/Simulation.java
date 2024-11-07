package simulation;


import actions.Action;
import actions.initActions.InitEntitiesSpawn;
import actions.turnActions.MoveActions;
import actions.turnActions.RefillActions;
import entities.creatures.Creature;
import entities.creatures.Herbivore;
import entities.creatures.Predator;
import pathFinder.BreadthFirstSearch;
import worldMap.Coordinates;
import worldMap.WorldMap;
import worldMap.WorldMapRenderer;

public class Simulation {
  private WorldMap worldMap;
  private WorldMapRenderer renderer = new WorldMapRenderer();
  private Action initSpawnAction;
  private Action moveAction;
  private Action refillAction;
  private BreadthFirstSearch breadthFirstSearch;
  private int stepsCounter;
  private final String WELCOME_MESSAGE = "Hello! This is Simulation";
  private final String FIREWALL_MESSAGE = "Simulation finished";

  public Simulation(WorldMap worldMap) {
    this.worldMap = worldMap;
    initSpawnAction = new InitEntitiesSpawn(worldMap);
    breadthFirstSearch = new BreadthFirstSearch(worldMap);
    moveAction = new MoveActions(worldMap, breadthFirstSearch);
    refillAction = new RefillActions(worldMap);
    stepsCounter = 0;
  }

  public void start() throws InterruptedException {
    initSpawnAction.execute();
    showWelcomeMessage();
    renderer.render(worldMap);
    while (!worldMap.isMapFilled()) {
      nextTurn();
      Thread.sleep(1000);
    }
    showFirewallMessage();
  }

  private void nextTurn() {
    stepsCounter++;
    showSteps();
    moveAction.execute();
    refillAction.execute();
    renderer.render(worldMap);
  }

  private void showWelcomeMessage() {
    System.out.println(WELCOME_MESSAGE);
  }

  private void showFirewallMessage() {
    System.out.println(FIREWALL_MESSAGE);
  }

  private void showSteps() {
    System.out.println("Step: " + stepsCounter);
  }

}
