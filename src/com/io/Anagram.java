package com.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Anagram {

	// Anagram by brute force way -time complexity : O(n2k2)
	public static ArrayList<String> groupAnagramsBruteForce(String arr[]) {

		ArrayList<String> output = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j)
					break;
				if (arr[i].length() == arr[j].length()) {
					// If a character of str1 not in c2

					for (int c1 = 0; c1 < arr[i].length(); c1++) {
						for (int c2 = 0; c2 < arr[j].length(); c2++) {

							if (arr[i].charAt(c1) == arr[j].charAt(c2))
								count += 1;
						}
					}

					if (count == arr[j].length()) {
						output.add(arr[j]);
						output.add(arr[i]);
					}
					count = 0;
				}
			}
		}
		return output;
	}

	public static void main(String args[]) {
		String arr[] = { "tom marvolo riddle ", "abc", "def", "cab", "fed", "clint eastwood ", "i am lord voldemort",
				"elvis", "old west action", "lives" };
		// ArrayList<String> vec = groupAnagramsBruteForce(arr);
		groupAnagramsUsingHashingAndMap(arr);
		System.out.println(groupAnagramsUsingHashingAndMap(arr));
	}

	private static String groupAnagramsUsingHashingAndMap(String[] arr) {

		HashMap<String, List<String>> hmap = new HashMap();

		for (int i = 0; i < arr.length; i++) {

			String actualItem = arr[i];
			char[] letters = actualItem.toCharArray();
			Arrays.sort(letters);
			String newWord = new String(letters);

			if (hmap.containsKey(newWord)) {
				hmap.get(newWord).add(actualItem);
			} else {
				List<String> strList = new ArrayList<String>();
				strList.add(actualItem);
				hmap.put(newWord, strList);

			}
		}

		String temp = "";
		for (String s : hmap.keySet()) {

			List<String> listToPrint = hmap.get(s);
			if (listToPrint.size() > 1) {
				temp = temp + listToPrint;
			}
		}
		return temp;
	}
}