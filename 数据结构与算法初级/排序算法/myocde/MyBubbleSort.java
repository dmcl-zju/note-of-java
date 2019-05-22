package class01;

import java.util.Arrays;

/*
 * ����˼·�������ж�����Ҫ�ŵ�����A,һ��ʼΪ�������飬��ô��֪A��βָ���ʼΪarr.length-1, 
 * ÿ�ζ���0��ʼ��������A������������������һ���㣨��Ϊ�Աȵ��ǵ�ǰ��������
 * һ��������˱�����B�������ڶ���λ�þ��У�������ǰ��������һ�����Աȣ����
 * С�Ͳ��䣬ָ������һλ��������򽻻���ָ������һλ��������֤�������һֱ�Ƶ�
 * ĩβ��Ȼ��A������Сһλ��βָ���Լ�1����һֱѭ��ֱ��βָ�뵽��1��λ�ã�˵��
 * ��ʣ�����������������һ������
 * */
public class MyBubbleSort {
	
	public static void bubbleSort(int[] arr) {
		if(arr==null || arr.length<=1) {
			return;
		}
		//����e����βָ�룬��arr.length-1��1
		for(int e=arr.length-1;e>0;e--) {
			//i��������ĵ�ǰָ�룬ÿ�α�����0��e-1λ��
			for(int i=0;i<e;i++) {
				if(arr[i] > arr[i+1]) {
					swap(arr,i,i+1);
				}
			}
		}
	}
	//��������
	public static void swap(int[] arr,int i,int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	
//-----------------------------------------���������������-------------------------------------------
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













