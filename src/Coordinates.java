import java.util.Objects;

public class Coordinates {
  public final int X;
  public final int Y;

  public Coordinates(int x, int y) {
    this.X = x;
    this.Y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Coordinates that = (Coordinates) o;
    return X == that.X && Y == that.Y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(X, Y);
  }
}
