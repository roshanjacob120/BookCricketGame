package com.aurionpro.model;

import java.util.Random;
import java.util.Scanner;

public class BookCricketGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome To BookCricketGame");

        System.out.println("\nRules for the Game:");
        System.out.println("**Assume a book of 300 pages\n");

        System.out.println("1. Player1 opens the book to read a page number (example 87) (Randomly generated)");
        System.out.println("2. If the page number is 87-8717(%7 results in score between 8-6)= 3 should be added to the score");
        System.out.println("3. Player continues and keeps adding to the score until the page number results in a 0 score");
        System.out.println("4. Player 2 starts the game and tries to beat the score of player 1");
        System.out.println("5. In case of a tie, check the number of turns (player with lesser turns is the winner)");
        System.out.println("6. Show the winner of the game.");

        System.out.print("\nEnter 1 To Start Game And For Exit: ");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            System.out.print("\nEnter Player 1 Name: ");
            String player1Name = scanner.next();
            
            System.out.print("Enter Player 2 Name: ");
            String player2Name = scanner.next();

            int player1Score = playGame(player1Name, random);
            int player2Score = playGame(player2Name, random);

            System.out.println("\n" + player1Name + " Total Score: " + player1Score);
            System.out.println(player2Name + " Needs " + (player1Score + 1) + " Score To WIN MATCH");

            System.out.println("\n" + player2Name + " Total Score: " + player2Score);
            System.out.println(player1Name + " Needs " + (player2Score + 1) + " Score To WIN MATCH");

            if (player1Score > player2Score) {
                System.out.println("\nWinner: " + player1Name);
            } else if (player2Score > player1Score) {
                System.out.println("\nWinner: " + player2Name);
            } else {
                System.out.println("\nIt's a tie!");
            }
        } else {
            System.out.println("\nExiting the game.");
        }
    }

    private static int playGame(String playerName, Random random) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPlayer: " + playerName);

        int totalScore = 0;
        int rounds = 0;

        while (true) {
            System.out.print("\nEnter 1 To Open Book: ");
            int openBook = scanner.nextInt();
            
            if (openBook == 1) {
                int pageNumber = random.nextInt(300) + 1;
                int score = pageNumber % 7;
                
                System.out.println("Page Number: " + pageNumber);
                System.out.println("Point: " + score);

                if (score == 0) {
                    break;
                }

                totalScore += score;
                rounds++;
                
                System.out.println("Score: " + totalScore);
            } else {
                System.out.println("Invalid choice. Exiting the game.");
                System.exit(0);
            }
        }

        System.out.println("\n" + playerName + " Total Score: " + totalScore);
        System.out.println(playerName + " Takes " + rounds + " Rounds");

        return totalScore;
    }
}

