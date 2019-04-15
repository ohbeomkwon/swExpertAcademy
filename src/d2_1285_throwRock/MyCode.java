package d2_1285_throwRock;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		int flag = 0;
		while(T++<testCase) {
			int N = sc.nextInt();
			int[] rock = new int[N];
			for(int i=0; i<N; i++) {
				rock[i] = sc.nextInt();
			}
			
			int min = Integer.MAX_VALUE;
			int people=0;
			for(int i=0; i<N; i++) {	// 가장 작은거리 찾기
				min = Math.min(min,Math.abs(flag-rock[i]));
				rock[i] = Math.abs(rock[i]);	//부호 제거
			}
			for(int i=0; i<N; i++) {
				if(min==rock[i]) {
					people++;
				}
			}
			System.out.println("#"+T+" "+min+" "+people);
		}
		sc.close();
	}
}
