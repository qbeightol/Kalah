package kalah;

import game.Game;
import game.Move;
import game.State;

import java.util.Map;

public class KalahGame implements Game {
  
  private KalahState currentState;
  
  public KalahGame() {
	  /* note: we may want to update this behavior later on (i.e. include some
	   * code that allows you to choose how many seeds go in each house) */
	  currentState = KalahState.initialState(4);
  }
  
  @Override
  public State currentState() {return this.currentState;}
  
  @Override
  public void applyMove(Move m) throws IllegalArgumentException {
    Map<Move,State> succs = currentState.successors();
    
    if (succs.keySet().contains(m)) {
      this.currentState = (KalahState) currentState.successors().get(m);
    } else {
      String msg = "the provided move isn't legal (are you sure you supplied"
                 + " a KalahMove?)";
      throw new IllegalArgumentException(msg);
    }
  }
  
  //hmmm...
  public KalahState currentKalahState() {return this.currentState;}

	
  



}
