/*It works by comparing adjacent pairs of elements and swapping them if they 
 * are in the wrong order. This is repeated until the array is sorted.

Think of it this way: a bubble passes over the array and “catches” 
the maximum/minimum element and brings it over to the right side.

time complexity:  O(n square) 

*/

package com.io;

public class BubbleSort {
	
	
	 public static void main(String args[]) {
		  int arr[] = {5,4,1,0,5,95,4,-100,200,0};
		  int arrSize = 10;
		  bubbleSort(arr, arrSize);
		  SelSort.printArray(arr, arrSize);
		 }

	private static void bubbleSort(int[] arr, int arrSize) {
		int temp;
		for (int i =0; i<arrSize-1; i++) {
			
			for(int j=0;j<arrSize-i-1; j++) {
				
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
	}

}
