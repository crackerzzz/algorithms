package linkedlist;

import java.util.Arrays;
import java.util.List;

public class Reverse<K extends Comparable<K>> extends LinkedList<K> {

	public Reverse() {

	}

	public Reverse(List<K> list) {
		list.forEach(ele -> add(ele));
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
		Reverse<Integer> list = new Reverse<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		System.out.println(list.toList());
		list.reverse();
		System.out.println(list.toList());
	}
}
