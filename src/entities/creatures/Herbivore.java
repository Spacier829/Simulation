package entities.creatures;

public class Herbivore extends Creature {
  private final static int MAX_HEALTH = 5;
  private final static int SPEED = 2;

  public Herbivore() {
    super(SPEED, MAX_HEALTH);
  }

  @Override
  protected void makeMove() {
    // движение в сторону травы
  }
}
