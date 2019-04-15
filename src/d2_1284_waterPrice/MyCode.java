package d2_1284_waterPrice;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		while(T++<testCase) {
			int P = sc.nextInt();		// A사의 리터당 요금
			int Q = sc.nextInt();		// B사의 기본요금
			int R = sc.nextInt();		// B사의 기본사용량
			int S = sc.nextInt();		// B사의 기본용량 이후의 리터당 요금
			int W = sc.nextInt();	// 종민의 한달간 수도사용량
			
			int compA=P*W;
			int compB=0;
			if(W<=R) {
				compB = Q;
			}
			else {
				compB = Q+(W-R)*S;
			}
			
			int ans=0;
			if(compA>=compB) {
				ans = compB;
			}
			else {
				ans = compA;
			}
			
			System.out.println("#"+T+" "+ans);
			
		}
		sc.close();
	}
}
