package ConnectFour;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Contains game board logic of connect four game.
 */
public class ConnectFourBoard {
    private static final int COLUMNS = 7;
    private static final int ROWS = 6;

    private Player[][] board;
    private Player currentPlayer;
    private Player winner;

    public enum Player {X, O, NONE}

    /**
     * Initializes a new instance of the ConnectFourBoard class.
     *
     * Based on TicTacToe "Board" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    public ConnectFourBoard(){
        this.board = new Player[ROWS][COLUMNS];
        this.initBoard();
        this.winner = null;
        this.currentPlayer = Player.X;
    }

    /**
     * Gets the game board.
     */
    public Player[][] getBoard(){
        return this.board;
    }

    /**
     * Gets the current player.
     * @return the player to play a move.
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Gets the player at the specified row and column on the board.
     * @param row the specified row position.
     * @param column the specified column position.
     * @return the player in the position.
     */
    public Player getPlayerAtPosition(int row, int column) {
        return this.getBoard()[row][column];
    }

    /**
     * Gets the string representation of a player type.
     * @param player the player to convert to a string.
     * @return a string representation of the player.
     *
     * Based on TicTacToe "getSymbol" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    public String getSymbol(Player player) {
        switch(player){
            case X:
                return "X";
            case O:
                return "O";
            case NONE:
                return " ";
            default:
                return "UNKNOWN SYMBOL";
        }
    }

    /**
     * Gets the winner of the game.
     * @return the player with four pieces in a row.
     */
    public Player getWinner() {
        return this.winner;
    }

    /**
     * Checks if the board is full.
     * @return true if the board is full, false otherwise.
     */
    public boolean isFull() {
        for (int i = 0; i < COLUMNS; ++i) {
            if (!this.isColumnFull(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Plays a move on the game board.
     * @param column the column to drop a player piece into
     * @throws InvalidMoveException
     *
     * Based on TicTacToe "playMove" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    public void playMove(int column) throws InvalidMoveException {
        if(column < 0 || column >= COLUMNS) {
            throw new InvalidMoveException("Input column is outside the board. Try again");
        }

        if(this.isColumnFull(column)) {
            //the given coordinates already contain a played move
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid Move: Column ");
            stringBuilder.append(column);
            stringBuilder.append(" is full!");
            throw new InvalidMoveException(stringBuilder.toString());
        }
        else {
            Player[][] board = this.getBoard();
            Player currentPlayer = this.getCurrentPlayer();
            int row;
            for (row = ROWS - 1; row >= 0; --row) {
                if (board[row][column].equals(Player.NONE)) {
                    board[row][column] = currentPlayer;
                    break;
                }
            }

            if (this.hasWon(row, column)) {
                this.winner = currentPlayer;
            }
            else if (this.currentPlayer == Player.X) {
                this.currentPlayer = Player.O;
            }
            else {
                this.currentPlayer = Player.X;
            }
        }
    }

    /**
     * Prints the board.
     *
     * Based on TicTacToe "printBoard" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    public void printBoard(){
        System.out.println();
        for(int row  = 0; row < ROWS; ++row){
            for(int column = 0 ; column < COLUMNS; ++column){
                System.out.print(this.getSymbol(this.getBoard()[row][column]));
                if (column != COLUMNS - 1) {
                    System.out.print(" | ");
                }
            }

            System.out.println("\n-------------------------");
        }

        System.out.println();
    }

    /**
     * Checks if horizontal row has four of the same player.
     * @param row the row to start the check.
     * @param column the column to start the check.
     * @return true if there is four in a row, false otherwise.
     */
    private boolean checkHorizontal(int row, int column) {
        Player[][] board = this.getBoard();
        Player currentPlayer = this.getCurrentPlayer();
        int count = 0;

        //check to the right
        for (int i = column; i < COLUMNS; ++i) {
            if (board[row][i].equals(currentPlayer)) {
                ++count;
            }
            else {
                break;
            }
        }

        //check to the left
        for (int i = column - 1; i >= 0; --i) {
            if (board[row][i].equals(currentPlayer)) {
                ++count;
            }
            else {
                break;
            }
        }

        if (count >= 4) {
            return true;
        }

        return false;
    }

    /**
     * Checks if the left diagonal has four of the same player.
     * @param row the row to start the check.
     * @param column the column to start the check.
     * @return true if there is four in a row, false otherwise.
     */
    private boolean checkLeftDiagonal(int row, int column) {
        Player[][] board = this.getBoard();
        Player currentPlayer = this.getCurrentPlayer();
        int count = 0;
        int i = row;
        int j = column;

        // check up to the right
        while(i >= 0 && j < COLUMNS) {
            if(board[i][j].equals(currentPlayer)) {
                ++count;
            }
            else {
                break;
            }

            --i;
            ++j;
        }

        // check down to the left
        i = Math.min(row + 1, ROWS);
        j = Math.max(column - 1, 0);

        while(i < ROWS && j >= 0) {
            if(board[i][j].equals(currentPlayer)) {
                ++count;
            }
            else {
                break;
            }

            ++i;
            --j;
        }

        if(count >= 4) {
            return true;
        }

        return false;
    }

    /**
     * Checks if the right diagonal has four of the same player.
     * @param row the row to start the check.
     * @param column the column to start the check.
     * @return true if there is four in a row, false otherwise.
     */
    private boolean checkRightDiagonal(int row, int column) {
        Player[][] board = this.getBoard();
        Player currentPlayer = this.getCurrentPlayer();
        int count = 0;
        int i = row;
        int j = column;

        // check down to the right
        while(i < ROWS && j < COLUMNS) {
            if(board[i][j].equals(currentPlayer)) {
                ++count;
            }
            else {
                break;
            }

            ++i;
            ++j;
        }

        // check up to the left
        i = Math.max(row - 1, 0);
        j = Math.max(column - 1, 0);

        while(i >= 0 && j >= 0) {
            if(board[i][j].equals(currentPlayer)) {
                ++count;
            }
            else {
                break;
            }

            --i;
            --j;
        }

        if(count >= 4) {
            return true;
        }

        return false;
    }

    /**
     * Checks if vertical column has four of the same player.
     * @param row the row to start the check.
     * @param column the column to start the check.
     * @return true if there is four in a row, false otherwise.
     */
    private boolean checkVertical(int row, int column) {
        Player[][] board = this.getBoard();
        Player currentPlayer = this.getCurrentPlayer();
        int count = 0;

        //check above
        for (int i = row; i >= 0; --i) {
            if (board[i][column].equals(currentPlayer)) {
                ++count;
            }
            else {
                break;
            }
        }

        //check below
        for (int i = row + 1; i < ROWS; ++i) {
            if (board[i][column].equals(currentPlayer)) {
                ++count;
            }
            else {
                break;
            }
        }

        if (count >= 4) {
            return true;
        }

        return false;
    }


    /**
     * Checks if the last move made has won.
     * @param row the last row a move was played in.
     * @param column the last column a move was played in.
     * @return true is the current player has won, false otherwise.
     *
     * Based on TicTacToe "hasWon" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    private boolean hasWon(int row, int column){
        if (this.checkHorizontal(row, column) || this.checkVertical(row, column) || this.checkRightDiagonal(row, column) || this.checkLeftDiagonal(row, column)) {
            return true;
        }

        return false;
    }

    /**
     * Initializes each space on board to Player.NONE.
     *
     * Based on TicTacToe "initBoard" by Sarah Nadi:
     * https://github.com/cmput402-w19/tictactoe
     */
    private void initBoard(){
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                this.board[row][column] = Player.NONE;
            }
        }
    }

    /**
     * Tests if the column is full.
     * @param column the column to check.
     * @return true if column is full, false otherwise.
     */
    private boolean isColumnFull(int column) {
        Player[][] board = this.getBoard();
        for (int row = ROWS - 1; row >= 0; --row) {
            if (board[row][column].equals(Player.NONE))
            {
                return false;
            }
        }

        return true;
    }
}
