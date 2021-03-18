package com.io.dynamic.programming;

public class StairCaseProblem {

	public static void main(String[] args) {
		// System.out.println(countWays(0));
		System.out.println(countWaysTabulizationWay(3));

	}

	// Best Approach - tabulation way
	private static int countWaysTabulizationWay(int n) {
		int[] lookupTable = new int[n + 1];

		if (n < 0) {
			return 0;
		} else if (n == 1 || n == 0) {
			return 1;
		} else {

			lookupTable[0] = 1;
			lookupTable[1] = 1;
			lookupTable[2] = 2;

			for (int i = 3; i <= n; i++) {
				lookupTable[i] = lookupTable[i - 1] + lookupTable[i - 2] + lookupTable[i - 3];
			}
		}
		return lookupTable[n];

	}

	// Brute force way
	public static int countWays(int n) {

		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
	}

}
