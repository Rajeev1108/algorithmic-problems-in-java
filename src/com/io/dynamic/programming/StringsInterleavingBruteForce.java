package com.io.dynamic.programming;

public class StringsInterleavingBruteForce {

	public static void main(String[] args) {
		  System.out.println(checkInterLeaving("abd", "cef", "adcbef"));
		  System.out.println(checkInterLeaving("abc", "def", "abdccf"));
		  System.out.println(checkInterLeaving("abcdef", "mnop", "mnaobcdepf"));

	}

	private static Object checkInterLeaving(String m, String n, String p) {

		 return findSIRecursive(m, n, p, 0, 0, 0);

	}

	public static boolean findSIRecursive(String m, String n, String p, int mIndex, int nIndex, int pIndex) {

		if (mIndex == m.length() && nIndex == n.length() && pIndex == p.length())
			return true;

		if (pIndex == p.length())
			return false;

		boolean b1 = false;
		boolean b2 = false;

		if (mIndex < m.length() && (m.charAt(mIndex) == p.charAt(pIndex)))
			b1 = findSIRecursive(m, n, p, mIndex + 1, nIndex, pIndex + 1);

		if (nIndex < n.length() && (n.charAt(nIndex) == p.charAt(pIndex)))
			b1 = findSIRecursive(m, n, p, mIndex, nIndex + 1, pIndex + 1);

		return b1 || b2;
	}

}
