package com.io.greedy;

import java.util.ArrayList;

public class ChangeMachine {

	public static int[] coins = { 25, 10, 5, 1 };

	public static void main(String[] args) {

		System.out.println(1 + " --> " + getMinCoins(1));
		System.out.println(17 + " --> " + getMinCoins(17));
		System.out.println(33 + " --> " + getMinCoins(33));
		System.out.println(99 + " --> " + getMinCoins(99)); 

	}

	// function to receive change in the form of coins
	public static ArrayList<Integer> getMinCoins(int amount) {
		ArrayList<Integer> change = new ArrayList<Integer>();

		for (int i = 0; i < coins.length && amount > 0; i++) {

			while (amount >= coins[i]) {
				amount -= coins[i];
				change.add(coins[i]);

			}

		}

		return change;
	}
}
