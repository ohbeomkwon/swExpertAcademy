package d2_1945_easyFactorization;

import java.util.Scanner;

//	N 을 2 5 7 11로 소인수분해하는 문제
// 각 소인수가 몇개씩 들어가는지 푸는 문제
public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		int[] primeNum = {11, 7, 5, 3, 2};
		while(T++<testCase) {
			int N = sc.nextInt();
			int[] ans = {0,0,0,0,0};
			// 나누어서 나머지가 0이 되지 않을 때 까지 해본다
			for(int i=0; i<primeNum.length; i++) {
				for(int j=1; ; j++) {
					if(N%primeNum[i]==0) {
						ans[i] = j;
						N=N/primeNum[i];
					}
					else {
						break;
					}
				}
			}
			
			System.out.print("#"+T+" ");
			for(int i=ans.length-1; i>=0; i-- ) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			
			
		}
		sc.close();
	}
}
