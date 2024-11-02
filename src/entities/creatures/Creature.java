package entities.creatures;

import entities.Entity;
import entities.environment.DebugDown;
import entities.environment.DebugLeft;
import entities.environment.DebugRight;
import entities.environment.DebugUp;
import worldMap.Coordinates;
import worldMap.WorldMap;

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

  public void makeMove(WorldMap worldMap, Coordinates source, Coordinates target) {
    worldMap.removeEntity(source);
    if (source.getX() == target.getX()) {
      if (source.getY() < target.getY()) {
        worldMap.setEntity(source, new DebugUp());
      } else {
        worldMap.setEntity(source, new DebugDown());
      }
    } else if (source.getY() == target.getY()) {
      if (source.getX() < target.getX()) {
        worldMap.setEntity(source, new DebugRight());
      } else {
        worldMap.setEntity(source, new DebugLeft());
      }
    }
    worldMap.setEntity(target,this);
  }
}
