package dp;

public class CoinChange2 {

	public static int getChange(int i, int amount, int[] coins) {
		int j = i;
		int thisAmount = amount;
		int coinCountTotal = 0;
		int tryCount = 0;
		boolean changeFound = false;
		System.out.println("-- Option -- " + (i + 1));
		while (tryCount <= coins.length) {
			int coin = coins[j];
			if (thisAmount >= coin) {
				int coinCount = thisAmount / coin;
				coinCountTotal = coinCountTotal + coinCount;
				System.out.println(coinCount + " [ " + coin + " cent coin ]");
				thisAmount = thisAmount % coin;
			}
			j++;
			tryCount++;
			if (j == coins.length && tryCount < coins.length) {
				j = 0;
			}
			if (thisAmount == 0) {

				changeFound = true;
				break;
			}
		}
		if (changeFound) {
			System.out.println("Total coin count : " + coinCountTotal + "\n");
		} else {
			System.out.println(" CANNOT FIND COINS \n");
		}

		if (++i < coins.length) {
			return getChange(i, amount, coins);
		} else {
			System.out.println("DONE");
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int amount = 12;
		int[] coins = { 6, 10, 1 };
		System.out.println("Total Amount: " + amount + " cents.");
		getChange(0, amount, coins);

	}

}
