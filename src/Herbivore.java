public class Herbivore extends Creature {
  private final int MAX_HEALTH = 5;
  private final int MIN_HEALTH = 0;

  public Herbivore(Coordinates coordinates, int speed, int healthPoint) {
    super(speed, healthPoint);
  }
  //травоядное
  // стремится найти траву, чтобы поесть и выжить, тратит ход на то, чтобы съесть траву или чтобы пойти в сторону травы
}
