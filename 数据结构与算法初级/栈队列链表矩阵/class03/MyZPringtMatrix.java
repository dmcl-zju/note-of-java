package class03;

public class MyZPringtMatrix {
	
	public static void printZMatrix(int[][] arr) {
		if(null == arr) {
			return;
		}
		int aR = 0;
		int aC = 0;
		int bR = 0;
		int bC = 0;
		int endR = arr[0].length-1;
		int endC = arr.length-1;
		boolean f = false;
		while(aR<=bR) {
			printLevel(arr,aR,aC,bR,bC,f);
			//跟新上下两个点
			aR = aC<endC?aR:aR+1;
			aC = aC<endC?aC+1:aC;
			bC = bR<endR?bC:bC+1;
			bR = bR<endR?bR+1:bR;
			f = !f;
		}
		System.out.println("");
		
	}
	public static void printLevel(int[][] arr,int aR,int aC,int bR,int bC,boolean f) {
		if(f) {
			//上往下打印
			while(aR<=bR) {
				System.out.print(arr[aR++][aC--]+" ");
			}
		}else {
			//下往上打印
			while(aR<=bR) {
				System.out.print(arr[bR--][bC++]+" ");
			}
		}
	}
	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printZMatrix(arr);
	}
}
