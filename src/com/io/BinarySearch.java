package com.io;

/*Assuming that the input array is sorted, compare the element that is being 
 * searched for with the element at the middle of the array. If the element being 
 * searched for is greater than the element at the middle of the array, 
 * recursively check for it in the second half of the given array. Otherwise, 
 * search for it in the first half of the given array.
 * Time Complexity: O(log(n))*/

public class BinarySearch {

	public static void main(String args[]) {
		int arr[] = { 5, 4, 1, 410, 5, 95, 4, -100, 20, 0 };
		int arrSize = 10;
		int key = 4000;
		int index = binarySearch(key, arr, arrSize);
		SelSort.printArray(arr, arrSize);
		if (index != -1)
			System.out.println("Your Key \"" + key + "\" is found at index \"" + index + "\"");
		else
			System.out.println("Your Key \"" + key + "\" not found in the array: ");

	}

	private static int binarySearch(int key, int[] arr, int arrSize) {
		int start = 0;
		int mid;
		int end = arrSize - 1;

		while (start < end) {
			mid = (start + end) / 2;

			if (arr[mid] > key) {
				end = mid - 1;
			} else if (arr[mid] < key) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
