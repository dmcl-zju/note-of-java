package class01;

import java.util.Arrays;

/*
      引例：求一个数组的最大值。利用分治的思想来做：就是将一个数组不断地一分为二，直到不
能再分。具体是找到数组的中点将其分为左右两个部分，求其各自的最大值，然后对比找出两
个较大者即为整个数组最大值。而求其左右部分的最大值时候明显可以重复该过程（利用递归
函数来做），一直分下去，终止条件就是数组不能再分下去了，只剩下一个数了直接返回该数
（剩下一个数可以认为就是最大值了）。
       回到排序的题目中，也是先找到数组的中点，分为左右两个部分，将其各自排序，然后得到
 左右都各自排序的数组，利用merge函数可以将整个排好序。而左右部分排序也是重复这样
  分割的过程，直到剩下一个数就不能在分了，此时只有一个值也可以视为有序了，直接返回
  （不是返回该数，而是函数返回）。返回到上一层函数中用merger函数的整合。
 * */
public class MyMergeSort {
	
	public static void mergeSort(int[] arr) {
		if(null==arr || arr.length<=1) {
			return;
		}
		mergeSort(arr,0,arr.length-1);
	}
	//真正的递归函数---分治思想
	public static void mergeSort(int[] arr,int L,int R) {
		//终止条件
		if(L==R) {
			return;
		}
		//先求中点将数组分成两个部分
		int M = L+((R-L)>>1);
		mergeSort(arr,L,M);
		mergeSort(arr,M+1,R);
		merge(arr,L,M,R);
	}
	//外排函数：将有序的左右部分整合成整个有序
	public static void merge(int[] arr,int L, int M, int R) {
		int[] help = new int[R-L+1];
		int i = 0;
		int p1 = L;
		int p2 = M+1;
		//当有一组到尽头后终止
		while(p1<=M && p2<=R) {
			help[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
		}
		//将未走完的数组复制过来，下面两个while循环必定只会执行一个
		while(p1<=M) {
			help[i++] = arr[p1++];
		}
		while(p2<=R) {
			help[i++] = arr[p2++];
		}
		//将help数组复制回arr中
		for(int j=0;j<help.length;j++) {
			//这里注意是从左边界开始，不是从数组的0索引开始
			arr[L+j] = help[j];
		}
	}
//-----------------------------------------产生随机样例测试-------------------------------------------
	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
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
		int maxSize = 10;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			mergeSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		mergeSort(arr);
		printArray(arr);
	}
}
