package com.io.dynamic.programming;

public class EditDistanceProblem {

	public static void main(String[] args) {
		String str1 = "Tuesday";
		String str2 = "Thursday";

		//System.out.println("Edit Distance of " + str1 + ", " + str2 + " = "
			//	+ minEditDistanceBruteForce(str1, str2, str1.length(), str2.length()));
	
		System.out.println("Edit Distance of " + str1 + ", " + str2 + " = " + minEditDistanceTabulation(str1, str2));
	
	}

	public static int minEditDistanceBruteForce(String str1, String str2, int m, int n) {

		if (m == 0)
			return n;
		if (n == 0)
			return m;

		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			return minEditDistanceBruteForce(str1, str2, m - 1, n - 1);

		return 1 + Math.min(
				Math.min(minEditDistanceBruteForce(str1, str2, m, n - 1),
						minEditDistanceBruteForce(str1, str2, m - 1, n)),
				minEditDistanceBruteForce(str1, str2, m - 1, n - 1));

	}

	
	public static void minEditDistanceTabulation(String str1, String str2) {

		int m = str1.length();
		int n = str2.length();
		
		int[][] lookupTable = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				if (i == 0) {
					lookupTable[i][j] = j;
				} else if (j == 0) {
					lookupTable[i][j] = i;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					lookupTable[i][j] = lookupTable[i - 1][j - 1];
				} else {
					lookupTable[i][j] = 1 + min(lookupTable[i][j - 1], // Insertion
							lookupTable[i - 1][j], // Deletion
							lookupTable[i - 1][j - 1]); // Replace
				}
			}
		}
		return lookupTable[m][n];
	}

	private static int min(int a, int b, int c) {
        if (a <= b && a <= c) return a; 
        if (b <= a && b <= c) return b; 
        else return c; 
	}
	
}
