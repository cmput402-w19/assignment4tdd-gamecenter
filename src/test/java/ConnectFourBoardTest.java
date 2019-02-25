import ConnectFour.ConnectFourBoard;
import ConnectFour.InvalidMoveException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Test class for ConnectFourBoard class.
 */
public class ConnectFourBoardTest {
    private static final int COLUMNS = 7;
    private static final int ROWS = 6;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ConnectFourBoard board;

    @Before
    public void setup() {
        this.board = new ConnectFourBoard();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Tests if the board is full.
     */
    @Test
    public void testFullBoard() {
        assert(!this.board.isFull());

        ConnectFourBoard spyBoard = spy(this.board);
        ConnectFourBoard.Player[][] fakeBoard = {
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X},
        };


        doReturn(fakeBoard).when(spyBoard).getBoard();

        assert(spyBoard.isFull());
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
     * Tests playMove method on different columns.
     * @throws InvalidMoveException
     *
     * Based on TicTacToe "testPlayMoveEmptyBoard" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test
    public void testPlayMoveDifferentColumns() throws InvalidMoveException {
        assert (this.board.getPlayerAtPosition(ROWS - 1, 0).equals(ConnectFourBoard.Player.NONE));
        board.playMove(0);

        assert (board.getPlayerAtPosition(ROWS - 1, 0).equals(ConnectFourBoard.Player.X));
        assert (board.getCurrentPlayer().equals(ConnectFourBoard.Player.O));

        assert (board.getPlayerAtPosition(ROWS - 1, 1).equals(ConnectFourBoard.Player.NONE));
        board.playMove(1);
        assert (board.getPlayerAtPosition(ROWS - 1, 1).equals(ConnectFourBoard.Player.O));
        assert (board.getCurrentPlayer().equals(ConnectFourBoard.Player.X));
    }

    /**
     * Tests playMove method on same column.
     * @throws InvalidMoveException
     *
     * Based on TicTacToe "testPlayMoveEmptyBoard" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test
    public void testPlayMoveSameColumn() throws InvalidMoveException {
        assert (this.board.getPlayerAtPosition(ROWS - 1, 0).equals(ConnectFourBoard.Player.NONE));
        board.playMove(0);

        assert (board.getPlayerAtPosition(ROWS - 1, 0).equals(ConnectFourBoard.Player.X));
        assert (board.getCurrentPlayer().equals(ConnectFourBoard.Player.O));

        assert (board.getPlayerAtPosition(ROWS - 2, 0).equals(ConnectFourBoard.Player.NONE));
        board.playMove(0);
        assert (board.getPlayerAtPosition(ROWS - 2, 0).equals(ConnectFourBoard.Player.O));
        assert (board.getCurrentPlayer().equals(ConnectFourBoard.Player.X));
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

    /**
     * Tests if the board is printed properly.
     */
    @Test
    public void testPrintBoard() {
        StringBuilder emptyBoardStringBuilder = new StringBuilder();
        emptyBoardStringBuilder.append("\r\n");
        emptyBoardStringBuilder.append("  |   |   |   |   |   |  ");
        emptyBoardStringBuilder.append("\n");
        emptyBoardStringBuilder.append("-------------------------");
        emptyBoardStringBuilder.append("\r\n");
        emptyBoardStringBuilder.append("  |   |   |   |   |   |  ");
        emptyBoardStringBuilder.append("\n");
        emptyBoardStringBuilder.append("-------------------------");
        emptyBoardStringBuilder.append("\r\n");
        emptyBoardStringBuilder.append("  |   |   |   |   |   |  ");
        emptyBoardStringBuilder.append("\n");
        emptyBoardStringBuilder.append("-------------------------");
        emptyBoardStringBuilder.append("\r\n");
        emptyBoardStringBuilder.append("  |   |   |   |   |   |  ");
        emptyBoardStringBuilder.append("\n");
        emptyBoardStringBuilder.append("-------------------------");
        emptyBoardStringBuilder.append("\r\n");
        emptyBoardStringBuilder.append("  |   |   |   |   |   |  ");
        emptyBoardStringBuilder.append("\n");
        emptyBoardStringBuilder.append("-------------------------");
        emptyBoardStringBuilder.append("\r\n");
        emptyBoardStringBuilder.append("  |   |   |   |   |   |  ");
        emptyBoardStringBuilder.append("\n");
        emptyBoardStringBuilder.append("-------------------------");
        emptyBoardStringBuilder.append("\r\n\r\n");

        this.board.printBoard();
        assert(outContent.toString().equals(emptyBoardStringBuilder.toString()));

        ConnectFourBoard spyBoard = spy(this.board);
        ConnectFourBoard.Player[][] fakeBoard = {
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X},
        };

        StringBuilder nonEmptyBoardStringBuilder = new StringBuilder();
        nonEmptyBoardStringBuilder.append("\r\n");
        nonEmptyBoardStringBuilder.append("O |   |   |   |   |   |  ");
        nonEmptyBoardStringBuilder.append("\n");
        nonEmptyBoardStringBuilder.append("-------------------------");
        nonEmptyBoardStringBuilder.append("\r\n");
        nonEmptyBoardStringBuilder.append("X |   |   |   |   |   |  ");
        nonEmptyBoardStringBuilder.append("\n");
        nonEmptyBoardStringBuilder.append("-------------------------");
        nonEmptyBoardStringBuilder.append("\r\n");
        nonEmptyBoardStringBuilder.append("O |   |   |   |   |   |  ");
        nonEmptyBoardStringBuilder.append("\n");
        nonEmptyBoardStringBuilder.append("-------------------------");
        nonEmptyBoardStringBuilder.append("\r\n");
        nonEmptyBoardStringBuilder.append("X |   |   |   |   |   |  ");
        nonEmptyBoardStringBuilder.append("\n");
        nonEmptyBoardStringBuilder.append("-------------------------");
        nonEmptyBoardStringBuilder.append("\r\n");
        nonEmptyBoardStringBuilder.append("O |   |   |   |   |   |  ");
        nonEmptyBoardStringBuilder.append("\n");
        nonEmptyBoardStringBuilder.append("-------------------------");
        nonEmptyBoardStringBuilder.append("\r\n");
        nonEmptyBoardStringBuilder.append("X | O | X | O | X | O | X");
        nonEmptyBoardStringBuilder.append("\n");
        nonEmptyBoardStringBuilder.append("-------------------------");
        nonEmptyBoardStringBuilder.append("\r\n\r\n");

        doReturn(fakeBoard).when(spyBoard).getBoard();

        outContent.reset();
        spyBoard.printBoard();

        assert(outContent.toString().equals(nonEmptyBoardStringBuilder.toString()));
    }

    /**
     * Tests horizontal win condition for player O.
     * @throws InvalidMoveException
     *
     * Based on TicTacToe "testWinHorizonalO" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test
    public void testWinHorizontalO() throws InvalidMoveException {
        ConnectFourBoard spyBoard = spy(this.board);
        ConnectFourBoard.Player[][] fakeBoard = {
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.O, ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
        };

        doReturn(fakeBoard).when(spyBoard).getBoard();
        doReturn(ConnectFourBoard.Player.O).when(spyBoard).getCurrentPlayer();

        spyBoard.playMove(4); // player O

        assert(spyBoard.getWinner().equals(ConnectFourBoard.Player.O));
    }


    /**
     * Tests horizontal win condition for player X.
     * @throws InvalidMoveException
     *
     * Based on TicTacToe "testWinHorizonalX" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test
    public void testWinHorizontalX() throws InvalidMoveException {
        ConnectFourBoard spyBoard = spy(this.board);
        ConnectFourBoard.Player[][] fakeBoard = {
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
        };

        doReturn(fakeBoard).when(spyBoard).getBoard();

        spyBoard.playMove(3); // player X

        assert(spyBoard.getWinner().equals(ConnectFourBoard.Player.X));
    }

    /**
     * Tests left diagonal win condition for player O.
     * @throws InvalidMoveException
     *
     * Based on TicTacToe "testWinLeftDiagonalO" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test
    public void testWinLeftDiagonalO() throws InvalidMoveException {
        ConnectFourBoard spyBoard = spy(this.board);
        ConnectFourBoard.Player[][] fakeBoard = {
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.O, ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE},
        };


        doReturn(fakeBoard).when(spyBoard).getBoard();
        doReturn(ConnectFourBoard.Player.O).when(spyBoard).getCurrentPlayer();

        spyBoard.playMove(4); // player O

        assert(spyBoard.getWinner().equals(ConnectFourBoard.Player.O));
    }

    /**
     * Tests left diagonal win condition for player X.
     * @throws InvalidMoveException
     *
     * Based on TicTacToe "testWinLeftDiagonalX" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test
    public void testWinLeftDiagonalX() throws InvalidMoveException {
        ConnectFourBoard spyBoard = spy(this.board);
        ConnectFourBoard.Player[][] fakeBoard = {
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.O, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
        };


        doReturn(fakeBoard).when(spyBoard).getBoard();

        spyBoard.playMove(3); // player X

        assert(spyBoard.getWinner().equals(ConnectFourBoard.Player.X));
    }

    /**
     * Tests right diagonal win condition for player O.
     * @throws InvalidMoveException
     *
     * Based on TicTacToe "testWinRightDiagonalO" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test
    public void testWinRightDiagonalO() throws InvalidMoveException {
        ConnectFourBoard spyBoard = spy(this.board);
        ConnectFourBoard.Player[][] fakeBoard = {
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
        };

        doReturn(fakeBoard).when(spyBoard).getBoard();
        doReturn(ConnectFourBoard.Player.O).when(spyBoard).getCurrentPlayer();

        spyBoard.playMove(1); // player O

        assert(spyBoard.getWinner().equals(ConnectFourBoard.Player.O));
    }

    /**
     * Tests right diagonal win condition for player X.
     * @throws InvalidMoveException
     *
     * Based on TicTacToe "testWinRightDiagonalX" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test
    public void testWinRightDiagonalX() throws InvalidMoveException {
        ConnectFourBoard spyBoard = spy(this.board);
        ConnectFourBoard.Player[][] fakeBoard = {
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
        };

        doReturn(fakeBoard).when(spyBoard).getBoard();

        spyBoard.playMove(3); // player X

        assert(spyBoard.getWinner().equals(ConnectFourBoard.Player.X));
    }

    /**
     * Tests vertical win condition for player O.
     * @throws InvalidMoveException
     *
     * Based on TicTacToe "testVerticalO" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test
    public void testWinVerticalO() throws InvalidMoveException {
        ConnectFourBoard spyBoard = spy(this.board);
        ConnectFourBoard.Player[][] fakeBoard = {
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.O, ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.X, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
        };

        doReturn(fakeBoard).when(spyBoard).getBoard();
        doReturn(ConnectFourBoard.Player.O).when(spyBoard).getCurrentPlayer();

        spyBoard.playMove(0); // player O

        assert(spyBoard.getWinner().equals(ConnectFourBoard.Player.O));
    }

    /**
     * Tests vertical win condition for player X.
     * @throws InvalidMoveException
     *
     * Based on TicTacToe "testWinVerticalX" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    @Test
    public void testWinVerticalX() throws InvalidMoveException {
        ConnectFourBoard spyBoard = spy(this.board);
        ConnectFourBoard.Player[][] fakeBoard = {
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
                {ConnectFourBoard.Player.X, ConnectFourBoard.Player.O, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE, ConnectFourBoard.Player.NONE},
        };

        doReturn(fakeBoard).when(spyBoard).getBoard();

        spyBoard.playMove(0); // player X

        assert(spyBoard.getWinner().equals(ConnectFourBoard.Player.X));
    }
}