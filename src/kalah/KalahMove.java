package kalah;

import game.Move;

public class KalahMove implements Move{
  /* represents the number of the pit from which the player begins sowing seeds
   * invariant: must be an int between 1 and 6, inclusive*/
  private final int houseNumber;
  
  public KalahMove(int n){
    if (1 <= n || n <= 6) {
      houseNumber = n;
    } else {
      String msg = "KalahMove(int n) received" + n 
          + "but expected a number between 1 and 6, inclusive";
      throw new IllegalArgumentException(msg);
    }
  }

  /* returns which house the player will use when starting to sow seeds (from 
   * the player's perspective, house 1 will be the left-most pit, and house 6
   * will be  the right-most pit)*/
  public int getHouseNumber() {
    return houseNumber;
  }
  

}
