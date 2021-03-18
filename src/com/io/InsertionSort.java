/*nsertion sort is another very famous sorting algorithm, and it works the way 
 * you would naturally sort items in real life.

It iterates over the given array, figures out what the 
correct position of every element is, and inserts each element in its place.
 * Time Complexity: O(n square) */



package com.io;

public class InsertionSort {

	public static void main(String args[]) {
		int arr[] = { 5, 4, 1, 0, 5, 95, 4, -100, 200, 0 };
		int arrSize = 10;
		insertionSort(arr, arrSize);
		SelSort.printArray(arr, arrSize);
	}

	private static void insertionSort(int[] arr, int arrSize) {
		int ele, j;
		for (int i = 1; i < arrSize; i++) {
			ele = arr[i];
			j = i - 1;
			while (j >= 0 && arr[j] > ele) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = ele;

		}

	}

}
