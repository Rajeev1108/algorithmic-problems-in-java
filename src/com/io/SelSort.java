/* Idea of the selection sort is to consider to part of the given array, one part 
 * which starts from left to right is the unsorted one(blank in first iteration) and 
 * second half to be sorted one find the minimum element in sorted part and keep putting 
 * them in unsorted side until all the elements are sorted 
 * Time Complexity: O(n square)*/


package com.io;

public class SelSort {

	public static void main(String args[]) {
		int arr[] = { 5, 4, 1, 0, 5, 95, 4, -100, 200, 0 };
		int arrSize = 10;
		selectionSort(arr, arrSize);
		printArray(arr, arrSize);

	}

	private static void selectionSort(int[] arr, int arrSize) {
		int minIndex;

		for (int i = 0; i < arrSize; i++) {
			minIndex = findMinIndex(arr, i, arrSize-1);
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;

		}

	}

	private static int findMinIndex(int[] arr, int start, int end) {
		if (start < 0 || end <= 0) {
			return 0;
		}

		int minInd = start;
		for (int i = start + 1; i <= end; i++) {
			if (arr[minInd] > arr[i]) {
				minInd = i;
			}
		}

		return minInd;
	}

	static void printArray(int[] arr, int arrSize) {
		for (int i = 0; i < arrSize; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
