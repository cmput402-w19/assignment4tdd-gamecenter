import ConnectFour.ConnectFourBoard;
import org.junit.Before;
import org.junit.Test;

public class ConnectFourBoardTest {

    private ConnectFourBoard board;

    @Before
    public void setup() {
        board = new ConnectFourBoard();
    }

    /**
     * Tests board initialization.
     *
     * Based on TicTacToe tests by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test
    public void testInit() {
        for (int row = 0; row < 6; ++row) {
            for (int column = 0; column < 7; ++column) {
                assert(board.getPlayerAtPosition(row, column).equals(ConnectFourBoard.Player.NONE));
            }
        }

        assert(board.getCurrentPlayer().equals(ConnectFourBoard.Player.X));
        assert(board.getWinner() == null);
    }
}