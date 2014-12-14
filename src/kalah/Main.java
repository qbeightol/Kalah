package kalah;

import java.awt.Color;
import java.util.Arrays;


public class Main {


  public static void main(String[] args) {

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
