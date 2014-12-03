package kalah;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import game.Move;
import game.State;

public class SimpleBot implements game.Bot {

  @Override
  public Move requestMove(State s) {
    /* check for moves that allow you to take a turn--if there are many of 
     * these moves, choose the one starts with a pit closest to your kalah 
     * (that way you can still use the other turn-granting moves) */
    
    Set<Move> candidateMoves = new HashSet<Move>();

    for (Entry<Move, State> e : s.successors().entrySet()) {
      if (e.getValue().getActivePlayer() == s.getActivePlayer()){
        candidateMoves.add(e.getKey());
      }
    }
    
    
    
    
    // TODO Auto-generated method stub
    return null;
    /* Ideas:
     * check if its possible to get a second turn
     * -> if so, make that move
     * -> I may need to consider tie-breaking strategies
     * 
     * try to empty your right-most holes
     * 
     * try to create holes on your side of the board
     * 
     * make moves to ensure that you don't have a whole bunch of stones across
     * from one of your opponent's empty holes 
     * 
     * see this website for the tips that this strategy is based off
     * http://boardgames.about.com/od/mancala/a/Mancala-Strategy.htm
     * */
  }

}
