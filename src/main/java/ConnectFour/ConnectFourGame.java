package ConnectFour;

import java.util.Scanner;

/**
 * Contains connect four main method.
 */
public class ConnectFourGame {
    private ConnectFourBoard board;
    private int ties;
    private int numOfPlayerXWins;
    private int numOfPlayerOWins;

    /**
     * Initializes a new instance of the ConnectFourGame class.
     */
    public ConnectFourGame() {
        this.board = new ConnectFourBoard();
        this.ties = 0;
        this.numOfPlayerXWins = 0;
        this.numOfPlayerOWins = 0;
    }

    /**
     * Loops player turns while reading user input until a winner is determined or the board is full.
     *
     * Based on TicTacToe "playGame" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    public void playGame(Scanner scanner) {
        while (this.board.getWinner() == null) {
            if (this.board.isFull()) {
                break;
            }

            this.board.printBoard();
            this.promptNextPlayer();

            String line = scanner.nextLine();

            try {
                this.board.playMove(Integer.parseInt(line));
            }
            catch (InvalidMoveException e) {
                System.out.println("Invalid column. Try again");
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again");
            }
        }

        resolveGame();
    }

    /**
     * Prints the overall score.
     */
    public void printScoreBoard() {
        System.out.println("\n-------------------------------------------");
        System.out.println("S C O R E B O A R D");
        System.out.println("-------------------------------------------");
        System.out.println(String.format("X Wins: %d", this.numOfPlayerXWins));
        System.out.println(String.format("O Wins: %d", this.numOfPlayerOWins));
        System.out.println(String.format("Ties: %d", this.ties));
        System.out.println("-------------------------------------------");
    }

    /**
     * Prints a string to the command line prompting the current player for their column selection.
     *
     * Based on TicTacToe "promptNextPlayer" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    public void promptNextPlayer() {
        System.out.println("It's player " + this.board.getSymbol(this.board.getCurrentPlayer()) + "'s turn. Please enter the column of your next move: ");
    }

    /**
     * Creates a new instance of the game board.
     */
    public void resetGame() {
        this.board = new ConnectFourBoard();
    }

    /**
     * Prints the board and announces winner.
     *
     * Based on TicTacToe "resolveGame" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    private void resolveGame() {
        this.board.printBoard();

        ConnectFourBoard.Player winner = this.board.getWinner();

        // Check who the winner is and print their corresponding winning message.
        // If the winner is player X, increment X's score.
        // If the winner is player O, increment O's score.
        // Otherwise increment the number of ties.
        if (winner == null) {
            this.ties += 1;
            System.out.println("Tie Game!");
        } else {
            if (winner == ConnectFourBoard.Player.X) this.numOfPlayerXWins += 1;
            else if (winner == ConnectFourBoard.Player.O) this.numOfPlayerOWins += 1;
            System.out.println("Player " + winner + " has won the game!");
        }
    }

    /**
     * Runs connect four.
     *
     * Based on TicTacToe "main" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    public void start() {
        boolean play = true;
        Scanner scanner = new Scanner(System.in);

        while (play) {
            this.playGame(scanner);

            // Error check value till response is either y or n
            String response = "";
            while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
                System.out.print("Would you like to play again (y/n): ");
                response = scanner.nextLine();
            }

            if (response.equalsIgnoreCase("n")) {
                play = false;
                this.printScoreBoard();
            }
            else {
                this.resetGame();
            }
        }
    }
}
