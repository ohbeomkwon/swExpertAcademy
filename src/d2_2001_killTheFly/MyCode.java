package d2_2001_killTheFly;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T = 0;
		while(T++<testCase) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] wall = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					wall[i][j] = sc.nextInt();
				}
			}
			int ans = maxKiller(M, wall);
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
	public static int maxKiller(int M, int[][] wall) {
		int deadFlys = 0;
		int len = wall.length-M+1;
		for(int i=0; i<len; i++) {
			for(int j=0; j<len;j++) {
				int flys = 0;
				for(int k=i; k<i+M; k++) {
					for(int l=j; l<j+M; l++) {
						flys += wall[k][l];
					}
				}
				deadFlys = Math.max(deadFlys, flys);
			}
		}
		return deadFlys;
	}
}
