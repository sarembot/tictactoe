package ics124.assignment1;

public interface TicTacToeInterface {
    public void makeMove(int row, int col, char player);
    public boolean isWinner(char player);
    public boolean isFull();
}

