package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList<K extends Comparable<K>> {
	Node<K> head;
	Node<K> tail;

	public MyLinkedList() {

	}

	public void add(K element) {
		Node<K> node = new Node<>(element);
		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.next = node;
			tail = tail.next;
		}
	}

	public List<K> toList() {
		List<K> list = new ArrayList<>();
		Node<K> temp = head;
		while (temp != null) {
			list.add(temp.element);
			temp = temp.next;
		}
		return list;
	}

	public static class Node<K> {
		K element;
		Node<K> next;

		public Node(K element) {
			this.setElement(element);
		}

		public K getElement() {
			return element;
		}

		public void setElement(K element) {
			this.element = element;
		}
	}
}