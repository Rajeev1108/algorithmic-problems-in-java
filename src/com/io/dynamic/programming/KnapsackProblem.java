package com.io.dynamic.programming;

class KnapsackProblem
{ 
  // Returns the maximum value that can be put in a knapsack of capacity W 
  // This is brute force appraoch
  public static int knapSack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity, int currentIndex) {
    // Base Case 
    if (capacity <= 0 || currentIndex >= profitsLength || currentIndex < 0 || weightsLength != profitsLength)
      return 0;

    // If weight of the nth item is more than Knapsack capacity W, then 
    // this item cannot be included in the optimal solution
    int profit1 = 0;
    if (weights[currentIndex] <= capacity)
      profit1 = profits[currentIndex] + knapSack(profits, profitsLength, weights, weightsLength, capacity - weights[currentIndex], currentIndex + 1);

    int profit2 = knapSack(profits, profitsLength, weights, weightsLength,  capacity, currentIndex + 1);

    // Return the maximum of two cases:  
    return Math.max(profit1, profit2);
  }

  // Driver program to test above function 
  public static void main(String args[]) 
  {
    int profits[] = {1, 6, 10, 16}; // The values of the jewelry
    int weights[] = {1, 2, 3, 5}; // The weight of each
    System.out.println("Total knapsack profit ---> " + knapSack(profits, 4, weights, 4,  7, 0));
    System.out.println("Total knapsack profit ---> " + knapSack(profits, 4, weights, 4, 6, 0));
    System.out.println("Total knapsack profit ---> " + knapSackEnhancedTabular(profits, 4, weights, 4, 6));
  }

private static int knapSackEnhancedTabular(int profits[], int profitsLength, int weights[], int weightsLength, int capacity) {
	  if (capacity <= 0 || profitsLength == 0 || weightsLength != profitsLength)
		   return 0;

		  int[] lookupTable = new int[capacity + 1];

		  // if we have only one weight, we will take it if it is not more than the capacity
		  for (int c = 0; c <= capacity; c++) {
		   if (weights[0] <= c)
		    lookupTable[c] = profits[0];
		  }
		  // process all sub-arrays for all the capacities
		  for (int i = 1; i < profitsLength; i++) {
		   for (int c = capacity; c >= 0; c--) {
		    int profit1 = 0, profit2 = 0;
		    // include the item, if it is not more than the capacity
		    if (weights[i] <= c)
		     profit1 = profits[i] + lookupTable[c - weights[i]];
		    // exclude the item
		    profit2 = lookupTable[c];
		    // take maximum
		    lookupTable[c] = Math.max(profit1, profit2);
		   }
		  }
		  return lookupTable[capacity];
}
  

};
