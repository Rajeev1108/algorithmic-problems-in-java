package com.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class CheckSum {
		
		public static int[] twoSum(int[] nums, int target) {
			int[] result = new int[2];
			HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

			for (int i = 0; i < nums.length; i++) {
				hmap.put(nums[i], i);
			}
			for (int i = 0; i < nums.length; i++) {
				 int complement = target - nums[i];
				if (hmap.containsKey(complement) && hmap.get(complement) != i) {
					result[0] = i;
					result[1] = hmap.get(complement);
					return result;
				}
			}
			return result;
		}

	public static void main(String args[]) {

		int n =6;
		int[] arr1 = { 3,2,4 };
		int[] arr2 = twoSum(arr1, n);

		
		System.out.println("sum is:"+ arr2[0]+" and "+arr2[1]);
	}
}
