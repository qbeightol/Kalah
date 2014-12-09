package kalah;

import game.Game;
import game.Move;
import game.State;
import java.util.Map;

public class KalahGame implements Game {
  
  private KalahState currentState;
  
  @Override
  public State currentState() {return this.currentState;}
  
  @Override
<<<<<<< HEAD
  public void applyMove(Move m) {
=======
  public void applyMove(Move m) throws IllegalArgumentException {
>>>>>>> bots
    
    Map<Move,State> succs = currentState.successors();
    
    if (succs.keySet().contains(m)) {
      this.currentState = (KalahState) currentState.successors().get(m);
<<<<<<< HEAD
//    else 
//      throw new game.exns.InvalidMove();
=======
    } else {
      String msg = "the provided move isn't legal (are you sure you supplied"
                 + " a KalahMove?)";
      throw new IllegalArgumentException(msg);
    }
>>>>>>> bots
  }
  
  //hmmm...
  public KalahState currentKalahState() {return this.currentState;}
  
  
  



}
