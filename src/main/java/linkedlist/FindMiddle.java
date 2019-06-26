package linkedlist;

import linkedlist.MyLinkedList.Node;

public class FindMiddle {

	public static int findMiddle(MyLinkedList<Integer> list) {
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
		MyLinkedList<Integer> list = new MyLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(6);
		list.add(8);
		System.out.println(findMiddle(list));
	}
}
