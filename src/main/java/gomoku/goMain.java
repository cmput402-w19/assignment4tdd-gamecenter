package gomoku;

import java.io.IOException;
import java.util.Scanner;

public class goMain {

    public void gomokumenu(){
        goBoard gob = new goBoard();

        while (true){
            System.out.println("\nPlease select one of the following:\n1. Play Gomoku\n2. Rules of Gomoku\n3. Go back");
            int choice = 0;

            Scanner reader = new Scanner(System.in);

            while (choice < 1 || choice > 3) {
                System.out.print("> ");
                try {
                    choice = Integer.parseInt(reader.nextLine());
                } catch (NumberFormatException e){
                    ;
                }
            }

            if (choice == 1){
                System.out.println("You can quit at anytime by typing 'quit' into the position selection." +
                        "(Press enter to continue)");
                try {
                    System.in.read();
                } catch (IOException e){
                    ;
                }

                gomokuloop(gob);

            }else if (choice == 2){
                System.out.println("\nBlack plays first, and players alternate in placing a stone of their color on" +
                        "an empty\nposition. The winner is the first player to get an unbroken row of five stones" +
                        "horizontally, \nvertically, or diagonally.\n");
            }
            else{
                return;
            }
        }

    }

    private void gomokuloop(goBoard gob){
        Scanner reader = new Scanner(System.in);
        while (gob.checkWinner() == 0){
            gob.printBoard();

            boolean input = false;
            int x = 0, y = 0;
            while (!input){

                if (gob.turn == 1){
                    System.out.print("\nBlack");
                } else{
                    System.out.print("\nWhite");
                }
                System.out.print(" to play. Please input your move as xx-yy: ");

                String choice = reader.nextLine();
                if (choice.length() > 5 || choice.length() < 3) {
                    continue;
                }else if (choice.equalsIgnoreCase("quit")){
                    return;
                }else if (!errorCheckChoice(choice)) {
                    continue;
                }


                String[] data = choice.split("-");
                x = Integer.parseInt(data[0]);
                y = Integer.parseInt(data[1]);
                String err = gob.validMove(x, y);

                if (!err.equals("")){
                    System.out.println(err);
                    input = false;
                }else{
                    input = true;
                }

            }

            gob.playMove(x, y);

        }
        gob.reset();
        gob.printScore();
    }

    private boolean errorCheckChoice(String input){
        if (input.length() - input.replace("-", "").length() != 1){
            return false;
        }

        String[] data = input.split("-");
        if (data.length != 2){
            return false;
        }

        try{
            Integer.parseInt(data[0]);
            Integer.parseInt(data[1]);
        }catch (NumberFormatException e){
            return false;
        }

        return true;
    }
}
