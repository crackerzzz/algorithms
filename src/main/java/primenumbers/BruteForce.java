package primenumbers;

public class BruteForce {

	public static void findPrimeFactors(int n) {
		if (n <= 1) {
			return;
		}

		int temp = n;

		// find 2 factors
		while (n % 2 == 0) {
			temp = temp / 2;
			System.out.print("2 ");
		}

		for (int i = 3; i <= Math.sqrt(temp); i += 2) {
			while (temp % i == 0) {
				temp = temp / i;
				System.out.print(i + " ");
			}
		}

		// handle care when temp contains prime number
		if (temp > 2) {
			System.out.print(temp);
		}
	}

	public static void main(String[] args) {
		findPrimeFactors(315);
	}
}
