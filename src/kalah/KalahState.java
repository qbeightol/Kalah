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
    kalah, and pits[7..13] are player 2's houses 1..6. As a side note, the
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
        result.add(new KalahMove(i));
      }
    } else {
      for (int i : stockedPits(8, 14)) {
        result.add(new KalahMove(i - 7));
      }
    }
    
    return result;
  }
  
  private KalahState sow(int startingPitNum, Player p){
    int stones = pits[startingPitNum];
    int currentPitNum = startingPitNum + 1;
    int[] pits = this.pits;
    int playerKalahNum = (p == Player.ONE) ? 7 : 0;
    int opponentKalahNum = (p == Player.ONE) ? 0 : 7;
    Player nextActivePlayer;
    
    while (stones > 0){
      if (currentPitNum != opponentKalahNum){
        pits[currentPitNum]++;
        currentPitNum--;
      }
    }
    
    /* If the last stone is placed in the current player's kalah, they get to
     * take a second turn*/
    
    nextActivePlayer = (currentPitNum + 1 == playerKalahNum) ? p : p.next();
    
    /*TODO add rules for capturing an opponent's stones*/
    
    return new KalahState(pits, nextActivePlayer);       
  }

/* Implementation of State Interface *****************************************/

  @Override
  public Player getActivePlayer() {return this.activePlayer;}

  @Override
  public Map<? extends Move, ? extends State> successors() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean terminal() {return housesEmpty(activePlayer);}

  @Override
  public int utility(Player p) {
    // TODO Auto-generated method stub
    return 0;
  }


}
