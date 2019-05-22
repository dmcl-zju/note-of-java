package class01;

public class MyMergeTest {
	/*
	 * ��ӡ�����
	 * */
	public static void smallSum(int[] arr) {
		if(null==arr || arr.length<=1) {
			return;
		}
		smallSum(arr,0,arr.length-1);
	}
	//��벿�ֲ�����С�͡��Ұ벿�ֲ���С�͡����պϲ���һ�������С�����Ϊ����С��
	public static void smallSum(int[] arr,int L,int R) {
		if(L==R) {
			return;
		}
		int M = L+((R-L)>>1);
		smallSum(arr,L,M);
		smallSum(arr,M+1,R);
		merge(arr,L,M,R);
	}
	public static void merge(int[] arr,int L,int M,int R) {
		//������������
		int[] help = new int[R-L+1];
		int i = 0;
		int p1 = L;
		int p2 = M+1;
		while(p1<=M && p2<=R) {
			//�ȹ鲢����������С�͵��ۼӹ���
			if(arr[p1]>arr[p2]) {
				for(int j=p2;j<=R;j++) {
					System.out.println(arr[p1]+"---"+arr[j]);
				}
				help[i++] = arr[p1++];
			}else {
				help[i++] = arr[p2++];
			}
		}
		while(p1<=M) {
			help[i++] = arr[p1++];
		}
		while(p2<=R) {
			help[i++] = arr[p2++];
		}
		//�����鸴�ƻ�ȥ
		for(i=0;i<help.length;i++) {
			arr[L+i] = help[i];
		}
	}
	public static void main(String[] args) {
		int[] arr = {3,2,1};
		smallSum(arr);
	}
	
}
