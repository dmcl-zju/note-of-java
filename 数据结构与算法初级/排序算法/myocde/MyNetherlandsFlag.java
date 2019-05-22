package class01;

public class MyNetherlandsFlag {
	
	//partition�Ĺ���
	public static int[] partition(int[] arr,int L,int R, int N) {
		int less = L-1;
		int more = R+1;
		int cur = L;
		while(cur<more) {
			if(arr[cur]<N) {
				//��С��Ŀ��ֵ��ʱ�򣬼���С��������һ��ֵ������С�����䣬cur����ƶ�
				swap(arr,++less,cur++);
			}else if(arr[cur]>N) {
				//������Ŀ��ʱ�򣬼�����������ǰһ��ֵ������������䣬cur����ԭ���ǲ�֪��������������״�������ȴ���һ��ѭ���ж�
				swap(arr,--more,cur);
			}else {
				//�����ڵ����cur����ƶ�
				cur++;
			}
		}
		int[] p= {less+1,more-1};
		return p;
	}
	public static void swap(int[] arr,int i,int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	public static void main(String[] args) {
		int[] arr = {8,4,6,7,2,5,15,5,5,5};
		partition(arr,0,arr.length-1,5);
		for(int a:arr) {
			System.out.print(a+" ");
		}
	}
}
