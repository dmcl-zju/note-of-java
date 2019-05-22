package class01;

import java.util.Arrays;

/*
 * 基本思路：数组中定义需要排序区域A,定义A区域头指针i，将i作为存放数组最小值的地方，
 * 遍历i+1开始的所有数(到arr.length-1)与i相比，有小的则换过来直到数组结束。然
 * 后A区域缩小，即i++,进入下一次循环。当i到达数组倒数第二个数的时候说明数组剩下两
 * 个数，进行最后一次排序即可。
 */
public class MySelectionSort {
	
	public static void selectionSort(int[] arr) {
		if(arr==null || arr.length<=1) {
			return;
		}
		//A区域头指针，到倒数第二个位置结束
		for(int i=0;i<arr.length-1;i++) {
			//用来存放最小索引
			int minIndex = i;
			for(int j=i+1;j<arr.length;j++) {
				//只需记住最小值得索引，最后再换到前面可以减少频繁交换操作
				//碰到更小的就将其索引记住
				minIndex = arr[minIndex]>arr[j]?j:minIndex;
			}
			swap(arr,i,minIndex);
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
			selectionSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		selectionSort(arr);
		printArray(arr);
	}
}
