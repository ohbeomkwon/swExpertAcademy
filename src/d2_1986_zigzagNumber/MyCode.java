package d2_1986_zigzagNumber;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		
		while(T++<testCase) {
			int N = sc.nextInt();
			int sum =0;
			for(int i=1; i<=N; i++) {
				if(i%2==0) {
					sum -= i;
				}
				else {
					sum+=i;
				}
			}
			System.out.println("#"+T+" "+sum);
		}
		sc.close();
	}
}
