package ics124.c0507133.assignment1;

import ics124.assignment1.TicTacToeInterface;

/**
 *
 * @author Mitchell Saremba
 * @version 1.0
 *
 * Defines TicTacToeBoard.board data structure. Keeps track of it's state throughout
 * the game and determines when the game should end - either when one player wins or
 * when the board is full.
 * 
 * 
 */
public class TicTacToeBoard implements TicTacToeInterface {

	public static char[][] board = {
		{' ', ' ', ' '},
		{' ', ' ', ' '},
		{' ', ' ', ' '}};

	private int totalMoves;

	public TicTacToeBoard() {
		this.totalMoves = 0;
	}
	
	@Override
	public void makeMove(int row, int col, char player) {
		board[row][col] = player;
		this.totalMoves += 1;
	}

	@Override
	public boolean isWinner(char player) {
		// Check horizontal line
		if (this.checkRows(player)) {
			return true;
		} // Check vertical lines
		else if (this.checkCols(player)) {
			return true;
		} // Check diagonal lines
		else if (this.checkDiagonals(player)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isFull() {
		return this.totalMoves >= 9;
	}

	private boolean checkRows(char player) {
		for (int row = 0; row < board.length; row++) {
			if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				return true;
			}
		}
		return false;
	}

	private boolean checkCols(char player) {
		for (int col = 0; col < board[0].length; col++) {
			if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDiagonals(char player) {
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		} else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}

		return false;
	}
}