package actions.turnActions;

import actions.Action;

public class HandleEndGameAction extends Action {
  private boolean gameStatus;

  public HandleEndGameAction() {
    this.gameStatus = false;
  }

  @Override
  public void execute() {
  }

  public boolean isGameStatus() {
    return gameStatus;
  }

  public void setGameStatus(boolean gameStatus) {
    this.gameStatus = gameStatus;
  }
}
