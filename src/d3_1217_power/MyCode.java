package d3_1217_power;

import java.util.Scanner;

// 거듭제곱을 재귀호출을 이용하여 구현할 것ㄹ
public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase=10;
		int T=0; 
		while(T++<testCase) {
			sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			// N을 M번 곱해야 한다
			
			int ans = power(N,M);
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
	
	public static int power(int n, int m) {
		m--;
		if(m==0) {
			return n;
		}
		else {
			return n * power(n,m);
		}
		
	}
}
