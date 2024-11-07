package worldMap;

public record Coordinates(int x, int y) {

  @Override
  public String toString() {
    return "X:" + x + ",Y:" + y;
  }
}
