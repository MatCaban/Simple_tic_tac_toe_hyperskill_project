package tictactoe;

public class Players {
    private boolean isPlayerXTurn;
    private boolean isPlayerOTurn;

    public Players() {
        isPlayerXTurn = true;
        isPlayerOTurn = false;
    }

    public boolean isPlayerOTurn() {
        return isPlayerOTurn;
    }

    public boolean isPlayerXTurn() {
        return isPlayerXTurn;
    }



    public void switchTurn() {
        isPlayerXTurn = !isPlayerXTurn;
        isPlayerOTurn = !isPlayerOTurn;
    }
}
