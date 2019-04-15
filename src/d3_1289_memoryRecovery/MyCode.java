package d3_1289_memoryRecovery;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		int T=0; 
		char[] start;
		while(T++<testCase) {
			String s = sc.nextLine().trim();
			char[] goal = s.toCharArray();
			int len = goal.length;
			start = new char[len];
			for(int i=0; i<len; i++) {
				start[i] = '0';
			}
			
			int cnt=0;
			for(int i=0; i<len; i++) {
				if(start[i]!=goal[i]) {
					for(int j=i; j<len; j++) {
						start[j] = goal[i];
					}
					cnt++;
				}
			}
			
			System.out.println("#"+T+" "+cnt);
			
			
			
		}
		sc.close();
	}
}
