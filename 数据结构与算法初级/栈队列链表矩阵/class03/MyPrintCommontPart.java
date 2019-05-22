package class03;


public class MyPrintCommontPart {
	
	public static class Node{
		private int val;
		private Node next;
		public Node(int val) {
			this.val = val;
		}
	}
	
	
	public static void printCommonPart(Node head1,Node head2) {
		System.out.print("common part：");
		//只有当两个表都
		while(head1!=null && head2!=null) {
			if(head1.val == head2.val) {
				System.out.print(head1.val+" ");
				head1 = head1.next;
				head2 = head2.next;
			}else if(head1.val<head2.val) {
				head1 = head1.next;
			}else {
				head2 = head2.next;
			}
		}
		System.out.println("");
	}
	
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void reversePrintlist(Node node) {
		if(null == node) {
			return;
		}
		reversePrintlist(node.next);
		System.out.print(node.val+" ");
	}
	
	
	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(5);
		head1.next.next.next = new Node(7);
		head1.next.next.next.next = new Node(8);
		
		Node head2 = new Node(1);
		head2.next = new Node(2);
		head2.next.next = new Node(3);
		head2.next.next.next = new Node(6);
		head2.next.next.next.next = new Node(8);
		printLinkedList(head1);
		printLinkedList(head2);
		printCommonPart(head1,head2);
		System.out.print("reverse List: ");
		reversePrintlist(head1);
		System.out.println("");
	}
}
