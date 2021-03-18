package com.io;

import java.util.Random;

/*Start with an array of n elements.
*Choose a pivot element from the array to be sorted.
*Partition the array into two unsorted subarrays, such that all elements in 
*one subarray are less than the pivot and all the elements in the other subarray are greater than the pivot.
*Elements that are equal to the pivot can go in either subarray.
*Sort each subarray recursively to yield two sorted subarrays.
*Concatenate the two sorted subarrays and the pivot to yield one sorted array.*/

class QuickSort {
	public static int choosePivot(int left, int right) {
		Random rand = new Random();
		// Pick 3 random numbers within the range of the array
		int i1 = left + (rand.nextInt(right - left + 1));
		int i2 = left + (rand.nextInt(right - left + 1));
		int i3 = left + (rand.nextInt(right - left + 1));

		// Return their median
		return Math.max(Math.min(i1, i2), Math.min(Math.max(i1, i2), i3));
	}

	public static int partition(int arr[], int left, int right) {
		int pivotInd = choosePivot(left, right); // Index of pivot
		swap(arr, right, pivotInd); // self created function to swap two indices of an array
		int pivot = arr[right]; // Pivot
		int i = (left - 1); // All the elements less than or equal to the
		// pivot go before or at i

		for (int j = left; j <= right - 1; j++) {
			if (arr[j] <= pivot) {
				i++; // increment the index
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, right); // Putting the pivot back in place
		return (i + 1);
	}

	public static void quickSort(int arr[], int left, int right) {
		if (left < right) {
			// pi is where the pivot is at
			int pi = partition(arr, left, right);

			// Separately sort elements before and after partition
			quickSort(arr, left, pi - 1);
			quickSort(arr, pi + 1, right);
		}
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String args[]) {
		int arr[] = { 5, 4, 1, 0, 5, 95, 4, -100, 200, 0 };
		int arrSize = 10;
		quickSort(arr, 0, arrSize - 1);
		System.out.print("Sorted array: ");
		SelSort.printArray(arr, arrSize);
	}
}
