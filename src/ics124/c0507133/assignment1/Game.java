package ics124.c0507133.assignment1;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Mitchell Saremba
 * @version 1.0
 *
 * Defines the logic for each game of TicTacToe. Responsible for taking user
 * inputs and handling bad user inputs.
 * 
 * To play a new game of TicTacToe, create a new instance of this class and call the playGame method.
 *
 */
public class Game {

	public final TicTacToeBoard b;
	public UserInterface ui;
	public final char x;
	public final char o;

	public Game() {
		this.b = new TicTacToeBoard();
		this.o = 'O';
		this.x = 'X';
	}

	public void playGame(char x, char o) {
		this.ui = new UserInterface();
		while (!b.isFull() || !b.isWinner(x) || !b.isWinner(o)) {
			this.takeTurn(x);
			this.takeTurn(o);
		}
	}

	/**
	 * Takes user input to change TicTacToeBoard state. Handles bad inputs.
	 */
	public void takeTurn(char c) {
		Scanner s = new Scanner(System.in);
		System.out.println("Turn: " + c);

		try {
			// Get coordinates from user
			System.out.print("\nEnter row: ");
			int row = s.nextInt();

			System.out.print("Enter column: ");
			int col = s.nextInt();

			// Make sure input is valid
			if (spotTaken(row, col)) {
				throw new SpotTakenException("That spot is taken.");
			}

			if (outOfRange(row, col)) {
				throw new IndexOutOfBoundsException();
			}

			// Adjust board state
			b.makeMove(row, col, c);
			ui.printBoard();

			// Make sure game isn't over
			this.checkForWinner('X');
			this.checkForWinner('O');

			if (b.isFull()) {
				System.out.println("Board is full! Press run to play again.");
				System.exit(0);
			}

			// Handle bad inputs
		} catch (SpotTakenException e) {
			System.out.println("\nThat spot is taken! Please try again.\n");
			takeTurn(c);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("\nThat ain't even a real spot. Try again.\n");
			takeTurn(c);
		} catch (InputMismatchException e) {
			System.out.println("\nPlease enter a number between 0 and 2.\n");
			takeTurn(c);
		}

	}

	public void checkForWinner(char player) {
		if (b.isWinner(player)) {
			System.out.printf("%c wins! Press run to play again.\n", player);
			System.exit(0);
		}
	}

	public boolean spotTaken(int row, int col) {
		return TicTacToeBoard.board[row][col] == 'X' || TicTacToeBoard.board[row][col] == 'O';
	}

	public boolean outOfRange(int row, int col) {
		return row > 2 || col > 2;
	}

	// CUSTOM EXCEPTIONS
	public static class SpotTakenException extends Exception {

		public SpotTakenException(String message) {
			super(message);
		}
	}

}
