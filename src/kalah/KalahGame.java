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
  public void applyMove(Move m) throws game.exns.InvalidMove {
    
    Map<? extends Move, ? extends State> succs = currentState.successors();
    
    if (succs.keySet().contains(m)) 
      this.currentState = (KalahState) currentState.successors().get(m);
    else 
      throw new game.exns.InvalidMove();
  }
  
  //hmmm...
  public KalahState currentKalahState() {return this.currentState;}
  
  
  



}
