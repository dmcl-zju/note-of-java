package class03;

public class MyFindNum {

	 public static boolean isContains(int[][] arr,int num) {
		 if(null == arr) {
			 return false;
		 }
		 int row = arr.length-1;
		 int col = 0;
		 while(row>=0&&col<arr[0].length-1) {
			 if(arr[row][col]==num) {
				 return true;
			 }else if(arr[row][col]>num){
				 row--;
			 }else {
				 col++;
			 }
		 }
		 return false;
	 }
	 
	 public static void main(String[] args) {
			int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
					{ 10, 12, 13, 15, 16, 17, 18 },// 1
					{ 23, 24, 25, 26, 27, 28, 29 },// 2
					{ 44, 45, 46, 47, 48, 49, 50 },// 3
					{ 65, 66, 67, 68, 69, 70, 71 },// 4
					{ 96, 97, 98, 99, 100, 111, 122 },// 5
					{ 166, 176, 186, 187, 190, 195, 200 },// 6
					{ 233, 243, 321, 341, 356, 370, 380 } // 7
			};
			int K = 233;
			System.out.println(isContains(matrix, K));
		}
}
