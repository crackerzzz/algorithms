package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps {

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int len = arr.length;
		int swaps = 0;
		boolean[] visited = new boolean[len];
		for (int i = 0; i < len; i++) {
			int j = i;
			int cycle = 0;
			while (!visited[j]) {
				visited[j] = true;
				j = arr[j] - 1;
				cycle++;
			}
			if (cycle != 0) {
				swaps += cycle - 1;
			}
		}
		return swaps;
	}

	// Complete the minimumSwaps function below.
	static int minimumSwaps1(int[] arr) {
		int len = arr.length;
		int outOfPlace = 0;
		final Map<Integer, Integer> map = new HashMap<>(len);

		// find how many are out of place
		for (int i = 0; i < len; i++) {
			if (arr[i] != (i + 1)) {
				if (map.get(arr[i]) != null && map.get(arr[i]) == (i + 1)) {
					continue;
				}
				outOfPlace++;
				// key=index, value=number
				map.put(i + 1, arr[i]);
			}
		}
		int t = map.size() << 1;
		if (t == len || t == len - 1) {
			return outOfPlace;
		} else if (outOfPlace > 0) {
			return outOfPlace - 1;
		} else {
			return 0;
		}
	}

	// first try
	static int minimumSwaps2(int[] arr) {
		int len = arr.length;
		int count = 0;
		for (int i = 0; i < len - 1; i++) {
			int smallestIndex = i;
			if (arr[i] != (i + 1)) {
				for (int j = i + 1; j < len; j++) {
					if (arr[j] < arr[smallestIndex]) {
						smallestIndex = j;
					}
				}
				// avoid swapping if number is already in place
				if (smallestIndex != i) {
					swap(arr, i, smallestIndex);
					count++;
				}
			}
		}
		return count;
	}

	static void swap(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = to;
		arr[to] = temp;
	}

	public static void main(String[] args) {
//		System.out.println(minimumSwaps(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(minimumSwaps(new int[] { 4, 3, 1, 2 }));
//		System.out.println(minimumSwaps(new int[] { 8, 45, 35, 84, 79, 12, 74, 92, 81, 82, 61, 32, 36, 1, 65, 44, 89,
//				40, 28, 20, 97, 90, 22, 87, 48, 26, 56, 18, 49, 71, 23, 34, 59, 54, 14, 16, 19, 76, 83, 95, 31, 30, 69,
//				7, 9, 60, 66, 25, 52, 5, 37, 27, 63, 80, 24, 42, 3, 50, 6, 11, 64, 10, 96, 47, 38, 57, 2, 88, 100, 4,
//				78, 85, 21, 29, 75, 94, 43, 77, 33, 86, 98, 68, 73, 72, 13, 91, 70, 41, 17, 15, 67, 93, 62, 39, 53, 51,
//				55, 58, 99, 46 }));
	}
}
