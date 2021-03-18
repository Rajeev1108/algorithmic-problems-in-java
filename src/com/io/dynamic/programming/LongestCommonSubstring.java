package com.io.dynamic.programming;

import jdk.dynalink.linker.support.Lookup;

class LongestCommonSubstring {
	public static int longestCommonSubstrLengthRec(String s1, String s2, int i1, int i2, int count) {
		if (i1 == s1.length() || i2 == s2.length())
			return count;

		if (s1.charAt(i1) == s2.charAt(i2))
			count = longestCommonSubstrLengthRec(s1, s2, i1 + 1, i2 + 1, count + 1);

		int c1 = longestCommonSubstrLengthRec(s1, s2, i1, i2 + 1, 0);
		int c2 = longestCommonSubstrLengthRec(s1, s2, i1 + 1, i2, 0);

		return Math.max(count, Math.max(c1, c2));
	}

	public static int longestCommonSubstrLength(String s1, String s2) {
		return longestCommonSubstrLengthRec(s1, s2, 0, 0, 0);
	}

	public static void main(String args[]) {
		String s1 = "0abc321";
		String s2 = "123abcdef";
		String s3 = "educative.io/expl";
		String s4 = "educative.io/edpr";
		//System.out.println(longestCommonSubstrLength(s1, s2));
		System.out.println(longestCommonSubstrLengthDP(s1, s2));
	}

	private static int longestCommonSubstrLengthDP(String s1, String s2) {

		int[][] lookupTable = new int[s1.length() + 1][];
		for (int i = 0; i <= s1.length(); i++) {
			lookupTable[i] = new int[s2.length() + 1];
		}
		for (int i = 0; i < s1.length() + 1; i++) {
			for (int j = 0; j < s2.length() + 1; j++) {
				lookupTable[i][j] = 0;
			}
		}
		int maxlen = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lookupTable[i][j] = 1 + lookupTable[i - 1][j - 1];
					maxlen = Math.max(maxlen, lookupTable[i][j]);
				}
			}
		}
		return maxlen;
	}
	
}
