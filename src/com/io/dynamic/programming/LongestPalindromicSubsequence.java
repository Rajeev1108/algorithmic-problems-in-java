package com.io.dynamic.programming;

public class LongestPalindromicSubsequence {
	
	 public static int LPSLengthRec(String st, int startIndex, int endIndex) {

		    if (startIndex > endIndex)
		      return 0;

		    // every sequence with one element is a palindrome of length 1
		    if (startIndex == endIndex)
		      return 1;

		    // case 1: elements at the beginning and the end are the same
		    if (st.charAt(startIndex) == st.charAt(endIndex))
		      return 2 + LPSLengthRec(st, startIndex + 1, endIndex - 1);

		    // case 2: skip one element either from the beginning or the end
		    int c1 = LPSLengthRec(st, startIndex + 1, endIndex);
		    int c2 = LPSLengthRec(st, startIndex, endIndex - 1);
		    return Math.max(c1, c2);
		  }
	 
	  public static int LPSLength(String st) {
		    return LPSLengthRec(st, 0, st.length() - 1);
		  }
	  
	  
	  public static void main(String args[]) 
	  {
	    System.out.println(LPSLength("cddpd"));
	    System.out.println(LPSLength("abdbca"));
	    System.out.println(LPSLength("cddpd"));
	    System.out.println(LPSLength("pqr"));
	  }

}
