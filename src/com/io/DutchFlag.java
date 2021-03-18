package com.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class DutchFlag {

	public static void main(String[] args) {
		int[] arr = { 2, 0, 0, 1, 2, 1, 0, 0, 1, 1, 1, 1, 0, 2 };
		Object[] outputArr = callDutchFalg(arr);
		System.out.println("the Dutch Flag-->" + Arrays.toString(outputArr));
	}

//Brute force way
	private static Object[] callDutchFalg(int[] arr) {

		List<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> hmap = new HashMap();
		int counter = 1;

		for (int i = 0; i < arr.length - 1; i++) {
			if (hmap.containsKey(arr[i])) {
				counter = hmap.get(arr[i]);
				hmap.put(arr[i], counter + 1);
			} else {
				hmap.put(arr[i], counter);
			}

		}

		for (Entry<Integer, Integer> entrySet : hmap.entrySet()) {

			for (int i = 0; i <= entrySet.getValue(); i++) {
				list.add(entrySet.getKey());
			}

		}

		return list.toArray();
	}

	// Smart Way - three way partitioning
	/*In this solution, there are three possible values of the element at the mid; 0, 1, 
	 * or 2. If the value at the mid index is equal to 0, swap this value with the leftmost 
	 * value and increment both the indexes . If the value at the mid index is 
	 * equal to 2, swap this value with the rightmost index and decrement the rightmost index 
	 * If the value at the mid index is equal to 1, simply increment the mid index 
	 * */
	public static void dutchNationalFlag(int[] arr) {
		int i = 0;
		int mid = 0;
		int j = arr.length - 1;

		while (mid <= j) {
			// if value at mid equals to zero
			if (arr[mid] == 0)
				mySwap(arr, i++, mid++);
			// if value at mid equals to two
			else if (arr[mid] == 2)
				mySwap(arr, mid, j--);
			// if value at mid equals to one
			else if (arr[mid] == 1)
				mid++;
		}
	}

	static void mySwap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
