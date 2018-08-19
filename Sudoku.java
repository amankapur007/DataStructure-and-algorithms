package com.aman.algorithms.backtracking;

import java.util.Scanner;

public class Sudoku {

	private static int rowsFilled = 0;

	// private static int columnsFilled=0;
	public static void main(String[] args) {

		int size = 9;
		// int matrix[][] = new int[size][size];
		int matrix[][] = { 
				{ 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
				{ 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
				};
		setNumbersInSudoku(matrix, size, 0, 0, 1, 0);
		print(matrix, size);
	}
	
	/*public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t= sc.nextInt();
		while(t!=0) {
			int matrix[][] = new int[9][9];
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					int n =sc.nextInt();
					matrix[i][j]=n;
				}
			}
			rowsFilled=0;
			if(setNumbersInSudoku(matrix, 9, 0, 0, 1, 0)){
				print(matrix, 9);
			}
			System.out.println();
			t--;
		}
	}*/

	private static void print(int[][] matrix, int size) {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			//System.out.println();
		}
	}

	private static boolean setNumbersInSudoku(int[][] matrix, int size, int row, int column, int number,
			int columnsFilled) {

		if (row == size) {
			return true;
		}

		for (int no = 1; no <= size; no++) {
			if (column < size) {
				if (matrix[row][column] == 0) {
					if (check(matrix, row, column, no, size)) {
						columnsFilled = columnsFilled + 1;
						matrix[row][column] = no;
						if (setNumbersInSudoku(matrix, size, row, column + 1, number, columnsFilled + 1)) {
							return true;
						} else {
							columnsFilled = columnsFilled - 1;
							matrix[row][column] = 0;
						}
					}
				} else {
					return setNumbersInSudoku(matrix, size, row, column + 1, number, column + 1);
				}
			} else {
				return setNumbersInSudoku(matrix, size, row + 1, 0, 1, 0);
			}
		}

		return false;
	}

	private static boolean check(int[][] matrix, int row, int col, int no, int size) {
		int rowstart=0;
		int rowend=0;
		int colstart=0;
		int colend=0;
		if (row < 3) {
			rowstart=0;
			rowend=3;
		} else if (row >= 3 && row < 6) {
			rowstart=3;
			rowend=6;
		} else {
			rowstart=6;
			rowend=9;
		}

		if (col < 3) {
			colstart=0;
			colend=3;
		} else if (col >= 3 && col < 6) {
			colstart=3;
			colend=6;
		} else {
			colstart=6;
			colend=9;
		}
		
		for(int i=rowstart;i<rowend;i++) {
			for(int j=colstart;j<colend;j++) {
				if(row!=i && col!=j && matrix[i][j]==no) {
					return false;
				}
			}
		}
		
		for (int i = 0; i < size; i++) {
			if (row != i && matrix[i][col] == no) {
				return false;
			}
		}

		for (int i = 0; i < size; i++) {
			if (col != i && matrix[row][i] == no) {
				return false;
			}
		}
		return true;
	}
}
