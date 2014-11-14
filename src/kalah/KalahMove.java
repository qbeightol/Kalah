package kalah;

public enum KalahMove {
  HOUSE_ONE, 
  HOUSE_TWO, 
  HOUSE_THREE, 
  HOUSE_FOUR, 
  HOUSE_FIVE, 
  HOUSE_SIX;
  
  public static KalahMove of(int n){
    switch (n) {
    case 1: 
      return HOUSE_ONE;
    case 2: 
      return HOUSE_TWO;
    case 3:
      return HOUSE_THREE;
    case 4:
      return HOUSE_FOUR;
    case 5:
      return HOUSE_FIVE;
    case 6:
      return HOUSE_SIX;
    default:
      String msg = "KalahMove.of(int n) received " + n 
                 + " but expected a number between 1 and 6, inclusive";
      throw new IllegalArgumentException(msg);
    }
  }
}
