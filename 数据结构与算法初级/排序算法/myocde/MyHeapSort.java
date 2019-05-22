package class01;

import java.util.Arrays;

public class MyHeapSort {
	
	public static void heapSort(int[] arr) {
		if(null==arr || arr.length<=1) {
			return;
		}
		//将数组元素建堆
		for(int i=0;i<arr.length;i++) {
			heapInsert(arr,i);
		}
		//将大根堆的堆顶取出,依次从后往前放达到排序目的
		int size = arr.length;
		//swap(arr,0,--size);
		while(size>0) {
			//和最后一个位置交换,并缩小堆
			swap(arr,0,--size);
			//将改变了顶位置的堆恢复成大根堆
			heapify(arr,0,size);
			
		}
		
	}
	//在堆里面添加元素
	public static void heapInsert(int[] arr,int index) {
		//当新加入的子节点比父节大的时候
		while(arr[index]>arr[(index-1)/2]) {
			swap(arr,index,(index-1)/2);
			index = (index-1)/2;
		}
	}
	//对堆中的一个元素进行沉底
	public static void heapify(int[] arr,int index, int heapSize) {
		//获取该元素的左子节点
		int left = index*2+1;
		//保证左子节点在堆中吗
		while(left<heapSize) {
			//找到孩子中的最大值
			int large = left;
			if((left+1)<heapSize && arr[left]<arr[left+1]) {
				large = left+1;
			}
			//和孩子最大值比较
			if(arr[index]<arr[large]) {
				swap(arr,index,large);
				//更新当前索引
				index = large;
				left = index*2+1;
			}else {
				//如果当前值比孩子都大,那就跳出循环
				break;
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
