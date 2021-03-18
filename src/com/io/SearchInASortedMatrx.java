package com.io;

public class SearchInASortedMatrx {

	public static void main(String[] args) {
		int[][] matrix = { { 10, 11, 12, 13 }, { 14, 15, 16, 17 }, { 27, 29, 30, 31 }, { 32, 33, 39, 50 } };
		// Example 1
		// Object x = findKeyBruteForceWay(matrix, 4, 4, 80);
		Object x = findKeyBinarySearchWay(matrix, 4, 4, 80);
		System.out.println("Search for 80 returned: " + x);

		// Example 2
		// x = findKeyBruteForceWay(matrix, 4, 4, 15);
		x = findKeyBinarySearchWay(matrix, 4, 4, 15);
		System.out.println("Search for 15 returned: " + x);

	}

	private static Object findKeyBruteForceWay(int[][] matrix, int row, int col, int findThis) {
		// TODO Auto-generated method stub

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (findThis == matrix[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	//Binary seach way of finding an element in a given 2-D sorted array
	private static Object findKeyBinarySearchWay(int[][] matrix, int row, int col, int findThis) {
		int min = 0;
		int max = row * col - 1;

		while (min <= max) {
			int mid = (min + max) / 2;
			int row1 = mid / col;
			int col1 = mid % col;

			if (findThis < matrix[row1][col1]) {
				max = mid - 1;
			} else if (findThis > matrix[row1][col1]) {
				min = mid + 1;
			} else {
				return true;
			}
		}

		return false;
	}

}
