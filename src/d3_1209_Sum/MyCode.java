package d3_1209_Sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		int T = 0;
		int N = 100;
		while (T++ < testCase) {
			sc.nextInt(); // 케이스번호
			int[][] cube = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cube[i][j] = sc.nextInt();
				}
			}

			List<Integer> list = new ArrayList<>();
			// 가로합
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += cube[i][j];
				}
				list.add(sum);
			}
			// 세로합
			for (int j = 0; j < N; j++) {
				int sum = 0;
				for (int i = 0; i < N; i++) {
					sum += cube[i][j];
				}
				list.add(sum);
			}
			// 대각합
			{
				int sum=0;
				for (int i = 0; i < N; i++) {
					sum += cube[i][i];
				}
				list.add(sum);
			}
			{
				int sum=0; 
				for(int i=N-1, j=0; i>=0 || j<N; i--, j++) {
					sum+=cube[i][j];
				}
				list.add(sum);
			}
			
			int max = Integer.MIN_VALUE;
			for(int a : list) {
				max = Math.max(max, a);
			}
			
			System.out.println("#"+T+" "+max);

		}
		sc.close();
	}
}
