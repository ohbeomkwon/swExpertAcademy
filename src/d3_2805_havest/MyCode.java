package d3_2805_havest;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		int[][] farm;
		while(T++<testCase) {
			int N = sc.nextInt();
			sc.nextLine();
			farm = new int[N][N];
			for(int i=0; i<N; i++) {
				char[] c = sc.nextLine().trim().toCharArray();
				for(int j=0; j<N; j++) {
					farm[i][j] = c[j]-48;
				}
			}
			
			int start = N/2;
			int amount = 1;
			boolean flag = true;
			int sum=0;
			for(int i=0; i<N; i++) {	// 세로 움직임
				for(int j=start; j<start+amount; j++) {
					sum += farm[i][j];
				}
				if(start==0) {
					flag = !flag;
				}
				if(flag) {
					amount+=2;
					start--;
				}
				else {
					amount-=2;
					start++;
				}
			}
			
			System.out.println("#"+T+" "+sum);
			
		}
		sc.close();
	}
}
