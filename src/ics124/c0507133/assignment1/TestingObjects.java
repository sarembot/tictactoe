package ics124.c0507133.assignment1;

import ics124.utils.UnitTest;
import ics124.c0507133.assignment1.Game;

/**
 *
 * @author Mitchell Saremba
 * @Version 1.0
 *
 * For conducting unit tests on each component of the TicTacToeBoard
 * implementation and game play.
 *
 */
public class TestingObjects {

	UnitTest tests;

	public static void main(String[] args) {
		// Play game
		Game g = new Game();
		g.playGame(g.x, g.o);

		// Run tests - PASSED all 16 assertions
		TestingObjects me = new TestingObjects();
		me.run();

	}

	public TestingObjects() {
		tests = new UnitTest();
		tests.initTests();
	}

	public void run() {
		// Game tests:
		testSpotTaken();
		testOutOfRange();
		
		// TicTacToeBoard tests:
		// Test moves
		testMakeMove();

		// Test winning conditions
		testRowWin();
		testColWin();
		testDiagonalWin();

		// Test if board is full
		testBoardFull();

		System.out.println(tests.summarizeTests());
	}

	// TicTacToeBoard Tests ---------------------
	private void testMakeMove() {
		TicTacToeBoard b = new TicTacToeBoard();

		b.makeMove(0, 0, 'X');
		b.makeMove(1, 1, 'O');

		// Should be no winner and board !full
		tests.assertIsFalse(b.isWinner('X'), "X hasn't won yet.");
		tests.assertIsFalse(b.isWinner('O'), "O hasn't won yet.");

		// Test for proper placement
		tests.assertIsTrue(b.board[0][0] == 'X', "(0,0) should be 'X'");
		tests.assertIsTrue(b.board[1][1] == 'O', "(1,1) should be 'O'");

	}

	// test isWinner() method
	private void testRowWin() {
		// Arrange
		TicTacToeBoard b = new TicTacToeBoard();

		// Act
		b.makeMove(0, 0, 'X');
		b.makeMove(1, 1, 'O');
		b.makeMove(0, 1, 'X');
		b.makeMove(2, 0, 'O');
		b.makeMove(0, 2, 'X');

		// Assert
		tests.assertIsTrue(b.isWinner('X'), "X should win - top row");
		tests.assertIsFalse(b.isWinner('O'), "O should not win.");
	}

	private void testColWin() {
		// Arrange
		TicTacToeBoard b = new TicTacToeBoard();

		// Act
		b.makeMove(0, 0, 'X');
		b.makeMove(0, 1, 'O');
		b.makeMove(2, 0, 'X');
		b.makeMove(1, 1, 'O');
		b.makeMove(1, 0, 'X');
		b.makeMove(2, 1, 'O');

		// Assert
		tests.assertIsTrue(b.isWinner('O'), "O should win - middle col");
		tests.assertIsTrue(b.isWinner('X'), "X shouldn't win.");
	}

	private void testDiagonalWin() {
		// Arrange
		TicTacToeBoard b = new TicTacToeBoard();

		// Act
		b.makeMove(0, 0, 'X');
		b.makeMove(0, 1, 'O');
		b.makeMove(1, 1, 'X');
		b.makeMove(0, 2, '0');
		b.makeMove(2, 2, 'X');

		// Assert
		tests.assertIsTrue(b.isWinner('X'), "X should win by diagonal line.");
	}

	// test isFull() method
	private void testBoardFull() {
		// Arrange
		TicTacToeBoard b = new TicTacToeBoard();

		// Act

		// Empty board
		tests.assertIsFalse(b.isFull(), "Board should be empty");

		// Partially filled board
		b.makeMove(1, 1, 'X');
		b.makeMove(0, 1, 'O');
		b.makeMove(0, 2, 'X');
		b.makeMove(2, 1, 'O');

		tests.assertIsFalse(b.isFull(), "Board should be partially full.");

		// Test full board
		b.makeMove(0, 0, 'X');
		b.makeMove(0, 1, 'O');
		b.makeMove(0, 2, 'X');
		b.makeMove(1, 0, 'O');
		b.makeMove(1, 1, 'X');
		b.makeMove(1, 2, 'O');
		b.makeMove(2, 0, 'X');
		b.makeMove(2, 1, 'O');
		b.makeMove(2, 2, 'X');

		// Assert
		tests.assertIsTrue(b.isFull(), "Board should be full.");
	}

	// Game Tests ----------------------------

	private void testSpotTaken() {
		Game g = new Game();

		g.b.makeMove(1, 1, 'X');

		tests.assertIsTrue(g.spotTaken(1, 1), "Spot should be taken by 'X'");
		tests.assertIsFalse(g.spotTaken(0, 0), "Spot should be empty");
	}

	private void testOutOfRange() {
		Game g = new Game();

		tests.assertIsTrue(g.outOfRange(4, 5), "Spot should be out of range.");
		tests.assertIsFalse(g.outOfRange(0, 0), "Spot should be in range.");
	}

}
