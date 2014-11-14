package kalah;

public class KalahMove {
  /* represents the number of the pit from which the player begins sowing seeds
   * invariant: must be an int between 1 and 6, inclusive*/
  private int houseNumber;
  
  public KalahMove(int n){
    if (1 <= n || n <= 6) {
      houseNumber = n;
    } else {
      String msg = "KalahMove(int n) received" + n 
          + "but expected a number between 1 and 6, inclusive";
      throw new IllegalArgumentException(msg);
    }
  }

  public int getHouseNumber() {
    return houseNumber;
  }

}
