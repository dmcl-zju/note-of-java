package class03;

import java.util.HashMap;
import java.util.Map;


public class MyCopyListWithRandom {
	
	public static class Node {
		public int value;
		public Node next;
		public Node rand;

		public Node(int data) {
			this.value = data;
		}
	}
	
	//˼·һ������mapʵ��
	public static Node copyListWithRand1(Node head) {
		if(null == head) {
			return null;
		}
		Map<Node,Node> map = new HashMap<>();
		//�����������map,��Ϊkey,����ͬ��ֵ�Ľڵ���Ϊvalue
		Node cur = head;
		while(cur != null) {
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		//�ٴα�����������ָ�븴��
		cur = head;
		while(cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}
	
//----------------------˼·������ռ�ÿռ�ķ���-------------------------------------
	public static Node copyListWithRand2(Node head) {
		//System.out.println("666666666666666666666666666");
		if(null == head) {
			//System.out.println("55555555555555555555555");
			return null;
		}
		//�����������Ʒ�������һ���ڵ���
		Node cur = head;
		Node next = null;
		Node copy  = null;
		while(cur != null) {
			//System.out.println("����1");
			//�൱���ȸ���һ��Ȼ�����
			copy = new Node(cur.value);
			//�ȼ�ס��һ���ڵ�
			next = cur.next;
			//���븴�ƵĽڵ㡣
			cur.next = copy;
			copy.next = next;
			//�ڵ�����ƶ�
			cur = next;
		}		
		//�������ָ��
		cur = head;
		while(cur != null) {
			//���õ���һ��
			next = cur.next.next;
			//�õ�copy�ڵ�--ֻҪ���渴��û������ôcur.nextһ����Ϊnull
			copy = cur.next;
			//�������ָ��
			copy.rand = cur.rand==null?null:cur.rand.next;
			//���½ڵ�
			cur = next;
		}
		//�ȱ����ø��Ƶ�����ͷ
		Node res = head.next;
		//����������⿪����������õ����ƺõ�����
		cur = head;
		while(cur != null) {
			//�Ȼ����һ���ڵ�(�����cur.next��һ�����ڵ�)
			next = cur.next.next;
			//��ø��ƽڵ�
			copy = cur.next;
			//ԭ���ڵ�ָ���Լ���������һ��
			cur.next = next;
			//copyҲָ���Լ��ĸ��Ƶ���һ�������ж���û����һ��
			copy.next = copy.next==null?null:copy.next.next;
			//���½ڵ�
			cur = next;
			
		}
		return res;
	}
	
	
//--------------------------------------------------------------------------	
	public static void printRandLinkedList(Node head) {
		Node cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;
		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

	}
	
	
}
