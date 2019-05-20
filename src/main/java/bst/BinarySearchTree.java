package bst;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node root;

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null) {
			return new Node(key, value);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, value);
		} else if (cmp > 0) {
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}
		return x;
	}

	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			// search key is less than current node key, traverse left
			if (cmp < 0) {
				x = x.left;
			}
			// search key is greater than current node key, traverse right
			else if (cmp > 0) {
				x = x.right;
			} else {
				return x.value;
			}
		}
		return null;
	}

	public void delete(Key key) {

	}

	public Iterable<Key> iterator() {
		return null;
	}

	private class Node {
		private Key key;
		private Value value;
		private Node left;
		private Node right;

		Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

		public Key getKey() {
			return key;
		}

		public void setKey(Key key) {
			this.key = key;
		}

		public Value getValue() {
			return value;
		}

		public void setValue(Value value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}
}
