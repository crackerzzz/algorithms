package dp;

import java.util.HashMap;
import java.util.Map;

public class MakingChange {

	public static Map<Integer, Integer> makeChangeGreedyBruteForce(int[] denominations, int change) {
		final Map<Integer, Integer> map = new HashMap<>();
		if (change == 0) {
			map.put(0, 0);
			return map;
		}
		int remaining = change;
		for (int i = denominations.length - 1; i >= 0; i--) {
			if (remaining >= denominations[i]) {
				map.put(denominations[i], remaining / denominations[i]);
				remaining %= denominations[i];
			}
		}
		return map;
	}

	public static Map<Integer, Integer> makeChangeGreedyRecursive(int[] denominations, int change) {
		final Map<Integer, Integer> map = new HashMap<>();
		makeChangeGreedyRecursive(denominations, change, map, denominations.length - 1);
		return map;
	}

	private static void makeChangeGreedyRecursive(int[] denominations, int change, Map<Integer, Integer> map,
			int index) {
		if (index < 0) {
			return;
		}
		int temp = change;
		if (temp > denominations[index]) {
			map.put(denominations[index], temp / denominations[index]);
		}
		makeChangeGreedyRecursive(denominations, temp % denominations[index], map, index - 1);
	}

	public static int makeChangeNonGreedyRecursive(int[] denominations, int change) {
		return makeChangeNonGreedyRecursive(denominations, change, -1, 1);
	}

	private static int makeChangeNonGreedyRecursive(int[] denominations, int change, int current, int depth) {
		int tDepth = depth * 15;
		System.out.println(padLeft(String.format("change=%d, current=%d, depth=%d", change, current, depth), tDepth));
		if (change == 0) {
			System.out.println(padLeft(String.format("return 0, depth=%d", depth), tDepth));
			return 0;
		}
		int minCoins = Integer.MAX_VALUE;
		for (int i = denominations.length - 1; i >= 0; i--) {
			if (change >= denominations[i]) {
				int tMinCoins = makeChangeNonGreedyRecursive(denominations, change - denominations[i], denominations[i],
						depth + 1);
				if (tMinCoins < minCoins) {
					minCoins = tMinCoins;
				}
			}
		}
		System.out.println(padLeft(String.format("return %d, depth=%d", (minCoins + 1), depth), tDepth));
		return minCoins + 1;
	}

	public static int makeChangeDP(int[] denominations, int change) {
		final int[] cache = new int[change + 1];
		for (int i = 0; i < cache.length; i++) {
			cache[i] = -1;
		}
		return makeChangeDP(denominations, change, cache, -1, 1);
	}

	private static int makeChangeDP(int[] denominations, int change, final int[] cache, int current, int depth) {
		if (cache[change] != -1) {
			return cache[change];
		}
		int tDepth = depth * 15;
		System.out.println(padLeft(String.format("change=%d, current=%d, depth=%d", change, current, depth), tDepth));
		if (change == 0) {
			System.out.println(padLeft(String.format("return 0, depth=%d", depth), tDepth));
			return 0;
		}
		int minCoins = Integer.MAX_VALUE;
		for (int i = denominations.length - 1; i >= 0; i--) {
			if (change >= denominations[i]) {
				int tMinCoins = makeChangeDP(denominations, change - denominations[i], cache, denominations[i],
						depth + 1);
				if (tMinCoins < minCoins) {
					minCoins = tMinCoins;
				}
			}
		}
		System.out.println(padLeft(String.format("return %d, depth=%d", (minCoins + 1), depth), tDepth));
		cache[change] = minCoins + 1;
		return cache[change];
	}

	public static String padLeft(String s, int n) {
		return String.format("%" + n + "s", s);
	}

	public static void main(String[] args) {
		final int[] denominations = new int[] { 1, 6, 10 };
		final int change = 12;
		System.out.println(
				"makeChangeGreedyBruteForce for(" + change + ")=" + makeChangeGreedyBruteForce(denominations, change));
		System.out.println(
				"makeChangeGreedyRecursive for(" + change + ")=" + makeChangeGreedyRecursive(denominations, change));
		System.out.println("makeChangeNonGreedyRecursive for(" + change + ")="
				+ makeChangeNonGreedyRecursive(denominations, change));

		System.out.println("makeChangeDP for(" + change + ")=" + makeChangeDP(denominations, change));
	}

}
