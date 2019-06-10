package random;

import java.util.Arrays;

public class PancakeSorting {
	// k is one based
	public static void flip(int[] arr, int k) {
		for (int i = 0; i < k / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[k - i - 1];
			arr[k - i - 1] = temp;
		}
	}

	public static void pancakeSort(int[] arr) {
		final int n = arr.length;
		for (int i = n; i >= 0; i--) {
			int maxIndex = findMaxElementIndex(arr, i);
			if (maxIndex != i) {
				flip(arr, maxIndex + 1);
				flip(arr, i);
			}
		}
	}

	private static int findMaxElementIndex(int[] arr, final int n) {
		int maxIndex = 0;
		for (int j = 0; j < n; j++) {
			if (arr[j] > arr[maxIndex]) {
				maxIndex = j;
			}
		}
		return maxIndex;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 8, 4, 3, 7, 2, 9, 5 };
		pancakeSort(arr);
		System.out.println("Pancake sorted: " + Arrays.toString(arr));
	}
}
