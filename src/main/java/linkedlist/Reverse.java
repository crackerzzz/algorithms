package linkedlist;

public class Reverse<K extends Comparable<K>> extends MyLinkedList<K> {

	public Reverse() {

	}

	public void reverse() {
		Node<K> previous = null, next = null;
		Node<K> current = head;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		tail = head;
		head = previous;
	}

	public static void main(String[] args) {
		Reverse<Integer> list = new Reverse<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(6);
		list.add(8);
		System.out.println(list.toList());
		list.reverse();
		System.out.println(list.toList());
	}
}
