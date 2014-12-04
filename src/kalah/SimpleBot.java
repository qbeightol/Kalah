package kalah;

import java.util.Map.Entry;

import game.Move;
import game.Player;
import game.State;

public class SimpleBot implements game.Bot {
  
  private int simpleHeuristic(KalahMove move, 
                              KalahState nextState, 
                              Player botPlayer){
    
    int scoreValue = nextState.kalahCount(botPlayer) * 1000;
    int secondTurnValue = (nextState.getActivePlayer() ==  botPlayer) ? 100 : 0;
    int distanceToRightValue = move.getHouseNumber();
    int emptyPitsValue = 0;
    
    for (int houseNum = 1; houseNum <= 6; houseNum++){
      if (nextState.getHouseCount(botPlayer, houseNum) == 0){
        emptyPitsValue++;
      }
    }
    
    return scoreValue + secondTurnValue + distanceToRightValue + emptyPitsValue;
    
  }

  @Override
  public Move requestMove(State inputState) {
    
    Move currentResultMove = null;
    int currentResultValue = 0;
    Player botPlayer = inputState.getActivePlayer();
    
    for (Entry<Move, State> e : inputState.successors().entrySet()) {
      KalahMove move = (KalahMove) e.getKey();
      KalahState state = (KalahState) e.getValue();
      int candidateMoveValue = simpleHeuristic (move, state, botPlayer);
      
      if (candidateMoveValue >= currentResultValue) {
        currentResultMove = e.getKey();
      }
    }
    
    return currentResultMove;
  }

}
