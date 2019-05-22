package class01;

import java.util.Arrays;

/*
 * 基本思路：将数组分为两个部分，前部分为有序区域，后部分为无序区域设为A.初始的情况是有序区只有一个数
 * （单个数可以认为必定有序）。定义Aq区域头指针i ，i-1就是有序区域了。让i和有序区域的值进行对比，如
 * 果比起小就交换，知道有序区的第一个数，中间遇到比其大的情况就停止遍历，将i++，缩小无序区域，直到
 * i=arr.length-1说明到无序的只剩一个数了，进行最后一操作。
 */
public class MyInsertionSort {
	
	public static void insertionSort(int[] arr) {
		if(arr==null || arr.length<=1) {
			return;
		}
		//这里的0-j为有序区域，i-arr.length-1为无序区域
		//数组第一个数认为已经有序了不必进行操作
		for(int i=1;i<arr.length;i++) {
			for(int j=i-1;j>=0;j--) {
				//因为j之前都是有序，因此后面比前面大就不用再遍历了
				if(arr[j]<=arr[j+1]) {
					break;
				}else {
					swap(arr,j,j+1);
				}
				
			}
		}
	}
	
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
			insertionSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		insertionSort(arr);
		printArray(arr);
	}
}
