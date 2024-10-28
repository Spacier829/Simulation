package entities.creatures;

import entities.Entity;

abstract public class Creature extends Entity {
  protected final int MIN_HEALTH = 0;
  protected int speed;
  protected int health;

  public Creature(int speed, int health) {
    this.speed = speed;
    this.health = health;
  }

  protected void makeMove() {
  }
}
