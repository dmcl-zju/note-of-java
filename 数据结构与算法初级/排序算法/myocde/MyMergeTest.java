package class01;

public class MyMergeTest {
	/*
	 * 打印逆序对
	 * */
	public static void smallSum(int[] arr) {
		if(null==arr || arr.length<=1) {
			return;
		}
		smallSum(arr,0,arr.length-1);
	}
	//左半部分产生的小和、右半部分产生小和、最终合并在一起产生的小和相加为最终小和
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
		//产生辅助数组
		int[] help = new int[R-L+1];
		int i = 0;
		int p1 = L;
		int p2 = M+1;
		while(p1<=M && p2<=R) {
			//比归并排序增加了小和的累加过程
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
		//将数组复制回去
		for(i=0;i<help.length;i++) {
			arr[L+i] = help[i];
		}
	}
	public static void main(String[] args) {
		int[] arr = {3,2,1};
		smallSum(arr);
	}
	
}
