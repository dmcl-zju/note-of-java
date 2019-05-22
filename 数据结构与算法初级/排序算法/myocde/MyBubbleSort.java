package class01;

import java.util.Arrays;

/*
 * 基本思路：数组中定义需要排的区域A,一开始为整个数组，那么可知A的尾指针初始为arr.length-1, 
 * 每次都从0开始遍历区域A，不包括该区域的最后一个点（因为对比的是当前数和其下
 * 一个数，因此遍历到B区域倒数第二个位置就行）。将当前数和其下一个数对比，如果
 * 小就不变，指针往后一位，如果大则交换，指针往后一位，这样保证大的数被一直推到
 * 末尾。然后A区域缩小一位（尾指针自减1）。一直循环直到尾指针到达1的位置（说明
 * 还剩两个数），进行最后一次排序。
 * */
public class MyBubbleSort {
	
	public static void bubbleSort(int[] arr) {
		if(arr==null || arr.length<=1) {
			return;
		}
		//这里e代表尾指针，从arr.length-1到1
		for(int e=arr.length-1;e>0;e--) {
			//i代表遍历的当前指针，每次遍历从0到e-1位置
			for(int i=0;i<e;i++) {
				if(arr[i] > arr[i+1]) {
					swap(arr,i,i+1);
				}
			}
		}
	}
	//交换函数
	public static void swap(int[] arr,int i,int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
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
			bubbleSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
	}
}













