package class03;

import java.util.Stack;

public class MyGetMinStack {
	
	//两种思路实现
	//思路一：对比min栈顶大的数将min栈顶入栈
	public static class MyStack1{
		private Stack<Integer> dataStack;
		private Stack<Integer> minStack;
		
		public MyStack1() {
			dataStack = new Stack<>();
			minStack = new Stack<>();
		}
		
		public void push(Integer obj) {
			if(minStack.isEmpty()) {
				minStack.push(obj);
			}else if(obj<minStack.peek()) {
				minStack.push(obj);
			}else {
				minStack.push(minStack.peek());
			}
			dataStack.push(obj);
		}
		
		public Integer pop() {
			if(dataStack.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			minStack.pop();
			return dataStack.pop();
		}
		
		public Integer peek() {
			if(dataStack.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return dataStack.peek();
		}
		public Integer getMin() {
			if(minStack.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return minStack.peek();
		}
		
	}
	
	//思路二：对比min栈顶大的数不对min进行操作
	public static class MyStack2{
		private Stack<Integer> dataStack;
		private Stack<Integer> minStack;
		
		public MyStack2() {
			dataStack = new Stack<>();
			minStack = new Stack<>();
		}
		
		public void push(Integer obj) {
			if(minStack.isEmpty()) {
				minStack.push(obj);
			}else if(obj<=minStack.peek()) {
				minStack.push(obj);
			}
			dataStack.push(obj);
		}
		
		public Integer pop() {
			if(dataStack.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			//只有弹出的数比最小值栈顶小于或等于才弹出
			if(minStack.peek()>=dataStack.peek()) {
				minStack.pop();
			}
			return dataStack.pop();
		}
		
		public Integer peek() {
			if(dataStack.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return dataStack.peek();
		}
		public Integer getMin() {
			if(minStack.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return minStack.peek();
		}
		
	}
	
	public static void main(String[] args) {
		MyStack1 stack1 = new MyStack1();
		stack1.push(3);
		System.out.println(stack1.getMin());
		stack1.push(4);
		System.out.println(stack1.getMin());
		stack1.push(1);
		System.out.println(stack1.getMin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getMin());

		System.out.println("=============");

		MyStack1 stack2 = new MyStack1();
		stack2.push(3);
		System.out.println(stack2.getMin());
		stack2.push(4);
		System.out.println(stack2.getMin());
		stack2.push(1);
		System.out.println(stack2.getMin());
		System.out.println(stack2.pop());
		System.out.println(stack2.getMin());
	}
	
}
