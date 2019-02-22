package gomoku;

import java.util.ArrayList;
import java.util.List;

public class goBoard {

    public int[][] board;
    public int blackscore;
    public int whitescore;
    public int ties;
    public int turn;

    public goBoard(){
        board = new int[][]{
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

        blackscore = 0;
        whitescore = 0;
        ties = 0;
        turn = 1;
    }

    public void reset(){
        board = new int[][]{
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

        turn = 1;
    }

    public String validMove(int x, int y){
        if (x < 1 || y < 1 || x > 19 || y > 19){
            return "Position out of bounds";
        }

        if (board[y-1][x-1] != 0){
            return "Invalid position";
        }

        return "";
    }

    public void playMove(int x, int y){
        board[y-1][x-1] = turn;
        turn = turn * -1;
    }

    public int checkWinner(){
        boolean filled = true;

        // Check vertical
        for (int y=0; y < 19; y++){
            int black = 0;
            int white = 0;
            for (int x=0; x < 19; x++){
                if (board[x][y] == 1){
                    black += 1;
                    white = 0;
                } else if (board[x][y] == -1){
                    white += 1;
                    black = 0;
                } else {
                    filled = false;
                    black = 0;
                    white = 0;
                }

                if (black >= 5){
                    blackscore += 1;
                    return 1;
                }

                if (white >= 5){
                    whitescore += 1;
                    return -1;
                }
            }
        }

        if (filled){
            ties += 1;
            return 2;
        }


        // Check horizontal
        for (int y=0; y < 19; y++){
            int black = 0;
            int white = 0;
            for (int x=0; x < 19; x++){
                if (board[y][x] == 1){
                    black += 1;
                    white = 0;
                } else if (board[y][x] == -1){
                    white += 1;
                    black = 0;
                } else {
                    black = 0;
                    white = 0;
                }

                if (black >= 5){
                    blackscore += 1;
                    return 1;
                }

                if (white >= 5){
                    whitescore += 1;
                    return -1;
                }
            }
        }

        // Check diagonal

        for(int offset = 0; offset < 15; offset++){
            int[][] win_sums = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};

            for (int pos = 0; pos < 19 - offset; pos++){
                int[][] points = {{pos + offset, pos}, {pos, pos + offset}, {18 - (pos + offset), pos}, {18 - pos, pos + offset}};

                for (int x=0; x < 4; x++){
                    if (board[points[x][0]][points[x][1]] == 1){
                        win_sums[x][0] += 1;
                        win_sums[x][1] = 0;

                        if (win_sums[x][0] >=5){
                            blackscore += 1;
                            return 1;
                        }
                    }else if (board[points[x][0]][points[x][1]] == -1){
                        win_sums[x][0] = 0;
                        win_sums[x][1] += 1;

                        if (win_sums[x][1] >= 5){
                            whitescore += 1;
                            return -1;
                        }
                    } else {
                        win_sums[x][0] = 0;
                        win_sums[x][1] = 0;
                    }
                }

            }
        }

        return 0;
    }


    public void printBoard(){
        for (int y =0; y < 19; y++){
           List<Character> row = new ArrayList<Character>();
            for (int x=0; x < 19; x++){
                int elem = board[y][x];

                if (elem == 1){
                    row.add('B');
                }else if (elem == -1){
                    row.add('W');
                }else{
                    row.add('*');
                }
            }
            System.out.println(row);
        }
    }

    public void printScore(){
        System.out.println("Scoreboard\n-------------\nBlack: " + blackscore + "\nWhite: " + whitescore + "\nTies: " + ties);
    }
}
