package d1_no2071_findAverage;

import java.util.Scanner;

// 2071 편균값구하기

public class MyCode {
	static int testCase;
	static float N=10;
	static float ave;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		int T=0;
		while(T++<testCase) {
			int sum=0;
			for(int i=0; i<N; i++) {
				int num = sc.nextInt();
				sum += num;
			}
			ave = sum/N;
			System.out.println("#"+T+" "+Math.round(ave));
		}
	}
}
