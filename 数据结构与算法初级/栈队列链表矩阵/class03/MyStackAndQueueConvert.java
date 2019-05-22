package class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyStackAndQueueConvert {
	
	//����ջʵ�ֶ���
	public static class TwoStackQueue{
		private Stack<Integer> pushStack;
		private Stack<Integer> popStack;
		
		public TwoStackQueue() {
			pushStack = new Stack<>();
			popStack = new Stack<>();
		}
		//����е�ʱ��ֱ�������
		public void push(Integer obj) {
			pushStack.push(obj);
		}
		
		public Integer poll() {
			//����ջ��Ϊ�յ�ʱ�����쳣
			if(pushStack.isEmpty() && popStack.isEmpty()) {
				throw new RuntimeException("Queue is empty!");
			}
			//��һ��
			convert();
			return popStack.pop();
		}
		
		public Integer peek() {
			//����ջ��Ϊ�յ�ʱ�����쳣
			if(pushStack.isEmpty() && popStack.isEmpty()) {
				throw new RuntimeException("Queue is empty!");
			}
			//��һ��
			convert();
			return popStack.peek();
		}
		
		//��pushջ����popջ��:ԭ��1�ȵ�popStackΪ�ղŵ�2ÿ�ε��͵��ɾ�
		public void convert() {
			if(popStack.isEmpty()) {
				while(!pushStack.isEmpty()) {
					popStack.push(pushStack.pop());
				}
			}
		}
		
	}
	//��������ʵ��ջ
	public static class TwoQueueStack{
		private Queue<Integer> queue;
		private Queue<Integer> help;
		
		public TwoQueueStack() {
			queue = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}
		//ֻ�ܼ������
		public void push(Integer obj) {
			queue.add(obj);
		}
		public Integer pop() {
			if(queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			//�Ƴ���ֻʣ��һ��Ԫ��
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
			//�Ƴ���ֻʣ��һ��Ԫ��
			while(!(queue.size()==1)) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			help.add(res);
			swap();
			return res;
		}
		//��������ջ������
		public void swap() {
			Queue<Integer> temp = queue;
			queue = help;
			help = temp;
		}
		
	}
	//���Ժ���
	public static void main(String[] args) {
		int size = 20;
		TwoStackQueue sq = new TwoStackQueue();
		for(int i=1;i<=size;i++) {
			sq.push(i);
		}
		System.out.println("�������:");
		for(int i=0;i<size;i++) {
			System.out.print(sq.poll()+" ");
		}
		System.out.println("");
		
		TwoQueueStack qs = new TwoQueueStack();
		for(int i=1;i<=size;i++) {
			qs.push(i);
		}
		System.out.println("ջ���:");
		for(int i=0;i<size;i++) {
			System.out.print(qs.pop()+" ");
		}
		System.out.println("");
		
		
	}
}
