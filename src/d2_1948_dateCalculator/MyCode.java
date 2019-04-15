package d2_1948_dateCalculator;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		while(T++<testCase) {
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			
			int ans = 0;
			
			if(m1==m2) {
				ans = d2-d1+1;
			}
			else {
				ans = day[m1]-d1+d2+1;
				for(int i=m1+1; i<m2; i++) {
					ans += day[i];
				}
			}
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
}
