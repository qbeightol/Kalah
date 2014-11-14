package game;

import java.util.Map;


public interface State {
  
  //indicates which player is currently making a move
  public Player getActivePlayer();
  
  //returns a map of all legal moves and their corresponding next state
  public Map<? extends Move, ? extends State> successors();
  
  //returns true if someone has won the game (and false otherwise)
  public boolean terminal();
  
  //returns the "goodness" of a state from a particular player's perspective
  public int utility(Player p);
}
