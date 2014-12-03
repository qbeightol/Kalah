package game;

public interface Bot {
  
  /* Returns a suggested move for the active player in the provided state */
  public Move requestMove(State s);
  
}
