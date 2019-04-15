package d2_1954_snailNumber;

import java.util.Scanner;

public class MyCode {
	static int[] dj = {1, 0, -1, 0};
	static int[] di = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		while(T++<testCase) {
			int N = sc.nextInt();
			
			int[][] map = new int[N][N];
			int dir = 0; // 0:오른 1:아래 2:왼쪽 3:위
			// 청소기처럼 방향을 움직이게?
			int i=0; 
			int j=0;
			int num=1;
			int max = N*N;
			while(num<=max) {
				map[i][j] = num;
				num++;
				
				if(i+di[dir]>=N || i+di[dir]<0 || j+dj[dir] >=N || j+dj[dir]<0 || map[i+di[dir]][j+dj[dir]] !=0) {
					dir = (dir+1)%4;
				}
				i = i+di[dir];
				j = j+dj[dir];
			}
			
			System.out.println("#"+T);
			for(int a=0; a<N; a++) {
				for(int b=0; b<N; b++) {
					System.out.print(map[a][b]+" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
