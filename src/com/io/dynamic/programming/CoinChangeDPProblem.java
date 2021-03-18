package com.io.dynamic.programming;

public class CoinChangeDPProblem {

	public static void main(String[] args) {

		int amount = 10;
		int[] denoms = { 25, 10, 5, 1 };
		System.out.println(coinChangeDPSOlution(denoms, 4, amount));
	 }


	 public static int coinChangeDPSOlution(int[] denoms, int denomsLength, int amount) {
		  // If n is 0 then there is 1 solution  
		  // (do not include any coin) 
		  if (amount == 0)
		   return 1;

		  // If n is less than 0 then no  
		  // solution exists 
		  if (amount < 0 || denomsLength <= 0)
		   return 0;

		  // If there are no coins and n  
		  // is greater than 0, then no 
		  // solution exist 
		  if (denomsLength <= 0 && amount >= 1)
		   return 0;

		  // count is sum of solutions (i)  
		  // including S[m-1] (ii) excluding S[m-1] 
		  return coinChangeDPSOlution(denoms, denomsLength - 1, amount) + coinChangeDPSOlution(denoms, denomsLength, amount - denoms[denomsLength - 1]);
		 }

}
