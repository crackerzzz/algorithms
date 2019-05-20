package hackerrank;

public class MaxConsecutiveSum {
	public static boolean maxConsecutiveSum(int[] arr, int target) {
		int maxSum = 0;
		int start = 0, current = 0;

		while (current < arr.length) {
			maxSum += arr[current];

			if (maxSum == target) {
				return true;
			} else if (maxSum > target && start < current) {
				maxSum -= arr[start];
				maxSum -= arr[current];
				start++;
			} else {
				current++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		final int[] arr = new int[] { 6, 3, 2, 2, 2, 12 };
		System.out.println("max Consective sum: " + maxConsecutiveSum(arr, 12));
	}
}
