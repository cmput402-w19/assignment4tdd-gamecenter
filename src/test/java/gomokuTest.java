import gomoku.goBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class gomokuTest {

    private int[][] emptyBoard = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStream(){
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreans(){
        System.setOut(originalOut);
    }

    @Test
    public void CreateEmptyBoard(){
        goBoard gob = new goBoard();
        assertArrayEquals(gob.board, emptyBoard);
    }

    @Test
    public void PlayMove(){
        goBoard gob = new goBoard();

        gob.playMove(1, 1);
        int[][] board = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertArrayEquals(gob.board, board);

        assertEquals(gob.validMove(8, 4), "");
        gob.playMove(8, 4);
        board[3][7] = -1;
        assertArrayEquals(gob.board, board);

        assertEquals(gob.validMove(8, 4), "Invalid position");
        assertEquals(gob.validMove(8, 0), "Position out of bounds");
        assertEquals(gob.validMove(0, 4), "Position out of bounds");
        assertEquals(gob.validMove(20, 4), "Position out of bounds");
        assertEquals(gob.validMove(8, 20), "Position out of bounds");

    }

    @Test
    public void ResetBoard(){
        goBoard gob = new goBoard();

        gob.board[1][1] = 1;
        gob.reset();

        assertArrayEquals(gob.board, emptyBoard);
    }

    @Test
    public void WinConditions(){
        goBoard gob = new goBoard();
        assertEquals(gob.checkWinner(), 0);

        gob.printBoard();
        assertEquals("[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator"), outContent.toString());

        outContent.reset();
        for (int x=0; x < 5; x++){
            gob.board[1][x] = 1;
        }
        assertEquals(gob.checkWinner(), 1);

        gob.printBoard();
        assertEquals("[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[B, B, B, B, B, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator"), outContent.toString());

        outContent.reset();
        gob.reset();
        for (int x=0; x < 5; x++){
            gob.board[x][1] = 1;
        }
        assertEquals(gob.checkWinner(), 1);

        gob.printBoard();
        assertEquals("[*, B, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, B, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, B, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, B, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, B, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator"), outContent.toString());

        outContent.reset();
        gob.reset();
        for (int x=0; x < 5; x++){
            gob.board[x][x] = 1;
        }
        assertEquals(gob.checkWinner(), 1);

        gob.printBoard();
        assertEquals("[B, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, B, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, B, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, B, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, B, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator") +
                "[*, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *]" +
                System.getProperty("line.separator"), outContent.toString());

        gob.reset();
        for (int x=5; x < 10; x++){
            gob.board[x][x] = -1;
        }
        assertEquals(gob.checkWinner(), -1);

        gob.board = new int[][]{
                {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1},
                {-1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1},
                {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1},
                {-1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1},
                {-1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1},
                {-1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1},
                {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1},
                {-1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1},
                {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1},
                {-1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1},
                {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1},
                {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1},
                {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1},
                {-1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1},
                {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1},
                {-1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1},
                {-1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1},
                {-1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1},
                {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1},
        };

        assertEquals(gob.checkWinner(), 2);

    }

    @Test
    public void Score(){
        goBoard gob = new goBoard();

        assertEquals(gob.blackscore, 0);
        assertEquals(gob.whitescore, 0);
        assertEquals(gob.ties, 0);

        for (int x=0; x < 5; x++){
            gob.board[1][x] = 1;
        }

        gob.checkWinner();

        assertEquals(gob.blackscore, 1);
        assertEquals(gob.whitescore, 0);
        assertEquals(gob.ties, 0);

        gob.reset();

        for (int x=0; x < 5; x++){
            gob.board[1][x] = -1;
        }

        gob.checkWinner();
        assertEquals(gob.blackscore, 1);
        assertEquals(gob.whitescore, 1);
        assertEquals(gob.ties, 0);

        gob.reset();

        for (int x=0; x < 5; x++){
            gob.board[x][1] = -1;
        }

        gob.checkWinner();
        assertEquals(gob.blackscore, 1);
        assertEquals(gob.whitescore, 2);
        assertEquals(gob.ties, 0);
    }

    @Test
    public void Scoreboard(){
        goBoard gob = new goBoard();
        gob.printScore();
        assertEquals("Scoreboard\n-------------\nBlack: " + gob.blackscore + "\nWhite: " + gob.whitescore +
                "\nTies: " + gob.ties + System.getProperty("line.separator"), outContent.toString());
    }

}
