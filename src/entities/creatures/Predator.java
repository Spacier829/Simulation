package entities.creatures;

import entities.environment.DeadEntity;
import worldMap.Coordinates;
import worldMap.WorldMap;

import java.util.List;

public class Predator extends Creature {
  private final static int MAX_HEALTH = 20;
  private final static int SPEED = 1;
  private final static int DAMAGE = 5;
  private final static int HEALTH_BONUS = 10;

  public Predator() {
    super(SPEED, MAX_HEALTH, Herbivore.class);
  }

  @Override
  public void makeMove(WorldMap worldMap, Coordinates source, List<Coordinates> path) {
    final int TARGET_DISTANCE_ZERO = 0;
    final int TARGET_DISTANCE_NEAR = speed - 1;

    Coordinates nextCoordinates;

    int targetDistance = path.size() - 1;
    if (targetDistance == TARGET_DISTANCE_ZERO) {
      nextCoordinates = source;
    } else if (targetDistance == TARGET_DISTANCE_NEAR) {
      nextCoordinates = path.get(targetDistance - 1);
      worldMap.removeEntity(source);
      worldMap.setEntity(nextCoordinates, this);
    } else {
      nextCoordinates = path.get(speed - 1);
      worldMap.removeEntity(source);
      worldMap.setEntity(nextCoordinates, this);
      return;
    }

    Coordinates targetCoordinates = path.get(targetDistance);
    if (worldMap.getEntity(targetCoordinates).getClass().equals(targetClass)) {
      attackTarget(worldMap, targetCoordinates);
    }
  }

  @Override
  public void eat() {
    int health = this.health + HEALTH_BONUS;
    if (health >= MAX_HEALTH) {
      this.health = MAX_HEALTH;
    } else {
      this.health += HEALTH_BONUS;
    }
  }

  public void attackTarget(WorldMap worldMap, Coordinates coordinates) {
    Creature target = (Creature) worldMap.getEntity(coordinates);
    if (target.getHealth() > DAMAGE) {
      target.setHealth(target.getHealth() - DAMAGE);
    } else {
      target.setHealth(target.getHealth() - DAMAGE);
      worldMap.removeEntity(coordinates);
      worldMap.setEntity(coordinates, new DeadEntity());
      eat();
    }
  }
}
