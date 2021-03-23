package com.io.dynamic.programming;


public class StringsInterleavingTabulation {

	public static void main(String[] args) {
		  System.out.println(findSITopDown("abd", "cef", "adcbef"));
		  System.out.println(findSITopDown("abc", "def", "abdccf"));
		  System.out.println(findSITopDown("abcdef", "mnop", "mnaobcdepf"));

	}

	public static boolean findSITopDown(String m, String n, String p) {

		boolean[][] lookupTable = new boolean[m.length() + 1][];

		for (int i = 0; i < m.length() + 1; i++)
			lookupTable[i] = new boolean[n.length() + 1];

		if (m.length() + n.length() != p.length())
			return false;

		for (int mindex = 0; mindex <= m.length(); mindex++) {
			for (int nindex = 0; nindex <= n.length(); nindex++) {
				// If both m and n are empty then p must be empty
				if (mindex == 0 && nindex == 0)
					lookupTable[mindex][nindex] = true;
					
				// if m is empty
				else if (mindex == 0 && n.charAt(nindex - 1) == p.charAt(mindex + nindex - 1)) {
					lookupTable[mindex][nindex] = lookupTable[mindex][nindex - 1];
				}
				// if n is empty
				else if (nindex == 0 && m.charAt(mindex - 1) == p.charAt(mindex + nindex - 1)) {
					lookupTable[mindex][nindex] = lookupTable[mindex - 1][nindex];
				} else {
					// if letter of m matches with letter of p
					if (mindex > 0 && m.charAt(mindex - 1) == p.charAt(mindex + nindex - 1)) {
						lookupTable[mindex][nindex] = lookupTable[mindex - 1][nindex];
					}
					//if letter of n matches with letter of p
					if (nindex > 0 && n.charAt(nindex - 1) == p.charAt(mindex + nindex - 1)) {
						lookupTable[mindex][nindex] |= lookupTable[mindex][nindex - 1];
					}
				}

			}
		}

		return lookupTable[m.length()][n.length()];
	}

}
