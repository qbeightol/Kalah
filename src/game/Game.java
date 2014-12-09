package game;

public interface Game {
  
  //returns the current state
  public State currentState();
  
  //applies a move to the current state
<<<<<<< HEAD
  public void applyMove(Move m) ;
=======
  public void applyMove(Move m) throws IllegalArgumentException;
>>>>>>> bots
 
}
