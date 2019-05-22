package class03;



//链表的荷兰国旗问题
public class MySmallerEqualBigger {
	
	public static class Node{
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	
	//思路一：将链表读取到数组中，然后利用荷兰国旗解决，再恢复成链表
	public static Node listPartition1(Node head,int pivot) {
		
		Node cur = head;
		//先统计出链表节点数
		int i=0;
		while(cur!=null) {
			i++;
			cur = cur.next;
		}
		//创建相同大小的数组
		int[] arr = new int[i];
		cur = head;
		//链表中的值读取到数组中
		for(i=0;i<arr.length;i++) {
			arr[i] = cur.value;
			cur = cur.next;
		}
		//荷兰国旗式partition
		partition(arr,pivot);
		//数组重构链表，返回表头
		return creatLinkList(arr);
	}
	//荷兰国旗式partition
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

	//思路二：遍历链表把小于等于大于三个区域放到三个链表中，最后
	public static Node listPartition2(Node head,int pivot) {
		Node sH = null;
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node bH = null;
		Node bT = null;
		//遍历链表
		while(head != null) {
			//先和原先的链表解除关系
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
		//然后将单个链表串起来
		
		//如果第一个存在
		if(null != sH) {
			//不管存不存在都先接上
			sT.next = eH;
			if(eH == null) {
				eT = sT;
			}
		}
		//如果第前两个至少存在1个
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
	//把一个数组转换成链表，返回链表头
	public static Node creatLinkList(int[] arr) {
		//head记录链表头
		Node head = null;
		//tail记录链表尾
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
	//打印链表
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
