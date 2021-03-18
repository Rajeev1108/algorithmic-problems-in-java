package com.io;

public class SearchRotatedArray {
	
	public static void main(String args[]) 
	  {
	    int arr[] = {40,100,-100,40,0,24,40};
	    System.out.println( "The index is: " + searchRotatedArray(arr, 0, 6, -100));
	  }

	private static int searchRotatedArray(int[] arr, int left, int right, int inputNum) {
		int mid = (left+right)/2;
		
		if(inputNum==arr[mid]) {
			return mid;
		}
		if(right<left) {
			return -1;
		}
		
		if (arr[left] < arr[mid]) {

			if (inputNum >= arr[left] && inputNum < arr[mid]) {
				return searchRotatedArray(arr, left, mid - 1, inputNum);
			} else {
				return searchRotatedArray(arr, mid + 1, right, inputNum);
			}

		} else if (arr[mid] < arr[right]) {

			if (inputNum <= arr[right] && inputNum > arr[mid]) {
				return searchRotatedArray(arr, mid + 1, right, inputNum);
			} else {
				return searchRotatedArray(arr, left, mid - 1, inputNum);
			}

		} else if (arr[left] == arr[mid]) {

			if (arr[mid] != arr[right]) // If the right element is not a repeat
				return searchRotatedArray(arr, mid + 1, right, inputNum); // search in the right half
			else { // Otherwise, search both halves

				int result = searchRotatedArray(arr, left, mid - 1, inputNum); // Search in left
				if (result == -1)
					return searchRotatedArray(arr, mid + 1, right, inputNum); // Search in right
				else
					return result;
			}

		}
		

		return -1;
	}

}
