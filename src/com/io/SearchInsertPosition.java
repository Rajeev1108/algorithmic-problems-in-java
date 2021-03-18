package com.io;

public class SearchInsertPosition {

	public static int insertPosition(int arr[], int target) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0, pos = 0;

		if (arr.length < 1)
			return -1;

		while (start <= end) {
			mid = (start+end)/2;
			if (target == arr[mid]) {
				return mid;
			} else if (arr[mid] < target) {
				start = mid + 1;
				pos = mid + 1;
			} else {
				end = mid - 1;
				pos = mid;
			}

		}

		return pos;

	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 6 };
		// Example 1
		System.out.println("Index to Insert " + "\"5\" is " + insertPosition(arr, 5));

		// Example 2
		System.out.println("Index to Insert " + "\"3\" is " + insertPosition(arr, 3));

		// Example 3
		System.out.println("Index to Insert " + "\"7\" is " + insertPosition(arr, -100));

	}

}
