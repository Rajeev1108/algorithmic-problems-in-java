package com.io.dynamic.programming;

public class LCS_RecursionNTopDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "abcd";
		String s2 = "ab";

		// System.out.println("Longest common for given substrings is--> "+
		System.out.println(LCSRecusrion(s1,s2,s1.length(),s2.length()));
		System.out.println(LCSRecusrionTopDown(s1, s2));
	}

	private static int LCSRecusrion(String s1, String s2, int s1Len, int s2Len) {
		// TODO Auto-generated method stub

		if (s1Len == 0 || s2Len == 0) {
			return 0;
		}

		if (s1.charAt(s1Len - 1) == s2.charAt(s2Len - 1)) {
			return 1 + LCSRecusrion(s1, s2, s1Len - 1, s2Len - 1);
		} else {

			return Math.max(LCSRecusrion(s1, s2, s1Len - 1, s2Len), LCSRecusrion(s1, s2, s1Len, s2Len - 1));

		}

	}

	private static int LCSRecusrionTopDown(String s1, String s2) {
		// TODO Auto-generated method stub

		int[][] lookupTable = new int[s1.length() + 1][];

		for (int i = 0; i < s1.length() + 1; i++) {
			lookupTable[i] = new int[s2.length() + 1];
		}

		for (int i = 0; i < s1.length() + 1; i++) {
			for (int j = 0; j < s2.length() + 1; j++) {
				lookupTable[i][j] = 0;
			}
		}
		int maxLen = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lookupTable[i][j] = 1 + lookupTable[i - 1][j - 1];
					maxLen = Math.max(maxLen, lookupTable[i][j]);
					//Use Math.Min to find out shortest common supersequence
				}

			}
		}
		return maxLen;

	}
	
	
	private static int shortestCommonSuperSeqTopDown(String s1, String s2) {
		// TODO Auto-generated method stub

		int len1 = s1.length();
		int len2 = s2.length();

		int[][] lookupTable = new int[len1 + 1][];

		for (int i = 0; i < len1 + 1; i++) {
			lookupTable[i] = new int[len2 + 1];
			for (int j = 0; j < len2 + 1; j++) {
				lookupTable[i][j] = 0;
			}

		}
		// if one of the strings is of zero length, Shortest common supersequence(SCS)
		// would be equal to the length of the other string
		for (int i = 0; i < len1 + 1; i++) {
			lookupTable[i][0] = i;
		}
		for (int j = 0; j < len1 + 1; j++) {
			lookupTable[0][j] = j;
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lookupTable[i][j] = 1 + lookupTable[i - 1][j - 1];

					// Use Math.Min to find out shortest common supersequence
				} else {
					lookupTable[i][j] =1+ Math.min(lookupTable[i - 1][j], lookupTable[i][j - 1]);
				}

			}
		}
		return lookupTable[len1][len2];

	}

}
