package d3_6913_programmingTest;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0; 
		while(T++<testCase) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] score = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					score[i][j] = sc.nextInt();
				}
			}
			
			int firstPrize=0;	// 1등이 몇명?
			int firstScore=0;	// 1등은 몇점?
			
			for(int i=0; i<N; i++) {
				int sum=0;
				for(int j=0; j<M; j++) {
					sum += score[i][j];
				}
				if(sum>firstScore) {
					firstScore = sum;
					firstPrize=1;
				}
				else if(sum==firstScore) {
					firstPrize++;
				}
			}
			
			System.out.println("#"+T+" "+firstPrize+" "+firstScore);
			
		}
		sc.close();
	}
}
