package kalah;

import game.Player;
import game.RandomBot;
import game.State;

import java.util.Arrays;


public class Main {

  public static void main(String[] args) {
    
    KalahGame kg = new KalahGame();
    RandomBot p1 = new RandomBot();
    RandomBot p2 = new RandomBot();
    
    while (!kg.currentKalahState().isTerminal()){
      State currentState = kg.currentState();
      if (currentState.getActivePlayer() == Player.ONE){
        kg.applyMove(p1.requestMove(currentState));
      } else{
        kg.applyMove(p2.requestMove(currentState));
      }
    }
    
    kg.printKalahGameInfo();
    
    //kg.printKalahGameInfo();
    //kg.applyMove(KalahMove.ofInt(6));
    //kg.printKalahGameInfo();

	  KalahGUI mankalah = new KalahGUI();
      mankalah.setVisible(true);
      int[] xs2 = new int[14];
      Arrays.fill(xs2, 1, 7, 4);
      Arrays.fill(xs2, 8, 14, 4);
      /*
      for (int x: xs2) System.out.println(x);
      EvalFunction e = new EvalFunction();
      e.currentEval();
      */
      
  }

}
