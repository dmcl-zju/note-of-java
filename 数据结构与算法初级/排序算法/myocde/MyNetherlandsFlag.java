package class01;

public class MyNetherlandsFlag {
	
	//partition的过程
	public static int[] partition(int[] arr,int L,int R, int N) {
		int less = L-1;
		int more = R+1;
		int cur = L;
		while(cur<more) {
			if(arr[cur]<N) {
				//当小于目标值得时候，加入小于区间后的一个值，扩大小于区间，cur向后移动
				swap(arr,++less,cur++);
			}else if(arr[cur]>N) {
				//当大于目标时候，加入大于区间的前一个值，扩大大于区间，cur动的原因是不知道换过来的数的状况，，等待下一次循环判断
				swap(arr,--more,cur);
			}else {
				//当等于的情况cur向后移动
				cur++;
			}
		}
		int[] p= {less+1,more-1};
		return p;
	}
	public static void swap(int[] arr,int i,int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	public static void main(String[] args) {
		int[] arr = {8,4,6,7,2,5,15,5,5,5};
		partition(arr,0,arr.length-1,5);
		for(int a:arr) {
			System.out.print(a+" ");
		}
	}
}
