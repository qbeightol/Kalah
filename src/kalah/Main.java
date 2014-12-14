package kalah;

import game.Player;

import java.awt.Color;
import java.util.Arrays;


public class Main {

  private static void printKalahGameInfo(KalahGame g){
    System.out.println("========");
    System.out.println("active player: " + g.currentState().getActivePlayer());
    for (int i = 1; i <= 6; i++){
      System.out.println(((KalahState)g.currentState()).getHouseCount(Player.ONE, i));
    }
    System.out.println("player 1 kalah: " + ((KalahState) g.currentState()).kalahCount(Player.ONE));
    for (int i = 1; i <= 6; i++){
      System.out.println(((KalahState)g.currentState()).getHouseCount(Player.TWO, i));
    }
    System.out.println("player 2 kalah: " + ((KalahState) g.currentState()).kalahCount(Player.TWO));
    System.out.println("========");
  }

  public static void main(String[] args) {
    
    KalahGame kg = new KalahGame();
    printKalahGameInfo(kg);
    kg.applyMove(KalahMove.ofInt(6));
    printKalahGameInfo(kg);

	  KalahGUI mankalah = new KalahGUI();
      mankalah.setVisible(true);
      int[] xs2 = new int[14];
      Arrays.fill(xs2, 1, 7, 4);
      Arrays.fill(xs2, 8, 14, 4);
      
      //for (int x: xs2) System.out.println(x);
      
      
  }

}
