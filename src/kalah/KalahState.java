package kalah;

import java.util.*;

import game.*;


public class KalahState implements State {

  //The typical number of stones found in each pit at the start of a kalah game
  private static final int DEFAULT_STONE_COUNT = 4;

  private Player activePlayer;

  /*represents the pits on a kalah board--pit[0] is the kalah on the
    left-hand-side of the board, pits[1..6] are player 1's houses 1..6, pit[7]
    is the the large kalah on the right-hand-side of the board (i.e. player 1's
    kalah, and pits[8..13] are player 2's houses 1..6. As a side note, the
    number of stones in a pit can never be negative, and the total number of
    stones in the pits must always equal the number of starting stones */
  private int[] pits = new int[14];

/* Constructors ***************************************************************/

  public KalahState(int[] pits, Player p) {
    this.activePlayer = p;
    this.pits = pits;
  }

/* Factory Methods *******************************************************1*****/

  public static KalahState initialState() {
    return initialState(DEFAULT_STONE_COUNT);
  }

  public static KalahState initialState(int stonesPerPit){
    int[] pits = new int[14];
    //note: no need to set the kalahs to 0--they'll be set to 0 by default
    Arrays.fill(pits, 1, 7, stonesPerPit);
    Arrays.fill(pits, 8, 14, stonesPerPit);

    return new KalahState(pits, Player.ONE);
  }

/* Private Utility Functions *************************************************/


  /*checks whether all of the pits between [start], inclusive, and [stop],
    exclusive do not contain stones */
  private boolean pitsInRangeEmpty(int start, int stop) {
    boolean result = true;
    for (int i = start; i < stop; i++)
      if (pits[i] != 0 ) result = false;

    return result;
  }

  //checks whether all of a player's houses no longer contains stones
  private boolean housesEmpty(Player p) {
    if (p == Player.ONE)
      return pitsInRangeEmpty(1, 7);
    else
      return pitsInRangeEmpty(8,14);
  }

  /* returns the numbers associated with pits in the range [start], inclusive, to 
     [stop], exclusive that contain stones */
  private Set<Integer> stockedPits(int start, int stop) {
    HashSet<Integer> pitNums = new HashSet<Integer>();

    for (int i = start; i < stop; i++){
      if (pits[i] > 0) {
        pitNums.add(i);
      }
    }

    return pitNums;
  }
  
  /* returns a set of moves that the active player could legally make*/
  private Set<KalahMove> validMoves(){
    HashSet<KalahMove> result = new HashSet<KalahMove>();
    
    if (activePlayer == Player.ONE) {
      for (int i : stockedPits(1, 7)){
        result.add(KalahMove.ofInt(i));
      }
    } else {
      for (int i : stockedPits(8, 14)) {
        result.add(KalahMove.ofInt(i - 7));
      }
    }
    
    return result;
  }
  
  /* returns the index of the pit opposite the provided index [n] */
  private int opposingPitNum(int n) throws IllegalArgumentException {
    if (n <= 0 || n == 7 || n > 13 ){
      String msg = "opposingPitCountNum expects an integer argument corresponding "
                 + "to a house, but received " + n;
      throw new IllegalArgumentException(msg);
    } else {
      /* oopsie, this is kind of difficult to understand--maybe this diagram of
       * a kalah board with the pits numbered according to our indexing scheme
       * will help make sense of it:
       * 
       *    | 13 12 11 10 09 08 |
       * 00 |                   | 07
       *    | 01 02 03 04 05 06 | 
       * 
       * try finding the pit opposite of 2, and then try finding the one 
       * opposite of 13.
       * */
      int diff = n - 7;
      return 7 - diff;
    }
  }
  
  /* given the index of the last seed sown and the active player, checks whether
   * a capture should occur  */
  private boolean captureTriggered(int lastSeedSownLoc, Player activePlayer){
    int activePlayerKalahNum = (activePlayer == Player.ONE) ? 7 : 0;
    
    boolean InEmptyPit = pits[lastSeedSownLoc] == 1;
    boolean NotInOwnKalah = lastSeedSownLoc != activePlayerKalahNum;
    
    boolean NotInOpposingKalah = 
      (activePlayer == Player.ONE && lastSeedSownLoc >= 1 && lastSeedSownLoc <= 6)
      || (activePlayer == Player.TWO && lastSeedSownLoc >= 8 && lastSeedSownLoc <= 13);

    boolean opposingKalahHasSeeds = NotInOwnKalah && pits[opposingPitNum(lastSeedSownLoc)] != 0;
    
    
    return InEmptyPit && NotInOwnKalah && NotInOpposingKalah && opposingKalahHasSeeds;
  }
  
  private KalahState sow(KalahMove m){
    int houseNum = m.getHouseNumber();
    int startingPitNum = 
      (activePlayer == Player.ONE) ? houseNum : 7 + houseNum;
    int currentPitNum = startingPitNum;
    int stones = pits[startingPitNum];
    
    /* fresh variable since I'd like to avoiding manipulating the current 
     * state: */
    int[] pits = this.pits;
    
    int playerKalahNum = (activePlayer == Player.ONE) ? 7 : 0;
    int opponentKalahNum = (activePlayer == Player.ONE) ? 0 : 7;
    Player nextActivePlayer;
    
    while (stones > 0){
      if (currentPitNum == 13){
        currentPitNum = 0;
      } else {
        currentPitNum++;
      }
      if (currentPitNum != opponentKalahNum){
        pits[currentPitNum]++;
        stones--;
      }
    }
    
    
    /* rule for capturing opposing kalah's stones */
    if(captureTriggered(currentPitNum, activePlayer)) {
      /* move the last seed sown, and the seeds in the opposing house to 
       * current player's Kalah */
      
      pits[currentPitNum] = 0;
  
      int opposingPitSeeds = pits[opposingPitNum(currentPitNum)];
      pits[opposingPitNum(currentPitNum)] = 0;
      
      pits[playerKalahNum] = 1 + opposingPitSeeds;
      
    }
    
    nextActivePlayer = 
        (currentPitNum == playerKalahNum) ? activePlayer : activePlayer.next();
    
    return new KalahState(pits, nextActivePlayer);
    
  }
  


/* Implementation of State Interface *****************************************/

  @Override
  public Player getActivePlayer() {
    return this.activePlayer;
  }

  @Override
  public Map<Move, State> successors() {
    // TODO Auto-generated method stub
    Hashtable<Move, State> result = 
      new Hashtable<Move, State>();
    for (KalahMove move : this.validMoves()){
      result.put(move, this.sow(move));
    }
    return result;
  }


  @Override
  public boolean isTerminal() {
    return housesEmpty(activePlayer);
  }

  @Override
  public int utility(Player p) {
    // TODO Auto-generated method stub
    return 0;
  }
  
/* Getters *******************************************************************/
  
  /* returns the number of seeds in a given player's kalah */
  public int kalahCount(Player p){
    if (p == Player.ONE){
      return pits[7];
    } else {
      return pits[0];
    }
  }
 
  public int getHouseCount(Player p, int num) {
    if (p == Player.ONE){
      return pits[num];
    } else {
      return pits[7 + num];
    }
  }

}
