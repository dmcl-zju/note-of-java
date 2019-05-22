package class03;

public class MyArray_To_Stack_Queue {
	
	//构造栈
	public static class ArrayStack{
		private int[] arr;
		//index总是指向下一个要填入的位置，一次要取元素就是index-1存就是index
		private int index;
		//构造器--传入大小
		public ArrayStack(int initSize) {
			if(initSize<0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new int[initSize];
			index = 0;
		}
		//入栈
		public void  push(int num) {
			//判断数组是不是满了
			if(index == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The stack is full");
			}
			//
			arr[index++] = num;
		}
		//出栈
		public int pop() {
			if(index == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			return arr[--index];
		}
		//查看栈顶
		public int peek() {
			if(index == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			return arr[index-1];
		}
		
	}
	//构造队列
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
	
	//测试函数
	public static void main(String[] args) {
		int size = 20;
		ArrayStack as = new ArrayStack(size);
		for(int i=1;i<=size;i++) {
			as.push(i);
		}
		System.out.println("栈输出:");
		for(int i=0;i<size;i++) {
			System.out.print(as.pop()+" ");
		}
		System.out.println("");
		ArrayQueue aq = new ArrayQueue(size);
		for(int i=1;i<=size;i++) {
			aq.push(i);
		}
		System.out.println("队列输出:");
//		for(int i=0;i<size;i++) {
//			System.out.print(aq.pop()+" ");
//		}
//		System.out.println("");
		while(null != aq.peek()) {
			System.out.print(aq.pop()+" ");
		}
		
	}
	
}
