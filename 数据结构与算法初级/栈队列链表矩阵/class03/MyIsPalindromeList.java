package class03;

import java.util.Stack;


public class MyIsPalindromeList {
	
	//定义节点
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	//方法一：读出来入栈，然后出栈和原来链表比对，一个不符合就false
	public static boolean isPalindrom1(Node head) {
		if(null == head) {
			return false;
		}
		Node node = head;
		Stack<Integer> stack = new Stack<>();
		//入栈
		while(head != null) {
			stack.push(head.value);
			head = head.next;
		}
		
		//出栈对比
		head = node;
		while(head != null) {
			if(head.value!=stack.pop()) {
				return false;
				
			}
			head = head.next;
		}
		return true;	
	}
	//方法二：只用N/2空间
	public static boolean isPalindrom2(Node head) {
		Stack<Integer> stack = new Stack<>();
		Node fast = head;
		Node slow = head;
		while(fast.next!=null && fast.next.next!= null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = slow.next;
		while(slow != null) {
			//System.out.println(slow.value);
			stack.push(slow.value);
			slow = slow.next;
			
		}
		slow = head;
		while(!stack.isEmpty()) {
			//System.out.println(slow.value+"--"+stack.peek());
			if(slow.value != stack.pop()) {
				return false;
			}
			slow = slow.next;
		}
		//全都一样才是
		return true;
	}
	//方法三：空间复杂度为O(1)
	public static boolean isPalindrom3(Node head) {
		boolean res = true;
		//先找中点
		Node fast = head;
		Node slow = head;
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		//对后半部分进行反转
		Node pre = null;
		Node next = null;
		while(slow != null) {
			//System.out.println(slow.value+"------");
			next = slow.next;
			slow.next = pre;
			pre = slow;
			slow = next;
		}
		//两边进行对比
		slow = pre;
		while(head != null) {
			//System.out.println(slow.value+"------"+head.value);
			if(head.value != slow.value) {
				res = false;
			}
			head = head.next;
			slow = slow.next;
		}
		//先将链表恢复原来的样子，不改变数据
		head = pre;
		pre = null;
		next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return res;
	}
	
	
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		head.next.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.println("方法一："+isPalindrom1(head));
		System.out.println("方法二："+isPalindrom2(head));
		printLinkedList(head);
		System.out.println("方法三："+isPalindrom3(head));
		printLinkedList(head);
	}
}
