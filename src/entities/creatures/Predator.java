package entities.creatures;

public class Predator extends Creature {
  private final static int MAX_HEALTH = 10;
  private final static int SPEED = 1;
  private final static int DAMAGE = 5;

  public Predator() {
    super(SPEED, MAX_HEALTH);
  }

  @Override
  protected void makeMove() {
    // движение в стороны жертвы
  }
  //хищник, имеет силу атаки
  // тратит ход на то, чтобы приблизиться к жертве
  // атака травоядного
  // hp жертвы -= сила атаки хищника >0
}
