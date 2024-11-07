package entities.creatures;

import entities.Entity;
import worldMap.Coordinates;
import worldMap.WorldMap;

import java.util.List;

abstract public class Creature extends Entity {
  protected final int MIN_HEALTH = 0;
  protected int speed;
  protected int health;
  protected Class<? extends Entity> targetClass;
  private final int STARVE_DAMAGE_COEFFICIENT = 1;
  private int starveDamage = 1;

  public Creature(int speed, int health, Class<? extends Entity> targetClass) {
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

  public Class<? extends Entity> getTargetClass() {
    return targetClass;
  }

  public void setTargetClass(Class<? extends Entity> targetClass) {
    this.targetClass = targetClass;
  }

  public abstract void makeMove(WorldMap worldMap, Coordinates source, List<Coordinates> path);

  protected abstract void eat();

  public boolean isAlive() {
    return health > MIN_HEALTH;
  }

  protected void starve() {
    starveDamage -= starveDamage + STARVE_DAMAGE_COEFFICIENT;
    health -= starveDamage;
  }
}
