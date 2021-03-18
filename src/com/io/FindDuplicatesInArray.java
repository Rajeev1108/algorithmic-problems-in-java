package com.io;

import java.util.ArrayList;
import java.util.HashMap;



public class FindDuplicatesInArray {
	
	
	public static void main(String[] args) {
		int arr[] = { 7, 5, 4, 3, 11, 5, 11, 9, 3, 11 };
		ArrayList<Integer> arrlist = findDuplicates(arr);
		System.out.println(arrlist.toString());
	}

	public static ArrayList<Integer> findDuplicates(int[] arr) {
		int counter = 0;
		HashMap<Integer, Integer> hmap = new HashMap();
		for (int i = 0; i < arr.length; i++) {

			if (hmap.containsKey(arr[i])) {
				counter = hmap.get(arr[i]);
				hmap.put(arr[i], counter+1);
			} else {
				hmap.put(arr[i], counter);
			}

		}

		ArrayList<Integer> lt = new ArrayList<Integer>();
		for (Integer s : hmap.keySet()) {
			Integer num = hmap.get(s);
			if (num > 0) {
				lt.add(s);
			}

		}

		return lt;

	}

}
