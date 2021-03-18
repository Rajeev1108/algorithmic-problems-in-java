package com.io;

//Find Two Numbers that Add up to "n" --> Brute force way

public class Problem1 {

	public static void main(String[] args) {
		
		int[] inputarr = {1,21,3,14,5,60,7,6};
		int value = 81;
		int[] resultarr = findSum(inputarr, value);
		  int num1 = resultarr[0];
		  int num2 = resultarr[1];

		  if ((num1 + num2) != value)
		   System.out.println("Results not found!");
		  else
		   System.out.println("Sum of " + value + " found: " + num1 + " and " + num2);

	}
	
	public static int[] findSum(int[] inputArr, int sum) {
		int[] resultArr = new int[2];
		for (int i=0; i< inputArr.length-1; i++) {
			for(int j=i+1; i< inputArr.length-1; i++) {
			
			if(sum==(inputArr[i]+inputArr[j])) {
				resultArr[0] = inputArr[i];
				resultArr[1] = inputArr[j];
				return resultArr;
			}
			}
		}
		
		return null;
		
		
	}

}
