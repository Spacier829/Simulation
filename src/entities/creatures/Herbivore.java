package entities.creatures;

public class Herbivore extends Creature {
  private final static int MAX_HEALTH = 5;
  private final static int SPEED = 1;

  public Herbivore() {
    super(SPEED, MAX_HEALTH, "Grass");
  }

  @Override
  protected void makeMove() {
    // движение в сторону травы
  }
}
