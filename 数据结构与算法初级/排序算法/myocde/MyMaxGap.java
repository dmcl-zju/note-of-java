package class01;

import java.util.Arrays;

public class MyMaxGap {
	
	public static int maxGap(int[] arr) {
		//如果只有一个数返回0
		if(null==arr || arr.length<=1) {
			return 0;
		}
		//先求数组中的最大值和最小值
		int len = arr.length;
		int max = arr[0];
		int min = arr[0];
		for(int i=0;i<len;i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		//说明整个数组都是一样的数
		if(max == min) {
			return 0;
		}
		//定义桶的三个变量
		boolean[] hasNum = new boolean[len+1];
		int[] maxs = new int[len+1];
		int[] mins = new int[len+1];
		//遍历整个数组开始装桶
		for(int i=0;i<len;i++) {
			//先判断该数属于哪个桶
			int bid = bucket(arr[i],len,min,max);
			//先判断桶中有最大值了没，没有的话直接将arr[i]放入，有的话对比一下，找最大放入
			maxs[bid] = hasNum[bid]?Math.max(maxs[bid], arr[i]):arr[i];
			mins[bid] = hasNum[bid]?Math.min(mins[bid], arr[i]):arr[i];
			hasNum[bid] = true;	
		}
		//接下来算相邻桶的最大差值
		int res = 0;
		int lastMax = maxs[0];
		//从第一个桶开始比较
		for(int i=1;i<=len;i++) {
			if(hasNum[i]) {
				res = Math.max(res, mins[i]-lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}
	public static int bucket(int num,int len, int min, int max) {
		int bid = (int)((num-min)*len/(max-min));
		return bid;
	}
	
	// for test
	public static int comparator(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		Arrays.sort(nums);
		int gap = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			gap = Math.max(nums[i] - nums[i - 1], gap);
		}
		return gap;
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
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			if (maxGap(arr1) != comparator(arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}
}
