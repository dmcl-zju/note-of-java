package class01;

import java.util.Arrays;

/*
      ��������һ����������ֵ�����÷��ε�˼�����������ǽ�һ�����鲻�ϵ�һ��Ϊ����ֱ����
���ٷ֡��������ҵ�������е㽫���Ϊ�����������֣�������Ե����ֵ��Ȼ��Ա��ҳ���
���ϴ��߼�Ϊ�����������ֵ�����������Ҳ��ֵ����ֵʱ�����Կ����ظ��ù��̣����õݹ�
������������һֱ����ȥ����ֹ�����������鲻���ٷ���ȥ�ˣ�ֻʣ��һ������ֱ�ӷ��ظ���
��ʣ��һ����������Ϊ�������ֵ�ˣ���
       �ص��������Ŀ�У�Ҳ�����ҵ�������е㣬��Ϊ�����������֣������������Ȼ��õ�
 ���Ҷ�������������飬����merge�������Խ������ź��򡣶����Ҳ�������Ҳ���ظ�����
  �ָ�Ĺ��̣�ֱ��ʣ��һ�����Ͳ����ڷ��ˣ���ʱֻ��һ��ֵҲ������Ϊ�����ˣ�ֱ�ӷ���
  �����Ƿ��ظ��������Ǻ������أ������ص���һ�㺯������merger���������ϡ�
 * */
public class MyMergeSort {
	
	public static void mergeSort(int[] arr) {
		if(null==arr || arr.length<=1) {
			return;
		}
		mergeSort(arr,0,arr.length-1);
	}
	//�����ĵݹ麯��---����˼��
	public static void mergeSort(int[] arr,int L,int R) {
		//��ֹ����
		if(L==R) {
			return;
		}
		//�����е㽫����ֳ���������
		int M = L+((R-L)>>1);
		mergeSort(arr,L,M);
		mergeSort(arr,M+1,R);
		merge(arr,L,M,R);
	}
	//���ź���������������Ҳ������ϳ���������
	public static void merge(int[] arr,int L, int M, int R) {
		int[] help = new int[R-L+1];
		int i = 0;
		int p1 = L;
		int p2 = M+1;
		//����һ�鵽��ͷ����ֹ
		while(p1<=M && p2<=R) {
			help[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
		}
		//��δ��������鸴�ƹ�������������whileѭ���ض�ֻ��ִ��һ��
		while(p1<=M) {
			help[i++] = arr[p1++];
		}
		while(p2<=R) {
			help[i++] = arr[p2++];
		}
		//��help���鸴�ƻ�arr��
		for(int j=0;j<help.length;j++) {
			//����ע���Ǵ���߽翪ʼ�����Ǵ������0������ʼ
			arr[L+j] = help[j];
		}
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
