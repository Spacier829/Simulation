package entities.creatures;

import entities.environment.DeadEntity;
import entities.environment.Grass;
import worldMap.Coordinates;
import worldMap.WorldMap;

import java.util.List;

public class Herbivore extends Creature {
  protected final static int MAX_HEALTH = 10;
  protected final static int SPEED = 2;
  protected final static int HEALTH_BONUS = 5;

  public Herbivore() {
    super(SPEED, MAX_HEALTH, Grass.class);
  }

  @Override
  public void makeMove(WorldMap worldMap, Coordinates source, List<Coordinates> path) {
    Coordinates nextCoordinates = source;
    if (path.isEmpty()) {
      starve();
    } else {
      if (path.size() <= speed) {
        nextCoordinates = path.getLast();
      } else {
        nextCoordinates = path.get(speed - 1);
      }
      if (worldMap.getEntity(nextCoordinates).getClass().equals(targetClass)) {
        eat();
      } else {
        starve();
      }
    }

    worldMap.removeEntity(source);
    worldMap.setEntity(nextCoordinates, this);
    if (!isAlive()) {
      worldMap.setEntity(nextCoordinates, new DeadEntity());
    }
  }

  @Override
  protected void eat() {
    int health = this.health + HEALTH_BONUS;
    if (health >= MAX_HEALTH) {
      this.health = MAX_HEALTH;
    } else {
      this.health += HEALTH_BONUS;
    }
  }
}
