package d3_1206_view;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		int T=0;
		while(T++<testCase) {
			int N = sc.nextInt();		// 가로의 길이
			int[] B = new int[N];
			for(int i=0; i<N; i++) {
				B[i] = sc.nextInt();
			}
			
			int ans =0;
			// 좌우 두칸씩 나보다 작은가
			for(int i=2; i<N-2; i++) {
				int now = B[i];
				int left2 = B[i-2];
				int left1 = B[i-1];
				int right1 = B[i+1];
				int right2=B[i+2];
				if(left2<now && left1<now && right1<now && right2<now) {
					ans += Math.min(Math.min(now-right1, now-right2),Math.min(now-left2, now-left1));
				}
			}
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
}
