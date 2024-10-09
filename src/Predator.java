public class Predator extends Creature {
  private final int MAX_HEALTH = 10;
  private final int MIN_HEALTH = 0;

  public Predator(int speed, int healthPoint) {
    super(speed, healthPoint);
  }
  //хищник, имеет силу атаки
  // тратит ход на то, чтобы приблизиться к жертве
  // атака травоядного
  // hp жертвы -= сила атаки хищника >0
}
