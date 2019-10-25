package lilSudoku;

import java.util.Random;

public class LilSudoku {
	int[][] board;
	public static final int EMPTY = 0; // empty cell
	public static final int SIZE = 3; // size of our Sudoku grids
	Random rnd = new Random();
	
	public LilSudoku() {
		this.board = new int[SIZE][SIZE];
		this.generateBoard();
	}
	
	private void generateBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = EMPTY;
			}
		}
	}
	
	private int generateRndNum() {
		return rnd.nextInt(9) + 1;
	}
	
	private boolean isRowOk(int row, int n) {
		for (int i = 0; i < SIZE; i++) {
			if (board[row][i] == n) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isColOk(int col, int n) {
		for (int i = 0; i < SIZE; i++) {
			if (board[i][col] == n) {
				return false;
			}
		}
		return true;
	}
	
//	private boolean isBoxOk(int row, int col, int n) {
//		for (int i = 0; i < SIZE; i++) {
//			for (int j = 0; j < SIZE; j++) {
//				if (board[i][j] == n) {
//					return false;
//				}
//			}
//		}
//		return true;
//	}
	
	private boolean isBoardOk(int row, int col, int n) {
//		return isRowOk(row, n) && isColOk(col, n) && isBoxOk(row, col, n);
		return isRowOk(row, n) && isColOk(col, n);
	}
	
	public void solve() {
		
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				if (board[row][col] == EMPTY) {
					
					int num = generateRndNum();
					
					while (!isBoardOk(row, col, num)) {
						num = num + 1 < 10 ? ++num : 1; 
					}
					board[row][col] = num;
				}
			}
		}
	}
	
	public void display() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(" " + board[i][j]);
			}

			System.out.println();
		}

		System.out.println();
	}
	

	public static void main(String[] args) {
		LilSudoku lilSudoku = new LilSudoku();
		lilSudoku.solve();
		lilSudoku.display();
	}

}
