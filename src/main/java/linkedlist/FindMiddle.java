package linkedlist;

import java.util.Arrays;

import linkedlist.LinkedList.Node;

public class FindMiddle {

	public static int findMiddle(LinkedList<Integer> list) {
		Node<Integer> fast = list.head;
		Node<Integer> slow = list.head;

		boolean even = false;
		while (fast != null) {
			if (even) {
				slow = slow.next;
			}
			fast = fast.next;
			even = !even;
		}
		return slow.element;
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

		System.out.println(findMiddle(list));
	}
}
