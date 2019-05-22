package class01;

public class MySmallSum {
	
	public static int smallSum(int[] arr) {
		if(null==arr || arr.length<=1) {
			return 0;
		}
		return smallSum(arr,0,arr.length-1);
	}
	//左半部分产生的小和、右半部分产生小和、最终合并在一起产生的小和相加为最终小和
	public static int smallSum(int[] arr,int L,int R) {
		if(L==R) {
			return 0;
		}
		int M = L+((R-L)>>1);
		int left = smallSum(arr,L,M);
		int right = smallSum(arr,M+1,R);
		//三部分小和相加
		return left+right+merge(arr,L,M,R);
	}
	public static int merge(int[] arr,int L,int M,int R) {
		//产生辅助数组
		int[] help = new int[R-L+1];
		int i = 0;
		int p1 = L;
		int p2 = M+1;
		//用来存储小和
		int result = 0;
		while(p1<=M && p2<=R) {
			//比归并排序增加了小和的累加过程
			result = result + (arr[p1]<arr[p2]?arr[p1]*(R-p2+1):0);
			help[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
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
		return result;
	}
	// for test
	public static int comparator(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int res = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				res += arr[j] < arr[i] ? arr[j] : 0;
			}
		}
		return res;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 5;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			if (smallSum(arr1) != comparator(arr2)) {
				succeed = false;
				System.out.println(smallSum(arr1)+"--"+comparator(arr2));
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

}
