import ConnectFour.ConnectFourBoard;
import ConnectFour.InvalidMoveException;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ConnectFourBoardTest {

    private static final int COLUMNS = 7;
    private static final int ROWS = 6;

    private ConnectFourBoard board;

    @Before
    public void setup() {
        this.board = new ConnectFourBoard();
    }

    /**
     * Tests Player enum symbols.
     *
     * Based on TicTacToe "testGetSymbol" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test
    public void testGetSymbol() {
        assert(this.board.getSymbol(ConnectFourBoard.Player.NONE).equals(" "));
        assert(this.board.getSymbol(ConnectFourBoard.Player.X).equals("X"));
        assert(this.board.getSymbol(ConnectFourBoard.Player.O).equals("O"));
    }

    /**
     * Tests board initialization.
     *
     * Based on TicTacToe "testInit" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test
    public void testInit() {
        for (int row = 0; row < ROWS; ++row) {
            for (int column = 0; column < COLUMNS; ++column) {
                assert(this.board.getPlayerAtPosition(row, column).equals(ConnectFourBoard.Player.NONE));
            }
        }

        assert(this.board.getCurrentPlayer().equals(ConnectFourBoard.Player.X));
        assert(this.board.getWinner() == null);
    }

    /**
     * Tests playMove method when position is greater than board size.
     * @throws InvalidMoveException
     *
     * Based on TicTacToe "testPlayMoveInvalidColPosition" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test(expected = InvalidMoveException.class)
    public void testPlayMoveInvalidColumnPosition() throws InvalidMoveException {
        this.board.playMove(COLUMNS);
    }

    /**
     * Tests playMove method when position is less than 0.
     * @throws InvalidMoveException
     *
     * Based on TicTacToe "testPlayMoveInvalidNegColPosition" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test(expected = InvalidMoveException.class)
    public void testPlayMoveInvalidNegColumnPosition() throws InvalidMoveException {
        this.board.playMove(-1);
    }

    /**
     * Tests playMove method when the selected column is full.
     * @throws InvalidMoveException
     */
    @Test(expected = InvalidMoveException.class)
    public void testPlayMoveFullColumn() throws InvalidMoveException {
        ConnectFourBoard spyBoard = spy(this.board);
        ConnectFourBoard.Player[][] fakeBoard = {
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
        };

        doReturn(fakeBoard).when(spyBoard).getBoard();
        spyBoard.playMove(0);
    }
}