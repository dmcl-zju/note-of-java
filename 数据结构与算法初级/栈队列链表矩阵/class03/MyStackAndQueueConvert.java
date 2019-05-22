package class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyStackAndQueueConvert {
	
	//两个栈实现队列
	public static class TwoStackQueue{
		private Stack<Integer> pushStack;
		private Stack<Integer> popStack;
		
		public TwoStackQueue() {
			pushStack = new Stack<>();
			popStack = new Stack<>();
		}
		//入队列的时候直接入就行
		public void push(Integer obj) {
			pushStack.push(obj);
		}
		
		public Integer poll() {
			//两个栈都为空的时候抛异常
			if(pushStack.isEmpty() && popStack.isEmpty()) {
				throw new RuntimeException("Queue is empty!");
			}
			//倒一下
			convert();
			return popStack.pop();
		}
		
		public Integer peek() {
			//两个栈都为空的时候抛异常
			if(pushStack.isEmpty() && popStack.isEmpty()) {
				throw new RuntimeException("Queue is empty!");
			}
			//倒一下
			convert();
			return popStack.peek();
		}
		
		//将push栈倒到pop栈中:原则1等到popStack为空才倒2每次倒就倒干净
		public void convert() {
			if(popStack.isEmpty()) {
				while(!pushStack.isEmpty()) {
					popStack.push(pushStack.pop());
				}
			}
		}
		
	}
	//两个队列实现栈
	public static class TwoQueueStack{
		private Queue<Integer> queue;
		private Queue<Integer> help;
		
		public TwoQueueStack() {
			queue = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}
		//只管加入就行
		public void push(Integer obj) {
			queue.add(obj);
		}
		public Integer pop() {
			if(queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			//移除到只剩下一个元素
			while(!(queue.size()==1)) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			swap();
			return res;
		}
		public Integer peek() {
			if(queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			//移除到只剩下一个元素
			while(!(queue.size()==1)) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			help.add(res);
			swap();
			return res;
		}
		//交换两个栈的索引
		public void swap() {
			Queue<Integer> temp = queue;
			queue = help;
			help = temp;
		}
		
	}
	//测试函数
	public static void main(String[] args) {
		int size = 20;
		TwoStackQueue sq = new TwoStackQueue();
		for(int i=1;i<=size;i++) {
			sq.push(i);
		}
		System.out.println("队列输出:");
		for(int i=0;i<size;i++) {
			System.out.print(sq.poll()+" ");
		}
		System.out.println("");
		
		TwoQueueStack qs = new TwoQueueStack();
		for(int i=1;i<=size;i++) {
			qs.push(i);
		}
		System.out.println("栈输出:");
		for(int i=0;i<size;i++) {
			System.out.print(qs.pop()+" ");
		}
		System.out.println("");
		
		
	}
}
