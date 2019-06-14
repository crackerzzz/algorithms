package dp;

public class SquareSubmatrix {
	public static int bruteForceNonRecursive(boolean[][] arr) {
		if (arr == null) {
			return 0;
		}
		int rows = arr.length; // 3
		int cols = arr[0].length; // 4
		int maxMatrixSize = (rows > cols) ? cols : rows; // 3
		int size = maxMatrixSize;
		while (size >= 0) {
			if (bruteForceNonRecursiveIsPresent(arr, size)) {
				break;
			}
			size--;
		}
		return size;
	}

	private static boolean bruteForceNonRecursiveIsPresent(boolean[][] arr, int size) {
		for (int r = 0; r <= arr.length - size; r++) {
			for (int c = 0; c <= arr[r].length - size; c++) {
				if (bruteForceNonRecursiveIsPresent(arr, size, r, c)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean bruteForceNonRecursiveIsPresent(boolean[][] arr, int size, int row, int col) {
		for (int r = row; r < row + size; r++) {
			for (int c = col; c < col + size; c++) {
				if (!arr[r][c]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// @formatter:off
		final boolean[][] arr = new boolean[][] { 
			{ false, true, true, true }, 
			{ true, true, true, true },				
			{ false, true, true, true }, 
			};
		// @formatter:on
		System.out.println("Brute force => " + bruteForceNonRecursive(arr));
	}
}
