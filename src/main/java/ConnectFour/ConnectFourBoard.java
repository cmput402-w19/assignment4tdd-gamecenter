package ConnectFour;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ConnectFourBoard {
    public enum Player {X, O, NONE};

    public Player[][] getBoard(){
        throw new NotImplementedException();
    }

    public Player getCurrentPlayer() {
        throw new NotImplementedException();
    }

    public Player getPlayerAtPosition(int row, int column) {
        throw new NotImplementedException();
    }

    public String getSymbol(Player player) {
        throw new NotImplementedException();
    }

    public Player getWinner() {
        throw new NotImplementedException();
    }

    public void playMove(int column) throws InvalidMoveException {
        throw new NotImplementedException();
    }
}
