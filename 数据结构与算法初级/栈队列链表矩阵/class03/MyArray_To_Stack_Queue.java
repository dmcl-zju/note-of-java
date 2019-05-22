package class03;

public class MyArray_To_Stack_Queue {
	
	//����ջ
	public static class ArrayStack{
		private int[] arr;
		//index����ָ����һ��Ҫ�����λ�ã�һ��ҪȡԪ�ؾ���index-1�����index
		private int index;
		//������--�����С
		public ArrayStack(int initSize) {
			if(initSize<0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new int[initSize];
			index = 0;
		}
		//��ջ
		public void  push(int num) {
			//�ж������ǲ�������
			if(index == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The stack is full");
			}
			//
			arr[index++] = num;
		}
		//��ջ
		public int pop() {
			if(index == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			return arr[--index];
		}
		//�鿴ջ��
		public int peek() {
			if(index == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			return arr[index-1];
		}
		
	}
	//�������
	public static class ArrayQueue{
		private Integer[] arr;
		private Integer size;
		private Integer head;
		private Integer tail;
		public ArrayQueue(int initSize) {
			if(initSize<0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
			head = 0;
			tail = 0;
		}
		
		public void push(Integer obj) {
			if(size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("this queue is full");
			}
			size++;
			arr[tail] = obj;
			tail = tail==arr.length-1?0:tail+1;
		}
		
		public Integer pop() {
			if(size == 0) {
				throw new ArrayIndexOutOfBoundsException("this queue is empty");
			}
			size--;
			int temp = head;
			head = head==arr.length-1?0:head+1;
			return arr[temp];
		}
		public Integer peek() {
			if(size == 0) {
				return null;
			}
			return arr[head];
		}
		 
	}
	
	//���Ժ���
	public static void main(String[] args) {
		int size = 20;
		ArrayStack as = new ArrayStack(size);
		for(int i=1;i<=size;i++) {
			as.push(i);
		}
		System.out.println("ջ���:");
		for(int i=0;i<size;i++) {
			System.out.print(as.pop()+" ");
		}
		System.out.println("");
		ArrayQueue aq = new ArrayQueue(size);
		for(int i=1;i<=size;i++) {
			aq.push(i);
		}
		System.out.println("�������:");
//		for(int i=0;i<size;i++) {
//			System.out.print(aq.pop()+" ");
//		}
//		System.out.println("");
		while(null != aq.peek()) {
			System.out.print(aq.pop()+" ");
		}
		
	}
	
}
