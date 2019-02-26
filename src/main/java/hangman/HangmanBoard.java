package hangman;

import java.util.Random;

public class HangmanBoard {
	
	private String[] dictionary = {"RAVIOLI","MACARONI","SPAGHETTI","LINGUINE","LASAGNE","FETTUCCINE","TORTELLINI"};
	private String word;
	private boolean[] revealed;
	private int lives;
	
	public HangmanBoard() {
		Random rand = new Random();
		
		lives = 6;
		word = dictionary[rand.nextInt(dictionary.length)];
		revealed = new boolean[word.length()];
	}
	
	public HangmanBoard(String word) {
		lives = 6;
		this.word = word.toUpperCase();
		revealed = new boolean[word.length()];
	}
	
	public char getCharToPrint(int index) {
		if (!revealed[index]) {
			return '_';
		} else {
			return word.charAt(index);
		}
	}
	
	public void revealAt(int index) {
		revealed[index] = true;
	}
	
	public char peekChar(int index) {
		return word.charAt(index);
	}
	
	public boolean hasWon() {
		for(boolean b : revealed) {
			if (!b) return false;
		}
		return true;
	}
	
	public int getWordLength() {
		return word.length();
	}
	
	public int getLives() {
		return lives;
	}
	
	public String getWord() {
		return word;
	}
	
	public void decrementLives() {
		lives--;
	}
}
