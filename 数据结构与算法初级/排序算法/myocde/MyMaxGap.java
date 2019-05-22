package class01;

import java.util.Arrays;

public class MyMaxGap {
	
	public static int maxGap(int[] arr) {
		//���ֻ��һ��������0
		if(null==arr || arr.length<=1) {
			return 0;
		}
		//���������е����ֵ����Сֵ
		int len = arr.length;
		int max = arr[0];
		int min = arr[0];
		for(int i=0;i<len;i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		//˵���������鶼��һ������
		if(max == min) {
			return 0;
		}
		//����Ͱ����������
		boolean[] hasNum = new boolean[len+1];
		int[] maxs = new int[len+1];
		int[] mins = new int[len+1];
		//�����������鿪ʼװͰ
		for(int i=0;i<len;i++) {
			//���жϸ��������ĸ�Ͱ
			int bid = bucket(arr[i],len,min,max);
			//���ж�Ͱ�������ֵ��û��û�еĻ�ֱ�ӽ�arr[i]���룬�еĻ��Ա�һ�£���������
			maxs[bid] = hasNum[bid]?Math.max(maxs[bid], arr[i]):arr[i];
			mins[bid] = hasNum[bid]?Math.min(mins[bid], arr[i]):arr[i];
			hasNum[bid] = true;	
		}
		//������������Ͱ������ֵ
		int res = 0;
		int lastMax = maxs[0];
		//�ӵ�һ��Ͱ��ʼ�Ƚ�
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
