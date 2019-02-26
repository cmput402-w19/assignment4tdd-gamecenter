package hangman;

import java.util.Scanner;

public class HangmanGame {
	
	public void hangmanMenu() {
		
		while (true) {
			int selection = 0;
			
			Scanner scanner = new Scanner(System.in);
			
			while (selection < 1 || selection > 3) {
				System.out.print("\nPlease select one of the following:\n1. Play Hangman\n2. Rules of Hangman\n3. Go back\n> ");
				try {
					selection = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					;
				}
			}
			
			if (selection == 1) {
                System.out.println("\nYou can quit at anytime by typing 'quit' into the letter guess field.");
                
                hangmanLoop(scanner);
                
			} else if (selection == 2) {
				System.out.println("\nThe goal of the game is to guess a hidden word by revealing it's letters one by one." +
						"\nGuessing letters will reveal them if they are in the hidden word." +
						"\nCareful however, guessing a letter not present in the hidden word will cause you to lose a life." + 
						"\nGuess all letters correctly before losing 6 lives to win.");
			} else {
				return;
			}
		}
	}
	
	private void printBoard(HangmanBoard board) {
		System.out.println("\nLives Left: "+board.getLives());
		for(int i = 0; i < board.getWordLength(); ++i) {
			System.out.print(board.getCharToPrint(i)+" ");
		}
		System.out.println();
	}
	
	private char getGuess(Scanner scanner) {
		String input;
		while (true) {
			input = scanner.nextLine();
			
			if (input == "quit") return '.';
			
			if (input.length() != 1) {
				System.out.print("\nPlease enter a single character:\n> ");
				continue;
			}
			
			char guess = Character.toUpperCase(input.charAt(0));
			
			if (guess < 65 || guess > 90) {
				System.out.print("\nPlease enter a letter:\n> ");
				continue;
			}
			
			return guess;
		}
	}
	
	private void hangmanLoop(Scanner scanner) {
		HangmanBoard board = new HangmanBoard();
		
		while (true) {
			if (board.getLives() == 0) {
				System.out.println("\nYou ran out of lives!");
				return;
			}
			
			printBoard(board);
			
			System.out.print("\nGuess a letter:\n> ");
			
			char guess = getGuess(scanner);
			
			if (guess == '.') return;
			
			boolean found = false;
			for (int i = 0; i < board.getWordLength(); ++i) {
				if (guess == board.peekChar(i)) {
					found = true;
					board.revealAt(i);
				}
			}
			
			if (!found) board.decrementLives();
			
			if (board.hasWon()) {
				printBoard(board);
				System.out.println("YOU WIN!");
				return;
			}
		}
	}
}
