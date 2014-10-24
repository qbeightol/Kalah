package game;
import java.util.Arrays;
import java.util.HashSet;

import util.NotImplemented;


public class Game {
  public static State initialState() {
    int[] houses;
    houses = new int[12];
    Arrays.fill(houses, 4);
    return new State(0, 0, houses);
  }
  
  public static HashSet<util.Successor> successorFunction(State s) throws NotImplemented{
    /*figure out which player can make a move
     * look at that player's houses and check which ones contain stones
     * figure out the possible moves
     * figure out how those moves change the board state
     * build up (and return) a list of successors
     */
    throw new NotImplemented();
  }
  
  public static boolean terminalTest(State s) throws NotImplemented {
    throw new NotImplemented();
  }
  
  /**
   * returns the payoff from player 1's perspective at the end of the game
   * (more concretely, it returns player 1's score minus player 2's)
   * 
   * @param s a terminal state 
   * @return an integer representing player 1's payout
   */
  public static int utility_function(State s) {
    return s.getKalah1() - s.getKalah2();
  }
}
