package com.io.greedy;

public class MinimumNumberOfPlatforms {

	public static void main(String[] args) {
		  //Example 1
	    int arrival[] = {900, 940, 950, 1100, 1500, 1800};
	    int departure[] = {910, 1200, 1120, 1130, 1900, 2000};
	    int answer  = findPlatform(arrival, departure);
	    System.out.println("Minimum Number of Platforms Required for Plan1 = " + answer);

	}

	private static int findPlatform(int[] arrival, int[] departure) {
	int n = arrival.length;
	int result = 0;
	int count =0;
		
		for(int i =0; i<n;i++ ) {
			count =0;
			for(int j=1; j<n;j++) {
				if(arrival[i]<=arrival[j] && departure[i]>=arrival[j]) {
					count++;
				}
			}
			if(result<count) 
				result=count;
		}
		return result;
	}

}
