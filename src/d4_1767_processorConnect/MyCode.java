package d4_1767_processorConnect;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0; 
		while(T++<testCase) {
			int N = sc.nextInt();
			int[][] cells = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cells[i][j] = sc.nextInt();
				}
			}
			
			
		}
		sc.close();
	}
}
