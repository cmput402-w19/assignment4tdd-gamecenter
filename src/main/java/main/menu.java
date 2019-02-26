package main;

import gomoku.goMain;
import ConnectFour.ConnectFourGame;
import hangman.HangmanGame;

import java.util.Scanner;

public class menu {

    public static void main( String[] args )
    {
        int choice = 0;
        Scanner reader = new Scanner(System.in);
        while (choice != 4) {
            choice = 0;
            System.out.println(" ______     ______     __    __     ______        ______     ______     __   __     ______   ______     ______    \n" +
                    "/\\  ___\\   /\\  __ \\   /\\ \"-./  \\   /\\  ___\\      /\\  ___\\   /\\  ___\\   /\\ \"-.\\ \\   /\\__  _\\ /\\  ___\\   /\\  == \\   \n" +
                    "\\ \\ \\__ \\  \\ \\  __ \\  \\ \\ \\-./\\ \\  \\ \\  __\\      \\ \\ \\____  \\ \\  __\\   \\ \\ \\-.  \\  \\/_/\\ \\/ \\ \\  __\\   \\ \\  __<   \n" +
                    " \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_\\ \\ \\_\\  \\ \\_____\\     \\ \\_____\\  \\ \\_____\\  \\ \\_\\\\\"\\_\\    \\ \\_\\  \\ \\_____\\  \\ \\_\\ \\_\\ \n" +
                    "  \\/_____/   \\/_/\\/_/   \\/_/  \\/_/   \\/_____/      \\/_____/   \\/_____/   \\/_/ \\/_/     \\/_/   \\/_____/   \\/_/ /_/ \n"
            );

            System.out.println("Which game would you like to play?\n1. Gomuko\n2. Connect Four\n3. Hangman\n4. Quit");

            while (choice < 1 || choice > 4) {
                System.out.print("> ");
                try {
                    choice = Integer.parseInt(reader.nextLine());
                } catch (NumberFormatException e){
                    ;
                }
            }

            if (choice == 1) {
                System.out.println();
                goMain gom = new goMain();
                gom.gomokumenu();
            } else if (choice == 2) {
                ConnectFourGame connectFour = new ConnectFourGame();
                connectFour.start();
            } else if (choice == 3) {
                HangmanGame hangman = new HangmanGame();
                hangman.hangmanMenu();
            }
        }
        reader.close();
    }
}
