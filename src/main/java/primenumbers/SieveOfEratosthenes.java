package primenumbers;

public class SieveOfEratosthenes {

	public static void sieve(int n) {
		boolean[] primes = new boolean[n + 1];

		// initial two array places will be ignored, others are marked as prime.
		for (int i = 2; i <= n; i++) {
			primes[i] = true;
		}

		for (int p = 2; p * p <= n; p++) {
			// only check if number is still marked as prime
			if (primes[p]) {
				// starting from square of the number, mark all places as not prime
				for (int i = p * p; i <= n; i += p) {
					primes[i] = false;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			if (primes[i]) {
				System.out.println(i + " ");
			}
		}
	}

	public static void main(String[] args) {
		sieve(315);
	}
}
