package stack;

import java.util.Stack;

public class SpecialStackWith1ExtraSpace {
	private Stack<Integer> stack = new Stack<>();
	private Integer minElement = -1;

	public SpecialStackWith1ExtraSpace() {
	}

	public void push(Integer ele) {
		final Integer stackElement;
		if (stack.size() == 1) {
			minElement = ele;
			stackElement = ele;
		} else {
			if (ele < minElement) {
				stackElement = calcStackElement(ele, minElement);
				minElement = ele;
			} else {
				stackElement = ele;
			}
		}
		stack.push(stackElement);
	}

	private static Integer calcStackElement(Integer ele, Integer minEle) {
		return 2 * ele - minEle;
	}

	public Integer pop() {
		Integer popped = minElement;
		if (stack.peek() <= minElement) {
			minElement = calcStackElement(minElement, stack.pop());
		}
		return popped;
	}

	public Integer getMin() {
		return minElement;
	}

	public static void main(String[] args) {
		SpecialStackWith1ExtraSpace stack = new SpecialStackWith1ExtraSpace();
		stack.push(3);
		stack.push(5);
		stack.push(2);
		stack.push(1);
		stack.push(1);
		stack.push(-1);

		System.out.println(stack.getMin());// -1
		System.out.println(stack.pop());// -1
		System.out.println(stack.getMin());// 1
		System.out.println(stack.pop());// 1
		System.out.println(stack.getMin());// 1
		System.out.println(stack.pop());// 1
		System.out.println(stack.getMin());// 2
		System.out.println(stack.getMin());// 2
		System.out.println(stack.getMin());// 5
		System.out.println(stack.pop());// 5
		System.out.println(stack.pop());// 3
		System.out.println(stack.pop());// 3
	}
}
