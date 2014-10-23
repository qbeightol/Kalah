import java.lang.reflect.Array;


public class State {
  
  public player activePlayer;
  private int kalah1;
  private int kalah2;
  private int[] houses;
    
  public State(int k1, int k2, int[] hs) {
    if (k1 < 0 || k2 < 0) {
      throw new IllegalArgumentException("kalahs can't hold a negative number of seeds");
    } else {
    checkHouses(hs);
    kalah1 = k1;
    kalah2 = k2;
    houses = hs;
    }
  }
  
  private void checkHouses(int[] hs){
    if (Array.getLength(hs) != 12) {
      throw new IllegalArgumentException("hs should contain exactly 12 elements");
    } else {
      for (int i = 0; i <= 12; i++) {
        if (hs[i] < 0) {throw new IllegalArgumentException("houses can't hold a negative number of seeds");}
      }
    }
  }
  
  private boolean houseNumberInvalid(int number){
    return (number < 1 || number > 12);
  }
  
  public int getHouse(player p, int number) {
    if (houseNumberInvalid(number)) {
      throw new IllegalArgumentException("house number should be between 1 and 12, incusive");
    } else if (p == player.ONE) {
      return houses[number];
    } else {
      return houses[number + 6];
    }
  }
  
  public int getKalah1(){return kalah1;}
  
  public int getKalah2(){return kalah2;}
  
  public void setKalah1(int count){kalah1 = count;}

  public void setKalah2(int count){kalah2 = count;}
  
  public void setHouse(player p, int number, int count) {
    if (houseNumberInvalid(number)) {
      throw new IllegalArgumentException("house number should be between 1 and 12, inclusive");
    } else if (p == player.ONE) {
      houses[number] = count;
    } else {
      houses[number + 6] = count;
    }
  }
}
