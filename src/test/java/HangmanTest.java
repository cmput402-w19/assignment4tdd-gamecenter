import hangman.HangmanBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class HangmanTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    
    @Test
    public void createBoard() {
    	HangmanBoard hb = new HangmanBoard();
    	HangmanBoard hb2 = new HangmanBoard("Apples");
    	
    	assertEquals(hb.getLives(), 6);
    	assertEquals(hb2.getWord(), "APPLES");
    }
    
    @Test
    public void gettersAndMutators() {
    	HangmanBoard hb = new HangmanBoard("Apples");
    	hb.revealAt(2);
    	assertEquals('_', hb.getCharToPrint(1));
    	assertEquals('P', hb.getCharToPrint(2));
    	
    	assertEquals('A', hb.peekChar(0));
    	
    	assertEquals("APPLES", hb.getWord());
    	
    	assertEquals(6, hb.getWordLength());
    	
    	assertEquals(6, hb.getLives());
    	hb.decrementLives();
    	assertEquals(5, hb.getLives());
    }
    
    @Test
    public void winCondition() {
    	HangmanBoard hb = new HangmanBoard("Pear");
    	
    	hb.revealAt(0);
    	hb.revealAt(1);
    	hb.revealAt(2);
    	hb.revealAt(3);
    	
    	assertTrue(hb.hasWon());
    }
    
}
