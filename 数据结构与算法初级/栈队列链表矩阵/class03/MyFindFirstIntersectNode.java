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
	//�ܳ���
	public static Node getIntersectNode(Node head1, Node head2) {
		if(head1==null || head2==null) {
			return null;
		}
		//���ж���û�л�
		Node loop1 = getLoopNode2(head1);
		Node loop2 = getLoopNode2(head2);
		//��������
		if(loop1==null&&loop2==null) {
			//�����޻�
			return noLoop2(head1,head2);
		}else if(loop1!=null && loop2!=null) {
			//�����л�
			return bothLoop(head1,loop1,head2,loop2);
		}
		//һ���л�һ���޻�
		return null;
	}
	
	
	
	
	//�ж������л�������û�н���--ֻ�����ֿ���
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1=null;
		Node cur2=null;
		if(loop1==loop2) {
			//��ʱ��϶����ཻ�ģ����޻�һ����˼·��ڵ�
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
			//�ѳ��ĸ�cur1
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
					//loop1��loop2������
					return loop1;
				}
				cur1=cur1.next;
			}
			//ת��һȦ��û�о���û���ཻ
			return null;
		}
		
	}
	
	////�ж������޻�������û�н���--ʹ��set����
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
		//˵�����ཻ
		return null;
	}
	//�ж������޻�������û�н���
	public static Node noLoop2(Node head1, Node head2) {
		if(null==head1 || null==head2) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n=0;
		//ע�������ֹ����
		while(cur1.next != null) {
			n++;
			cur1=cur1.next;
		}
		while(cur2.next != null) {
			n--;
			cur2=cur2.next;
		}
		//���ʱ���������ߵ������ڵ���,������һ������һ���ڵ�϶��Ͳ��ཻ
		if(cur1!=cur2) {
			return null;
		}
		//��cur1Ϊ���ģ�cur2Ϊ�̵�
		cur1 = n>0?head1:head2;
		cur2 = cur1==head1?head2:head1;
		n = Math.abs(n);
		//��������n��
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
	//ʹ��Set�ķ���--��ռ���˿ռ�
	public static  Node getLoopNode1(Node head) {
		if(head==null) {
			return null;
		}
		//����set
		Set<Node> set = new HashSet<>();
		//�����ѭ������Ͳ�������ѭ����ֱ���ҵ��ظ��ڵ�
		while(head!=null) {
			if(set.contains(head)) {
				return head;
			}else {
				set.add(head);
				head = head.next;
			}
		}
		//������ѭ��˵�����ǻ�
		return null;
	}
	//����ָ��ķ���--�ص�
	public static  Node getLoopNode2(Node head) {
		//û�нڵ㣬ֻ��һ���ڵ㣬�����ڵ㵫�ǵڶ����ڵ�ָ��ն�����ֱ���ų�(Ϊ�˿�ָ���ų���)
		if(head==null || head.next==null || head.next.next==null) {
			return null;
		}
		//�������ָ��
		Node slow = head.next;
		Node fast = head.next.next;
		while(slow != fast) {
			//��ָ�������սڵ���
			if(fast.next==null || fast.next.next==null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		//�ߵ���˵���л�����,��ָ�뵽ͷ��,ÿ�θ���һ��ֱ����������
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
