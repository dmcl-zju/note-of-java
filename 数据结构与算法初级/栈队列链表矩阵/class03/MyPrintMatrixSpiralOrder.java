package class03;

public class MyPrintMatrixSpiralOrder {
	
	public static void spiralOrder(int[][] arr) {
		if(null == arr) {
			return;
		}
		int sR = 0;
		int sC = 0;
		int eR = arr.length-1;
		int eC = arr[0].length-1;
		while(sR<=eR&&sC<=eC) {
			printEdge(arr,sR++,sC++,eR--,eC--);
		}
	}
	
	public static void printEdge(int[][] arr,int sR,int sC,int eR,int eC) {
		if(sR==eR) {
			//ֻ��һ��
			while(sC<=eC) {
				System.out.print(arr[sR][sC++]+" ");
			}
		}else if(sC==eC) {
			//ֻ��һ��
			while(sR<=eR) {
				System.out.print(arr[sR++][sC]+" ");
			}
		}else {
			//�����������תȦ��ӡ
			int curR = sR;
			int curC = sC;
			//��ӡ�ϱ�
			while(curC<eC) {
				System.out.print(arr[curR][curC++]+" ");
			}
			//��ӡ�ұ�
			while(curR<eR) {
				System.out.print(arr[curR++][curC]+" ");
			}
			//��ӡ�±�
			while(curC>sC) {
				System.out.print(arr[curR][curC--]+" ");
			}
			//��ӡ���
			while(curR>sR) {
				System.out.print(arr[curR--][curC]+" ");
			}
			
		}
	}
	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		spiralOrder(arr);
	}
}
