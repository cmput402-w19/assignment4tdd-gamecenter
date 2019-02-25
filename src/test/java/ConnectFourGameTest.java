import ConnectFour.ConnectFourGame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test class for the connect four game.
 */
public class ConnectFourGameTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ConnectFourGame game;

    @Before
    public void setup() {
        this.game = new ConnectFourGame();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Tests output from invalid input.
     */
    @Test
    public void testInvalidInput() {
        StringBuilder inputStringBuilder = new StringBuilder();
        inputStringBuilder.append("a");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("n");
        ByteArrayInputStream in = new ByteArrayInputStream(inputStringBuilder.toString().getBytes());
        System.setIn(in);

        ConnectFourGame.main(null);

        StringBuilder scoreBoardStringBuilder = new StringBuilder();
        scoreBoardStringBuilder.append("\n-------------------------------------------");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("S C O R E B O A R D");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("-------------------------------------------");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("X Wins: 1");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("O Wins: 0");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("Ties: 0");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("-------------------------------------------");
        scoreBoardStringBuilder.append( System.getProperty("line.separator"));

        assert(outContent.toString().contains(scoreBoardStringBuilder.toString()));
        assert(outContent.toString().contains("Player X has won the game!"));
        assert(outContent.toString().contains("Invalid input. Try again"));

        System.setIn(System.in);
    }

    /**
     * Tests output from invalid move
     */
    @Test
    public void testInvalidMove() {
        StringBuilder inputStringBuilder = new StringBuilder();
        inputStringBuilder.append("-1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("n");
        ByteArrayInputStream in = new ByteArrayInputStream(inputStringBuilder.toString().getBytes());
        System.setIn(in);

        ConnectFourGame.main(null);

        StringBuilder scoreBoardStringBuilder = new StringBuilder();
        scoreBoardStringBuilder.append("\n-------------------------------------------");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("S C O R E B O A R D");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("-------------------------------------------");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("X Wins: 1");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("O Wins: 0");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("Ties: 0");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("-------------------------------------------");
        scoreBoardStringBuilder.append( System.getProperty("line.separator"));

        assert(outContent.toString().contains(scoreBoardStringBuilder.toString()));
        assert(outContent.toString().contains("Player X has won the game!"));
        assert(outContent.toString().contains("Invalid column. Try again"));

        System.setIn(System.in);
    }

    /**
     * Tests output from player O winning.
     */
    @Test
    public void testOWins() {
        StringBuilder inputStringBuilder = new StringBuilder();
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("2");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("n");
        ByteArrayInputStream in = new ByteArrayInputStream(inputStringBuilder.toString().getBytes());
        System.setIn(in);

        ConnectFourGame.main(null);

        StringBuilder scoreBoardStringBuilder = new StringBuilder();
        scoreBoardStringBuilder.append("\n-------------------------------------------");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("S C O R E B O A R D");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("-------------------------------------------");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("X Wins: 0");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("O Wins: 1");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("Ties: 0");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("-------------------------------------------");
        scoreBoardStringBuilder.append( System.getProperty("line.separator"));

        assert(outContent.toString().contains(scoreBoardStringBuilder.toString()));
        assert(outContent.toString().contains("Player O has won the game!"));

        System.setIn(System.in);
    }

    /**
     * Tests output from a tie.
     */
    @Test
    public void testTie() {
        StringBuilder inputStringBuilder = new StringBuilder();
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("4");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("4");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("4");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("4");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("4");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("4");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("5");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("5");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("5");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("5");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("5");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("5");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("6");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("2");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("2");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("2");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("2");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("2");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("2");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("3");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("3");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("3");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("3");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("3");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("3");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("6");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("6");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("6");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("6");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("6");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("n");
        ByteArrayInputStream in = new ByteArrayInputStream(inputStringBuilder.toString().getBytes());
        System.setIn(in);

        ConnectFourGame.main(null);

        StringBuilder scoreBoardStringBuilder = new StringBuilder();
        scoreBoardStringBuilder.append("\n-------------------------------------------");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("S C O R E B O A R D");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("-------------------------------------------");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("X Wins: 0");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("O Wins: 0");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("Ties: 1");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("-------------------------------------------");
        scoreBoardStringBuilder.append( System.getProperty("line.separator"));

        assert(outContent.toString().contains(scoreBoardStringBuilder.toString()));
        assert(outContent.toString().contains("Tie Game!"));

        System.setIn(System.in);
    }

    /**
     * Tests output from two games being played.
     */
    @Test
    public void testTwoGames() {
        StringBuilder inputStringBuilder = new StringBuilder();
        // X wins
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("y");
        inputStringBuilder.append(System.getProperty("line.separator"));
        // O wins
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("2");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("n");
        ByteArrayInputStream in = new ByteArrayInputStream(inputStringBuilder.toString().getBytes());
        System.setIn(in);

        ConnectFourGame.main(null);

        StringBuilder scoreBoardStringBuilder = new StringBuilder();
        scoreBoardStringBuilder.append("\n-------------------------------------------");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("S C O R E B O A R D");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("-------------------------------------------");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("X Wins: 1");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("O Wins: 1");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("Ties: 0");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("-------------------------------------------");
        scoreBoardStringBuilder.append( System.getProperty("line.separator"));

        assert(outContent.toString().contains(scoreBoardStringBuilder.toString()));
        assert(outContent.toString().contains("Player X has won the game!"));
        assert(outContent.toString().contains("Player O has won the game!"));

        System.setIn(System.in);
    }

    /**
     * Tests output from player X winning.
     */
    @Test
    public void testXWins() {
        StringBuilder inputStringBuilder = new StringBuilder();
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("1");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("0");
        inputStringBuilder.append(System.getProperty("line.separator"));
        inputStringBuilder.append("n");
        ByteArrayInputStream in = new ByteArrayInputStream(inputStringBuilder.toString().getBytes());
        System.setIn(in);

        ConnectFourGame.main(null);

        StringBuilder scoreBoardStringBuilder = new StringBuilder();
        scoreBoardStringBuilder.append("\n-------------------------------------------");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("S C O R E B O A R D");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("-------------------------------------------");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("X Wins: 1");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("O Wins: 0");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("Ties: 0");
        scoreBoardStringBuilder.append(System.getProperty("line.separator"));
        scoreBoardStringBuilder.append("-------------------------------------------");
        scoreBoardStringBuilder.append( System.getProperty("line.separator"));

        assert(outContent.toString().contains(scoreBoardStringBuilder.toString()));
        assert(outContent.toString().contains("Player X has won the game!"));

        System.setIn(System.in);
    }
}
