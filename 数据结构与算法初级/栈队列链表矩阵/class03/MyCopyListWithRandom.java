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
	
	//思路一：采用map实现
	public static Node copyListWithRand1(Node head) {
		if(null == head) {
			return null;
		}
		Map<Node,Node> map = new HashMap<>();
		//遍历链表加入map,作为key,创建同样值的节点作为value
		Node cur = head;
		while(cur != null) {
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		//再次遍历链表将两个指针复制
		cur = head;
		while(cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}
	
//----------------------思路二：不占用空间的方法-------------------------------------
	public static Node copyListWithRand2(Node head) {
		//System.out.println("666666666666666666666666666");
		if(null == head) {
			//System.out.println("55555555555555555555555");
			return null;
		}
		//遍历链表并复制放在其下一个节点上
		Node cur = head;
		Node next = null;
		Node copy  = null;
		while(cur != null) {
			//System.out.println("复制1");
			//相当于先复制一个然后插入
			copy = new Node(cur.value);
			//先记住下一个节点
			next = cur.next;
			//插入复制的节点。
			cur.next = copy;
			copy.next = next;
			//节点完后移动
			cur = next;
		}		
		//复制随机指针
		cur = head;
		while(cur != null) {
			//先拿到下一个
			next = cur.next.next;
			//拿到copy节点--只要上面复制没问题那么cur.next一定不为null
			copy = cur.next;
			//复制随机指针
			copy.rand = cur.rand==null?null:cur.rand.next;
			//更新节点
			cur = next;
		}
		//先保留好复制的链表头
		Node res = head.next;
		//将整个链表解开成两个链表得到复制好的链表
		cur = head;
		while(cur != null) {
			//先获得下一个节点(这里的cur.next是一定存在的)
			next = cur.next.next;
			//获得复制节点
			copy = cur.next;
			//原来节点指向自己本来的下一个
			cur.next = next;
			//copy也指向自己的复制的下一个，先判断有没有下一个
			copy.next = copy.next==null?null:copy.next.next;
			//更新节点
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
