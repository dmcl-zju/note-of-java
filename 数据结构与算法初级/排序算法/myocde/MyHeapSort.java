package class01;

import java.util.Arrays;

public class MyHeapSort {
	
	public static void heapSort(int[] arr) {
		if(null==arr || arr.length<=1) {
			return;
		}
		//������Ԫ�ؽ���
		for(int i=0;i<arr.length;i++) {
			heapInsert(arr,i);
		}
		//������ѵĶѶ�ȡ��,���δӺ���ǰ�Ŵﵽ����Ŀ��
		int size = arr.length;
		//swap(arr,0,--size);
		while(size>0) {
			//�����һ��λ�ý���,����С��
			swap(arr,0,--size);
			//���ı��˶�λ�õĶѻָ��ɴ����
			heapify(arr,0,size);
			
		}
		
	}
	//�ڶ��������Ԫ��
	public static void heapInsert(int[] arr,int index) {
		//���¼�����ӽڵ�ȸ��ڴ��ʱ��
		while(arr[index]>arr[(index-1)/2]) {
			swap(arr,index,(index-1)/2);
			index = (index-1)/2;
		}
	}
	//�Զ��е�һ��Ԫ�ؽ��г���
	public static void heapify(int[] arr,int index, int heapSize) {
		//��ȡ��Ԫ�ص����ӽڵ�
		int left = index*2+1;
		//��֤���ӽڵ��ڶ�����
		while(left<heapSize) {
			//�ҵ������е����ֵ
			int large = left;
			if((left+1)<heapSize && arr[left]<arr[left+1]) {
				large = left+1;
			}
			//�ͺ������ֵ�Ƚ�
			if(arr[index]<arr[large]) {
				swap(arr,index,large);
				//���µ�ǰ����
				index = large;
				left = index*2+1;
			}else {
				//�����ǰֵ�Ⱥ��Ӷ���,�Ǿ�����ѭ��
				break;
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
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			heapSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}
}
