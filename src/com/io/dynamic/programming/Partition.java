package com.io.dynamic.programming;

import java.util.Arrays;

class Partition
{ 
  public static boolean canPartitionRecursive(int num[], int sum, int currentIndex) 
  {
    int numLength = num.length;
    // base check
    if (sum == 0)
      return true;

    if (numLength == 0 || currentIndex >= numLength)
      return false;

    // recursive call after choosing the number at the currentIndex
    // if the number at currentIndex exceeds the sum, we shouldn't process this
    if (num[currentIndex] <= sum) {
      if (canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1))
        return true;
    }

    // recursive call after excluding the number at the currentIndex
    return canPartitionRecursive(num, sum, currentIndex + 1);
  }

  public static Object canPartition(int num[]) 
  {
    int numLength = num.length;
    int sum = 0;
    for (int i = 0; i < numLength; i++)
      sum += num[i];
    // if 'sum' is an odd number, we can't have two subsets with equal sum
    System.out.println(sum);
    if (sum % 2 != 0)
      return false;

    return canPartitionRecursive(num, sum / 2, 0);
  }
  public static void main(String args[]) 
  {
    int set1[] = {1, 2, 3, 4,5,7,7};
    System.out.println(Arrays.toString(set1) + "\t--->\t" + canPartition(set1));
    /*int set2[] = {1, 1, 3, 4, 7};
    System.out.println(Arrays.toString(set2) + "\t--->\t" + canPartition(set2));
    int set3[] = {2, 3, 4, 6};
    System.out.println(Arrays.toString(set3) + "\t--->\t" + canPartition(set3));*/
  }
};
