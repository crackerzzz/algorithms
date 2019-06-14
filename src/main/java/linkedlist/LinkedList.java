package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<K extends Comparable<K>> {
	Node<K> head;
	Node<K> tail;

	public LinkedList() {

	}

	public LinkedList(List<K> list) {
		list.forEach(ele -> add(ele));
	}

	public void add(K element) {
		LinkedList.Node<K> node = new LinkedList.Node<>(element);
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
		LinkedList.Node<K> next;

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