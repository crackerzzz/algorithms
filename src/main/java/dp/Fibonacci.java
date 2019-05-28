package dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	public static int topDownFib(int n) {
		if (n <= 1) {
			return n;
		}
		final Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 1);
		return topDownFib(n, map);
	}

	private static int topDownFib(int n, final Map<Integer, Integer> map) {
		if (map.containsKey(n)) {
			return map.get(n);
		}

		int sum = topDownFib(n - 1, map) + topDownFib(n - 2, map);
		map.put(n, sum);
		return sum;
	}

	private static int bottomUp(int n) {
		if (n <= 1) {
			return n;
		}
		int x = 0, y = 1;
		for (int i = 1; i < n; i++) {
			int t = x + y;
			x = y;
			y = t;
		}
		return y;
	}

	public static void main(String[] args) {
		int n = 300;
		System.out.println("fib(" + n + ") = " + bottomUp(n));
	}
}
