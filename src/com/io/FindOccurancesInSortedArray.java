package com.io;


public class FindOccurancesInSortedArray {

	public static void main(String[] args) {
		int arr[] = { -5, -3, 0, 1, 3, 3, 3, 3, 4, 5 };
		int key = 0;
		System.out.println("The key \"" + key + "\" occurs " + calcFreq(arr, key) + " times in the Array.");

	}

	/*Slightly modified version of binary search was used here to identify occurrences of a given key
	* on of occurrences =  index of last occurrence - index of first occurrence +1 
	* result1 and result2 were found out by two separate binary searches with only difference being one searching
	* in left and other in right if the element was found to be the mid element*/
	private static int calcFreq(int[] arr, int findThis) {

		int low = 0;
		int high = arr.length - 1;

		int result1 = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (findThis == arr[mid]) {
				result1 = mid;
				high = mid-1;
			} else if (findThis < arr[mid]) {
				high = mid - 1;
			} else if (findThis > arr[mid]) {
				low = mid + 1;
			}

		}

		int start1 = 0, end1 = arr.length - 1, mid1, result2 = -1;
		while (start1 <= end1) {
			mid1 = (start1 + end1) / 2;
			if (arr[mid1] == findThis) {
				result2 = mid1;
				start1 = mid1 + 1;
			} else if (arr[mid1] > findThis) {
				end1 = mid1 - 1;
			} else if (arr[mid1] < findThis) {
				start1 = mid1 + 1;
			}
		}

		if (result1 == -1 || result2 == -1) {
			return (result2 - result1);

		} else {
			return (result2 - result1 + 1);
		}
	}

}
