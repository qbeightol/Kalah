import java.util.Arrays;


public class Game {
  public static State initialState() {
    int[] houses;
    houses = new int[12];
    Arrays.fill(houses, 4);
    return new State(0, 0, houses);
  }
  
  /* public static HashSet<> */
}
