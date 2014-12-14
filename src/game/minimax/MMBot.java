package game.minimax;

import java.util.Map;
import java.util.Map.Entry;

import game.Bot;
import game.Move;
import game.Player;
import game.State;

public class MMBot implements Bot {
  
  /* fields ******************************************************************/
  
  /* indicates whether or not the bot uses alpha-beta pruning */
  boolean alphaBeta;
  
  /* represents how many moves ahead the bot thinks (assuming that the bot 
   * isn't timed) */
  int depth;
  
  /* indicates how many milliseconds the bot will think (if the bot is timed) */
  int time;
  
  /* indicates if the bot is timed */
  boolean timed;
  
/* constructors ************************************************************/
  
  private MMBot(boolean alphaBeta, int depth, int time, boolean timed){
    this.alphaBeta = alphaBeta;
    this.depth = depth;
    this.time = time;
    this.timed = timed;
  }
  
  /* factory methods *********************************************************/
  
  /* notice that both of these methods take in an int and a boolean--if we were
   * to use constructors instead of factory methods, Java would think we had
   * duplicated the constructor unless we had one constructor take an int first
   * and the other take a boolean first, which would make the interface 
   * inconsistent. Instead, we've decided to implement factory methods that 
   * have a consistent interface (and also are slightly more readable) */
  
  /* produces a bot that will go down to the specified depth, possibly using 
   * alpha-beta pruning to speed up the analysis */
  public static MMBot untimedMMBot(int depth, boolean alphaBeta){
    if (depth <= 0){
      String msg = "untimed MMBots expect a depth argument greater than 0, but "
                 + "received a depth of " + depth;
      throw new IllegalArgumentException(msg);
    }
    return new MMBot(alphaBeta, depth, 0, false);
  }
  
  /* returns a bot that runs for the specified time in ms--possibly using 
   * alpha-beta pruning and then returns a move. Out of necessity the bot uses
   * iterative deepening to ensure that it can always produce a move */
  public static MMBot timedMMBot(int time, boolean alphaBeta){
    if (time <= 0){
      String msg = "timed MMBots expect a time argument greater than 0, but "
                 + "received a time of " + time;
      throw new IllegalArgumentException(msg);
    }
    return new MMBot(alphaBeta, -1, time, true); 
  }
  
  /* private utility functions ***********************************************/
  
  private MMIntermediate fixedDepthMM(State state, int depth, int alpha, int beta){
    if (depth <= 0) {
      String msg = "minimax should be called with a positive depth";
      throw new IllegalArgumentException(msg);
    } else if (state.isTerminal()){
      String msg = "minimax should be called on non-terminal states";
      throw new IllegalArgumentException(msg);
    } else if (state.successors().isEmpty()){
      String msg = "the supplied game's current state has no successors";
      throw new IllegalArgumentException(msg);
    } else if (depth == 1) {
      /* look for ways to tidy this up: */
      Player activePlayer = state.getActivePlayer();
      Map<Move, State> succs = state.successors();
      Move result = succs.keySet().iterator().next();
      int resultUtil = succs.get(result).utility(activePlayer);
      
      for (Move move : succs.keySet()) {
        int moveUtil = succs.get(move).utility(activePlayer);
        
        if (moveUtil > resultUtil) {
          result = move;
          resultUtil = moveUtil;
        }
        
      }
      
      return new MMIntermediate(result, resultUtil);
    } else {
      // TODO implement code for updating alpha and beta values
      // TODO consider re-factoring code
      // TODO 
      
      
      /* since none of the other if blocks were triggered, depth >= 2 and the
       * current state has successors */
      Player activePlayer = state.getActivePlayer();
      Map<Move, State> succs = state. successors();
      Move result = succs.keySet().iterator().next();
      
      /* clean up:*/
      int resultUtil;
      if (succs.get(result).getActivePlayer() == activePlayer) {
        resultUtil = fixedDepthMM(succs.get(result), depth - 1, alpha, beta).utility;
      } else {
        resultUtil = -fixedDepthMM(succs.get(result), depth - 1, alpha, beta).utility;
      }
      
      for (Entry<Move, State> e : succs.entrySet()){
        MMIntermediate intermediate = fixedDepthMM(e.getValue(), depth - 1, alpha, beta);
        
        /* if the player changes between turns, we need to update the utility
         * so that it's from the current player's perspective (which is done
         * simply by negating the old utility)  */
        int samePlayerMultiplier = 
            e.getValue().getActivePlayer() == activePlayer ? 1 : -1;
        
        int moveUtil = samePlayerMultiplier * intermediate.utility;
         
        if (moveUtil > resultUtil){
          result = intermediate.move;
          resultUtil = intermediate.utility;
        }
      }
      /* this seems a little silly--I should probably just keep a copy of the
       * best MMIntermediate I generate and just return that */
      return new MMIntermediate(result, resultUtil);
      
    }
  }
  
  private Move timedMM(State s, int time2) {
    // TODO Auto-generated method stub
    return null;
  }
    @Override
  public Move requestMove(State s) throws IllegalArgumentException {
//    if (timed) {
//      return timedMM(s, time);
//    } else {
//      return fixedDepthMM(s, depth).move;
//    } 
    	return null;
  }


}
