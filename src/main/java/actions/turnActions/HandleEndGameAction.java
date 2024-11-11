package actions.turnActions;

import actions.Action;

public class HandleEndGameAction extends Action {
  private boolean gameStopped;

  public HandleEndGameAction() {
    this.gameStopped = false;
  }

  @Override
  public void execute() {
  }

  public boolean isGameStopped() {
    return gameStopped;
  }

  public void setGameStopped(boolean gameStatus) {
    this.gameStopped = gameStatus;
  }
}