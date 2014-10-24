package util;

public class Successor {
  private final Move move;
  private final game.State state;

  public Successor(Move m, game.State s){
    super ();
    this.move = m;
    this.state = s;
  }
  
  public Move getMove() {
    return this.move;
  }
  
  public game.State getState(){
    return this.state;
  }
}
