package kalah;

import game.Player;

public class EvalFunction {
	// constructor
	private KalahState m = KalahGUI.mancalaGame;
	public EvalFunction() {
		
	}
	
	// how to evaluate. x = current player, y = opponent, k(x) = number of stones in x's kalah, 
	// h(x) = total stones in x's houses, b(x) = any bonuses for x (+1) **
	// **ex having perfect number of stones in a house to land in x's kalah, 
	// **ex having perfect number of stones in a house to land in an empty x house
	// f(x) = [k(x) - k(y)] + [h(x) - h(y)] + b(x)
	
	// from player one's point of view, negate for player two
	public int currentEval() {
		int k = m.kalahCount(KalahGUI.p1) - m.kalahCount(KalahGUI.p2);
		int h = 0;
		// TODO implement bonuses
		int b = 0;
		int i = 0;
		while (i<7) {
			h = h + m.getHouseCount(KalahGUI.p1, i) - m.getHouseCount(KalahGUI.p2, i);
			i++;
		}
		int result = k + h;
		System.out.println("hi " + result);
		return result;
	}
	
}
