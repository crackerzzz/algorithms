package dp;

import java.util.Arrays;

public class Knapsack01 {
	public static int knapsack(int[][] items, int weight) {
		int[] cache = new int[weight + 1];
		Arrays.fill(cache, -1);
		return knapsack(items, weight, cache, 0);
	}

	public static int knapsack(int[][] items, int weight, int[] cache, int i) {
		if (i == items.length) {
			return 0;
		}
		if (cache[weight] != -1) {
			return cache[weight];
		}
		// if current item is heavier, skip to next item
		if (weight - items[i][0] < 0) {
			return knapsack(items, weight, cache, i + 1);
		} else {
			// find max of including and excluding current.
			cache[weight] = Math.max(knapsack(items, weight - items[i][0], cache, i + 1) + items[i][1],
					knapsack(items, weight, cache, i + 1));
			return cache[weight];
		}
	}

	public static void main(String[] args) {
		int[][] items = new int[][] { { 2, 6 }, { 2, 10 }, { 3, 12 } };
		int weight = 5;
		System.out.println("knapsack: " + knapsack(items, weight));
	}

}
