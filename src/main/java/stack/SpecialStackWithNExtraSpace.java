package stack;

import java.util.Stack;

public class SpecialStackWithNExtraSpace {
	private Stack<Integer> valueStack = new Stack<>();
	private Stack<Integer> maxStack = new Stack<>();

	public void push(Integer ele) {
		valueStack.push(ele);

		if (maxStack.isEmpty()) {
			maxStack.push(ele);
		} else {
			if (ele > maxStack.peek()) {
				maxStack.push(ele);
			} else {
				maxStack.push(maxStack.peek());
			}
		}
	}

	public Integer pop() {
		maxStack.pop();
		return valueStack.pop();
	}

	public Integer getMax() {
		return maxStack.peek();
	}

	public static void main(String[] args) {
		SpecialStackWithNExtraSpace stack = new SpecialStackWithNExtraSpace();
		stack.push(10);
		stack.push(15);
		stack.push(5);
		stack.push(50);
		stack.push(1);

		System.out.println(stack.getMax());// 50
		System.out.println(stack.pop());// 1
		System.out.println(stack.getMax());// 50
		System.out.println(stack.pop());// 50
		System.out.println(stack.pop());// 5
		System.out.println(stack.getMax());// 15
	}
}
