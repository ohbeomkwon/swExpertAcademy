package d2_1940_goRCcar;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		
		while(T++<testCase) {
			int N = sc.nextInt();
			int[] distance = new int[N+1];
			int[][] command = new int[N][2];
			for(int i=0; i<N; i++) {
				for(int j=0; j<2; j++) {
					command[i][j] = sc.nextInt();
					if(command[i][j]==0) break;
				}
			}
			
			for(int i=0; i<N; i++) {
				if(command[i][0]==1) {		// 가속
					distance[i+1] = distance[i]+command[i][1];
				}
				else if(command[i][0]==2) {	//감속
					distance[i+1] = distance[i]-command[i][1];
					if(distance[i+1]<0) {
						distance[i+1] = 0;
					}
				}
				else {
					distance[i+1] = distance[i];
				}
			}
			
			int ans=0;
			for(int i=0; i<distance.length; i++) {
				ans += distance[i];
			}
			
			System.out.println("#"+T+" "+ans);
			
		}
		sc.close();
	}
}
