package worldMap;

public class WorldMapRenderer {
  public static final String HERBIVORE = "\uD83D\uDC37";
  public static final String PREDATOR = "\uD83D\uDC3A";
  public static final String GROUND = "\uD83D\uDFEB";
  public static final String GRASS = "\uD83C\uDF3F";
  public static final String ROCK = "\uD83D\uDDFF";
  public static final String TREE = "\uD83C\uDF33";
  public static final String DEBUG_SYMBOL = "\uD83D\uDD00";


  public void render(WorldMap worldMap) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int y = worldMap.getHeight() - 1; y >= 0  ; y--) {
      stringBuilder.setLength(0);
      for (int x = 0; x < worldMap.getWidth(); x++) {
        stringBuilder.append(GROUND);
      }
      System.out.println(stringBuilder);
    }
  }
  public static void main(String[] args) {
    WorldMapRenderer worldMapRenderer = new WorldMapRenderer();
    worldMapRenderer.render(new WorldMap(3,3));
  }
}
