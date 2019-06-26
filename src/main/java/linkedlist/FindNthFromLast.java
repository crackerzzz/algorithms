package linkedlist;

import linkedlist.MyLinkedList.Node;

public class FindNthFromLast {
	/***
	 * Returns the nth elements from the end of given linked list or -1 if not
	 * present.
	 * 
	 * @param list the linked list
	 * @param n
	 * @return nth element from end or -1
	 */
	public static int findNthFromLast(MyLinkedList<Integer> list, int n) {
		Node<Integer> fast = list.head;
		Node<Integer> slow = null;

		int count = 0;
		while (fast != null) {
			if (count >= n) {
				slow = (slow == null) ? list.head : slow.next;
			}
			fast = fast.next;
			++count;
		}
		return slow != null ? slow.element : -1;
	}

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		System.out.println(findNthFromLast(list, 2));
	}
}
