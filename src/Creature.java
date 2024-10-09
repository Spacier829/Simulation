abstract public class Creature extends Entity {
  // Существо
  public int speed;
  public int healthPoint;// сколько клеток может пройти за 1 ход

  public Creature(int speed, int healthPoint) {
    this.speed = speed;
    this.healthPoint = healthPoint;
  }

  protected void makeMove() {

  }

  ; //-> каждый делает по своему

}
