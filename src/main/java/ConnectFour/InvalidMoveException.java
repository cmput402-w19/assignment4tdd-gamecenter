package ConnectFour;

/**
 * Class denoting an invalid move in connect four.
 *
 * Based on TicTacToe "InvalidMoveException" by Sarah Nadi:
 * https://github.com/cmput402-w19/tictactoe
 */
public class InvalidMoveException extends Exception{

    /**
     * Initializes new instance of InvalidMoveException class.
     * @param msg The message to be displayed.
     */
    public InvalidMoveException(String msg){
        super(msg);
    }
}
