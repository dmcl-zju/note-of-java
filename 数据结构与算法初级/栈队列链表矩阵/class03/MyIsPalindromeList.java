package class03;

import java.util.Stack;


public class MyIsPalindromeList {
	
	//����ڵ�
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	//����һ����������ջ��Ȼ���ջ��ԭ������ȶԣ�һ�������Ͼ�false
	public static boolean isPalindrom1(Node head) {
		if(null == head) {
			return false;
		}
		Node node = head;
		Stack<Integer> stack = new Stack<>();
		//��ջ
		while(head != null) {
			stack.push(head.value);
			head = head.next;
		}
		
		//��ջ�Ա�
		head = node;
		while(head != null) {
			if(head.value!=stack.pop()) {
				return false;
				
			}
			head = head.next;
		}
		return true;	
	}
	//��������ֻ��N/2�ռ�
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
		//ȫ��һ������
		return true;
	}
	//���������ռ临�Ӷ�ΪO(1)
	public static boolean isPalindrom3(Node head) {
		boolean res = true;
		//�����е�
		Node fast = head;
		Node slow = head;
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		//�Ժ�벿�ֽ��з�ת
		Node pre = null;
		Node next = null;
		while(slow != null) {
			//System.out.println(slow.value+"------");
			next = slow.next;
			slow.next = pre;
			pre = slow;
			slow = next;
		}
		//���߽��жԱ�
		slow = pre;
		while(head != null) {
			//System.out.println(slow.value+"------"+head.value);
			if(head.value != slow.value) {
				res = false;
			}
			head = head.next;
			slow = slow.next;
		}
		//�Ƚ�����ָ�ԭ�������ӣ����ı�����
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
		System.out.println("����һ��"+isPalindrom1(head));
		System.out.println("��������"+isPalindrom2(head));
		printLinkedList(head);
		System.out.println("��������"+isPalindrom3(head));
		printLinkedList(head);
	}
}
