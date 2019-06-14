package hackerrank;

public class StackWithMin {
	private int[] array;
	private int[] minArray;
	private int count;

	public StackWithMin() {
		array = new int[100];
		minArray = new int[100];
		count = 0;
	}

	public void push(int item) {
		if (count == 0) {
			array[count] = item;
			minArray[count] = item;
			count++;
		} else {
			if (!isDuplicate(item)) {
				array[count] = item;
				minArray[count] = item < minArray[count - 1] ? item : minArray[count - 1];
				count++;
			}
		}
	}

	private boolean isDuplicate(int item) {
		for (int i = 0; i < count; i++) {
			if (array[i] == item) {
				return true;
			}
		}
		return false;
	}

	public int pop() {
		if (count == 0) {
			return -1;
		}
		return array[--count];
	}

	public int getMin() {
		if (count == 0) {
			return -1;
		}
		return minArray[count - 1];
	}

	public static void main(String[] args) {
		StackWithMin s = new StackWithMin();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.getMin());
		s.push(5);
		System.out.println(s.getMin());
	}

}
