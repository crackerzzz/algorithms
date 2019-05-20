package hackerrank;

public class MinimumBribes {

	public static void main(String[] args) {
		int[] q = new int[] { 1, 2, 5, 3, 4 };
		int bribes = 0;
		for (int i = 0; i < q.length; i++) {
			System.out.println();
			if (q[i] - (i + 1) > 2) {
				System.out.println("Too chaotic");
				return;
			}
			System.out.print(String.format("q[i]: %d, i: %d, q[i]-2: %d, ", q[i], i, q[i] - 2));
			for (int j = Math.max(0, q[i] - 2); j < i; j++) {
				if (q[j] > q[i]) {
					bribes++;
				}
				System.out.print(String.format("j: %d; q[j]: %d, bribes: %d, ", j, q[j], bribes));
			}
		}
		System.out.println("Bribes: " + bribes);
	}

}
