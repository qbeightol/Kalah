package game;

public class Successor<M extends Move, S extends State> {
  private M move;
  private S state;
  
  Successor(M move, S state) {
    this.move = move;
    this.state = state;
  }
  
  public M getMove() {return this.move;}
  public S getState() {return this.state;}

}
