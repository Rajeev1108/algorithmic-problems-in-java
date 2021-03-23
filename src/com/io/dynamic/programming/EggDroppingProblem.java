package com.io.dynamic.programming;

public class EggDroppingProblem {

	public static void main(String[] args) {
		int eggs = 2, floors = 10;
		System.out.println("With " + eggs + " eggs and " + floors + " "
				+ "floors, the minimum number of trials in worst are: " + eggDropBruteForce(eggs, floors));

		System.out.println("With " + eggs + " eggs and " + floors + " "
				+ "floors, the minimum number of trials in worst are: " + eggDropTopDown(eggs, floors));
	}

	private static int eggDropBruteForce(int eggs, int floors) {

		if (eggs == 0 || floors == 0) {
			return 0;
		}

		if (eggs == 1) {
			return floors;
		}

		if (floors == 0 || floors == 1) {
			return floors;
		}

		int min = Integer.MAX_VALUE;
		int x, res;

		for (x = 1; x < floors; x++) {
			res = Math.max(eggDropBruteForce(eggs - 1, floors - 1), eggDropBruteForce(eggs, floors + 1));
			if (res < min) {
				min = res;
			}

		}

		return min + 1;
	}
	
	
	private static int eggDropTopDown(int eggs, int floors) {
		// If there are no eggs, then there can't be any tries
		if (eggs == 0 || floors == 0) {
			return 0;
		}

		// We need k trials for one egg and k floors 
		if (eggs == 1) {
			return floors;
		}

		 // If there are no floors, then no trials needed. OR if there is 
	    // one floor, one trial needed.
		if (floors == 0 || floors == 1) {
			return floors;
		}

		int[][] eggfloor = new int[eggs+1][floors+1];
		int i,j,x,res;
		
		
	    // We need one trial for one floor and zero trials for zero floors 
		for (i = 1; i <= eggs; i++) {
			eggfloor[i][1] = 1;
			eggfloor[i][0] = 0;
		}

	    // We always need j trials for one egg and j floors. 
	    for (j = 1; j <= floors; j++)
	    	eggfloor[1][j] = j;
	    
	    for (i = 2; i <= eggs; i++) {
	        for (j = 2; j <= floors; j++) {
	          eggfloor[i][j] = Integer.MAX_VALUE;
	          for (x = 1; x <= j; x++) {
	            res = 1 + Math.max(eggfloor[i - 1][x - 1], eggfloor[i][j - x]);
	            if (res < eggfloor[i][j])
	            	eggfloor[i][j] = res;
	          }
	        }
	      }
	    return eggfloor[eggs][floors];
	}

}
