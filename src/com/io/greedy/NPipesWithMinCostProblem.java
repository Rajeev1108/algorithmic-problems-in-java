package com.io.greedy;

import java.util.Arrays;

public class NPipesWithMinCostProblem {

	public static void main(String[] args) {
		int[] pipes = { 4, 3, 2, 6 };
		System.out.println("Total cost for connecting pipes is " + minCost(pipes));
		int[] pipes1 = { 1, 1, 2, 6 };
		System.out.println("Total cost for connecting pipes1 is " + minCostByMinHeap(pipes1,pipes1.length));
	}

	private static int minCostByMinHeap(int[] pipes1, int length) {

		int cost = 0;
		int firstmin, secondmin;

		MinHeap minHeap = new MinHeap(pipes1, length);

		while (!minHeap.SizeIsOne()) {

			firstmin = minHeap.extractMin();
			secondmin = minHeap.extractMin();
			cost += (firstmin + secondmin);
			minHeap.insertKey(firstmin + secondmin);

		}

		return cost;
	}
	//Brute force way or by sorting technique
	private static int minCost(int[] pipes) {

		int cost = 0;
		int len = pipes.length;
		Arrays.sort(pipes);
		for (int i = 0; i < len - 1; i++) {
			int prev_cost = cost;
			cost = pipes[i] + pipes[i + 1];
			pipes[i + 1] = cost;
			cost = cost + prev_cost;
		}
		return cost;
	}
	
	

}
