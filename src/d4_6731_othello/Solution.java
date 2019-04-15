package d4_6731_othello;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		while(T++<testCase) {
			int N = sc.nextInt();
			sc.nextLine();
			boolean[][] othello = new boolean[N][N];		// 오델로의 결과값을 받음
			boolean[] toggleRow = new boolean[N];		// row를 뒤집은 적 있는가
			boolean[] toggleCol = new boolean[N];		// col을 뒤집은 적 있는가
			for(int r=0; r<N; r++) {
				String s = sc.nextLine().trim();
				char[] ch = s.toCharArray();
				for(int c=0; c<N; c++) {
					if(ch[c]=='B') {
						othello[r][c] = true;
						toggleRow[r] = !toggleRow[r];		// 뒤집은 적 있음
						toggleCol[c] = !toggleCol[c];			// 뒤집은 적 있음
					}
				}
			}
			
			// 행과 열의 원판을 뒤집음
			for(int i=0; i<N; i++) {
				if(toggleRow[i]==true) {
					for(int c=0; c<N; c++) {
						othello[i][c] = !othello[i][c];
					}
				}
				if(toggleCol[i]==true) {
					for(int r=0; r<N; r++) {
						othello[r][i] = !othello[r][i];
					}
				}
			}
			
			// 결과값 : 총 몇개의 원판을 뒤집어야 하는지 세기
			int flipCnt=0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(othello[r][c]==true) {
						flipCnt++;
					}
				}
			}
			
			System.out.println("#"+T+" "+flipCnt);
			
		}
		sc.close();
	}
}
