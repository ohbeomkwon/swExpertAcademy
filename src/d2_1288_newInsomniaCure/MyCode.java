package d2_1288_newInsomniaCure;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		boolean[] check;
		while(T++<testCase) {
			int N = sc.nextInt();
			check = new boolean[10];
			
			int ans=0;
			for(int i=1; ; i++) {
				int kN = N*i;
				ans = i;
				while(true) {
					if(kN/10==0) {	// 모든 회전이 끝
						check[kN%10] = true;
						break;
					}
					else {
						check[kN%10] = true;
						kN=kN/10;
					}
				}
				int cnt=0;
				for(int j=0; j<check.length; j++) {
					if(check[j]==false) {	// 방문하지 않은 곳이 있으면 break
						break;
					}
					else {		// 0 - 9까지 다 방문했는지 확인
						cnt++;
					}
				}
				if(cnt==check.length) {
					System.out.println("#"+T+" "+ans*N);
					break;
				}
			}
		}
		sc.close();
	}
}
