package d2_2005_pascalTriangle;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T = 0;
		while(T++<testCase) {
			int N = sc.nextInt();
			int[][] p = new int[N][N];
			
			System.out.println("#"+T);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(j>i) {
						System.out.println();
						break;
					}
					if(j==0 || i==j) {
						p[i][j] = 1;
						System.out.print(p[i][j]+" ");
					}
					else {
						p[i][j] = p[i-1][j-1] + p[i-1][j];
						System.out.print(p[i][j]+" ");
					}
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
