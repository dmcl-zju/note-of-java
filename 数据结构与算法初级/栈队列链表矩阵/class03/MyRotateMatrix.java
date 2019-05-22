package class03;

public class MyRotateMatrix {
	
	public static void rotate(int[][] arr) {
		if(null==arr || (arr.length!=arr[0].length)) {
			return;
		}
		int sR = 0;
		int sC = 0;
		int eR = arr.length-1;
		int eC = arr[0].length-1;
		while(sR<eR) {
			rotateEdge(arr,sR++,sC++,eR--,eC--);
		}
	}
	//转换最外圈--必须是正方形的输入
	public static void rotateEdge(int[][] arr,int sR,int sC,int eR,int eC) {
		//确定循环的次数
		int times = eC-sC;
		int temp = 0;
		for(int i=0;i<times;i++) {
			temp = arr[sR][sC+i];
			arr[sR][sC+i] = arr[eR-i][sC];
			arr[eR-i][sC] = arr[eR][eC-i];
			arr[eR][eC-i] = arr[sR+i][eC];
			arr[sR+i][eC] = temp;
		}
		
	}
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		printMatrix(matrix);
		rotate(matrix);
		System.out.println("=========");
		printMatrix(matrix);

	}
}
