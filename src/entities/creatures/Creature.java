package entities.creatures;

import entities.Entity;
import entities.environment.Debug;
import entities.environment.Tree;
import worldMap.Coordinates;
import worldMap.WorldMap;
import worldMap.WorldMapRenderer;

abstract public class Creature extends Entity {
  protected final int MIN_HEALTH = 0;
  protected int speed;
  protected int health;
  protected String targetClass;

  public Creature(int speed, int health, String targetClass) {
    this.speed = speed;
    this.health = health;
    this.targetClass = targetClass;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public String getTargetClass() {
    return targetClass;
  }

  public void setTargetClass(String targetClass) {
    this.targetClass = targetClass;
  }

  public void makeMove(WorldMap worldMap, Coordinates source, Coordinates nextCoordinates) {
    System.out.println(worldMap.getEntity(source).getClass().getSimpleName() + "\nSource: " + source + " target: " + nextCoordinates);
    worldMap.removeEntity(source);

//    worldMap.setEntity(source, new Debug());

    worldMap.setEntity(nextCoordinates, this);
  }
}
