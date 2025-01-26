package ics124.c0507133.assignment1;

import java.util.Scanner;

/**
 *
 * @author Mitchell Saremba 
 * @version 1.0
 * 
 * Responsible for printing the user interaction components. 
 * 
 */
public class UserInterface {

	public UserInterface() {
		UserInterface.printWelcomeMessage();
		UserInterface.printBoard();
	}

	public static void printWelcomeMessage() {
		System.out.println();
		// ASCII art generated at - https://patorjk.com/software/taag/ 
		System.out.println("""
				    _______ _   _______      _______         
				    |__   __(_) |__   __|    |__   __|        
				       | |   _  ___| | __ _  ___| | ___   ___ 
				       | |  | |/ __| |/ _` |/ __| |/ _ \\ / _ \\
				       | |  | | (__| | (_| | (__| | (_) |  __/
				       |_|  |_|\\___|_|\\__,_|\\___|_|\\___/ \\___|
				                                            """);

		System.out.println("By Mitchell Saremba.\n\nINSTRUCTIONS:\n\n  - This is a two player game - One player is 'X', the other 'O'\n  - When prompted, provide the coordinates for the square you'd like to fill\n  - Each coordinate requires two values; the row and the column.\n  - First you will be prompted for the row you'd like your play to be in, and then the column.\n  - Enter the numeric value corresponding to each row and column when prompted\n  - The player who gets 3 letters in a row - horizontal, vertical, or diagonal - is the winner\n  - If there are no more spots on the board, you'll have to play again.\n\nPress enter to begin...");

		Scanner s = new Scanner(System.in);
		s.nextLine(); // press key to start
	}

	public static void printBoard() {
		System.out.println();
		for (int col = 0; col < TicTacToeBoard.board.length; col++) {
			System.out.print("    " + col);
		}

		System.out.println();
		System.out.println("   |---|---|---|");

		for (int row = 0; row < TicTacToeBoard.board.length; row++) {
			System.out.print(" " + row);

			for (int col = 0; col < TicTacToeBoard.board[row].length; col++) {
				System.out.print(" | " + TicTacToeBoard.board[row][col]);
			}

			System.out.println(" |");
			System.out.println("   |---|---|---|");
		}

		System.out.println();
		System.out.println("------------------------------");
	}
}
