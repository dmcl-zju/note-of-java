package class03;



//����ĺ�����������
public class MySmallerEqualBigger {
	
	public static class Node{
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	
	//˼·һ���������ȡ�������У�Ȼ�����ú������������ٻָ�������
	public static Node listPartition1(Node head,int pivot) {
		
		Node cur = head;
		//��ͳ�Ƴ�����ڵ���
		int i=0;
		while(cur!=null) {
			i++;
			cur = cur.next;
		}
		//������ͬ��С������
		int[] arr = new int[i];
		cur = head;
		//�����е�ֵ��ȡ��������
		for(i=0;i<arr.length;i++) {
			arr[i] = cur.value;
			cur = cur.next;
		}
		//��������ʽpartition
		partition(arr,pivot);
		//�����ع��������ر�ͷ
		return creatLinkList(arr);
	}
	//��������ʽpartition
	public static void partition(int[] arr,int pivot) {
		if(null == arr|| arr.length<2) {
			return;
		}
		int less = -1;
		int more = arr.length;
		int cur = 0;
		while(cur<more) {
			if(arr[cur]<pivot) {
				swap(arr,++less,cur++);
			}else if(arr[cur]>pivot) {
				swap(arr,--more,cur);
			}else {
				cur++;
			}
		}
	}
	public static void swap(int[] arr,int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	//˼·�������������С�ڵ��ڴ�����������ŵ����������У����
	public static Node listPartition2(Node head,int pivot) {
		Node sH = null;
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node bH = null;
		Node bT = null;
		//��������
		while(head != null) {
			//�Ⱥ�ԭ�ȵ���������ϵ
			Node next = head.next;
			head.next = null;
			if(head.value<pivot) {
				if(sH == null) {
					sH = head;
					sT = head;
				}else {
					sT.next = head;
					sT = sT.next;
				}
			}else if(head.value==pivot) {
				if(eH == null) {
					eH = head;
					eT = head;
				}else {
					eT.next = head;
					eT = eT.next;
				}
			}else {
				if(bH == null) {
					bH = head;
					bT = head;
				}else {
					bT.next = head;
					bT = bT.next;
				}
			}
			head = next;
		}
		//Ȼ�󽫵�����������
		
		//�����һ������
		if(null != sH) {
			//���ܴ治���ڶ��Ƚ���
			sT.next = eH;
			if(eH == null) {
				eT = sT;
			}
		}
		//�����ǰ�������ٴ���1��
		if(null != eT) {
			eT.next=bH;
		}
		if(sH != null) {
			return sH;
		}else if(eH != null) {
			return eH;
		}else {
			return bH;
		}
			
	}	
/*---------------------------------------------------------------------*/
	//��һ������ת����������������ͷ
	public static Node creatLinkList(int[] arr) {
		//head��¼����ͷ
		Node head = null;
		//tail��¼����β
		Node tail = null;
		for(int i=0;i<arr.length;i++) {
			Node newNode = new Node(arr[i]);
			if(null == head) {
				head = newNode;
				tail = head;
			}else {
				tail.next = newNode;
				tail = tail.next;
			}
		}
		return head;
	}
	//��ӡ����
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
/*---------------------------------------------------------------------*/	
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {6,8,3,4,4,6,7,2,4};
		Node head = creatLinkList(arr);
		printLinkedList(head);
		Node newHead = listPartition2(head,4);
		printLinkedList(newHead);
		
	}
	
}
