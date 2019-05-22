package class03;

import java.util.HashSet;
import java.util.Set;

public class MyFindFirstIntersectNode {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	//总程序
	public static Node getIntersectNode(Node head1, Node head2) {
		if(head1==null || head2==null) {
			return null;
		}
		//先判断有没有环
		Node loop1 = getLoopNode2(head1);
		Node loop2 = getLoopNode2(head2);
		//分类讨论
		if(loop1==null&&loop2==null) {
			//两个无环
			return noLoop2(head1,head2);
		}else if(loop1!=null && loop2!=null) {
			//两个有环
			return bothLoop(head1,loop1,head2,loop2);
		}
		//一个有环一个无环
		return null;
	}
	
	
	
	
	//判断两个有环链表有没有交点--只有三种可能
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1=null;
		Node cur2=null;
		if(loop1==loop2) {
			//这时候肯定是相交的，和无环一样的思路求节点
			cur1=head1;
			cur2=head2;
			int n=0;
			while(cur1!=loop1) {
				n++;
				cur1=cur1.next;
			}
			while(cur2!=loop2) {
				n--;
				cur2=cur2.next;
			}
			//把长的给cur1
			cur1 = n>0?head1:head2;
			cur2 = cur1==head1?head2:head1;
			n = Math.abs(n);
			while(n!=0) {
				n--;
				cur1=cur1.next;
			}
			while(cur1!=cur2) {
				cur1=cur1.next;
				cur2=cur2.next;
			}
			return cur1;
		}else {
			cur1 = loop1.next;
			while(cur1 != loop1) {
				if(cur1==loop2) {
					//loop1和loop2都算是
					return loop1;
				}
				cur1=cur1.next;
			}
			//转了一圈还没有就是没有相交
			return null;
		}
		
	}
	
	////判断两个无环链表有没有交点--使用set来做
	public static Node noLoop1(Node head1, Node head2) {
		if(null==head1 || null==head2) {
			return null;
		}
		Set<Node> set = new HashSet<>();
		while(head1!=null) {
			set.add(head1);
			head1=head1.next;
		}
		while(head2!=null){
			if(set.contains(head2)){
				return head2;
			}
			head2=head2.next;
		}
		//说明不相交
		return null;
	}
	//判断两个无环链表有没有交点
	public static Node noLoop2(Node head1, Node head2) {
		if(null==head1 || null==head2) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n=0;
		//注意这边终止条件
		while(cur1.next != null) {
			n++;
			cur1=cur1.next;
		}
		while(cur2.next != null) {
			n--;
			cur2=cur2.next;
		}
		//这个时候两个都走到了最后节点了,如果最后一个不是一个节点肯定就不相交
		if(cur1!=cur2) {
			return null;
		}
		//另cur1为长的，cur2为短的
		cur1 = n>0?head1:head2;
		cur2 = cur1==head1?head2:head1;
		n = Math.abs(n);
		//长的先走n步
		while(n!=0) {
			cur1 = cur1.next;
			n--;
		}
		while(cur1!=cur2) {
			cur1=cur1.next;
			cur2=cur2.next;
		}
		return cur1;
	}
	//使用Set的方法--多占用了空间
	public static  Node getLoopNode1(Node head) {
		if(head==null) {
			return null;
		}
		//定义set
		Set<Node> set = new HashSet<>();
		//如果是循环链表就不会跳出循环，直到找到重复节点
		while(head!=null) {
			if(set.contains(head)) {
				return head;
			}else {
				set.add(head);
				head = head.next;
			}
		}
		//跳出了循环说明不是环
		return null;
	}
	//快慢指针的方法--重点
	public static  Node getLoopNode2(Node head) {
		//没有节点，只有一个节点，两个节点但是第二个节点指向空都可以直接排除(为了快指针排除的)
		if(head==null || head.next==null || head.next.next==null) {
			return null;
		}
		//定义快慢指针
		Node slow = head.next;
		Node fast = head.next.next;
		while(slow != fast) {
			//快指针遇到空节点了
			if(fast.next==null || fast.next.next==null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		//走到这说明有环存在,快指针到头部,每次各走一步直到两个相遇
		fast = head;
		while(fast!=slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
	
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}
}
