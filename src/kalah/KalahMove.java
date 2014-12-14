package kalah;

import game.Move;

/* represents the number of the pit from which the player begins sowing seeds */
public enum KalahMove implements Move{
  ONE, TWO, THREE, FOUR, FIVE, SIX;

  public static KalahMove ofInt(int n){
    switch (n) {
    case 1: return ONE;
    case 2: return TWO;
    case 3: return THREE;
    case 4: return FOUR;
    case 5: return FIVE;
    case 6: return SIX;
    default:
      String msg = "KalahMove.ofInt(int n) received" + n 
                 + "but expected a number between 1 and 6, inclusive";
      throw new IllegalArgumentException(msg);
      
    }

  }

  /* returns which house the player will use when starting to sow seeds (from 
   * the player's perspective, house 1 will be the left-most pit, and house 6
   * will be  the right-most pit)*/
  public int getHouseNumber() {
    switch (this) {
    case ONE: return 1;
    case TWO: return 2;
    case THREE: return 3;
    case FOUR: return 4;
    case FIVE: return 5;
    case SIX: return 6;
    default:
      String msg = "unreachable case (KalahMove.getHouseNumber())";
      throw new IllegalArgumentException(msg);
    }

  }
  


}
