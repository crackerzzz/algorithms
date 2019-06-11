package random;

public class MaxHeap<Key extends Comparable<Key>> {
	private Key[] heap;
	private int size;

	@SuppressWarnings("unchecked")
	public MaxHeap(int capacity) {
		heap = (Key[]) new Comparable[capacity];
		size = 0;
	}

	// insert a key into the priority queue
	public void insert(Key element) {
		if (element == null) {
			throw new IllegalArgumentException();
		}
		heap[size++] = element;
		if (size > 1) {
			swim(size - 1);
		}
	}

	private void swim(int index) {
		int parent;
		do {
			parent = index / 2;
			if (heap[parent].compareTo(heap[index]) < 0) {
				swap(parent, index);
			}
			index = parent;
		} while (parent > 0);
	}

	// return and remove the largest key
	public Key getMax() {
		if (size == 0) {
			throw new IllegalArgumentException();
		}
		Key max = heap[0];
		heap[0] = heap[size - 1];
		// avoid loitering
		heap[size - 1] = null;
		size--;
		if (size > 1) {
			sink(0);
		}
		return max;
	}

	private void swap(int a, int b) {
		Key temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}

	private void sink(int index) {
		while (index < size - 1) {
			int biggerChildIndex;

			int leftChildIndex = 2 * index + 1;
			int rightChildIndex = leftChildIndex + 1;

			// if current node has both left and right child, pick the higher child, else
			// pick left child.
			if (heap[rightChildIndex] != null) {
				biggerChildIndex = heap[leftChildIndex].compareTo(heap[rightChildIndex]) > 0 ? leftChildIndex
						: rightChildIndex;
			} else {
				biggerChildIndex = leftChildIndex;
			}

			if (heap[index].compareTo(heap[biggerChildIndex]) < 0) {
				swap(index, biggerChildIndex);
				index = biggerChildIndex;
			} else {
				break;
			}
		}
	}

	// is the priority queue empty?
	public boolean isEmpty() {
		return size == 0;
	}

	// return the largest key
	public Key max() {
		if (size == 0) {
			throw new IllegalArgumentException();
		}
		return heap[0];
	}

	// int size() number of entries in the priority queue
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
		maxHeap.insert(5);
		maxHeap.insert(8);
		maxHeap.insert(10);
		maxHeap.insert(3);
		maxHeap.insert(7);

		while (!maxHeap.isEmpty()) {
			System.out.println(maxHeap.getMax());
		}

	}
}
