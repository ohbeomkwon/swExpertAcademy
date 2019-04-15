package d3_2806_nQueen_dfs;

import java.util.Scanner;

못풀었음. 참고해서 다시볼 것
//	 N*N 보드에 N개의 퀸을 서로 다른 두 퀸이 공격하지 못하게 놓는 경우의 수
public class MyCode {
	static int N;
	static int success;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		boolean[][] board;
		while(T++<testCase) {
			N = sc.nextInt();
			success = 0;
			board = new boolean[N][N];
			
			dfs(board,0);
			
			System.out.println("#"+T+" "+success);
			
		}
		sc.close();
	}
	
	public static void dfs(boolean[][] board, int cnt) {
		if(cnt==N) {
			success++;
			return;
		}
		boolean[][] b;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j]==false) {
					b = putQueen(board, i,j);
					dfs(b, cnt+1);
				}
				else {
					return;
				}
			}
		}
		
		
	}
	
	public static boolean[][] putQueen(boolean[][] board, int a, int b) {
		// 가로줄
		for(int j=0; j<N; j++) {
			board[a][j] = true;
		}
		// 세로줄
		for(int i=0; i<N; i++) {
			board[i][b] = true;
		}
		// 대각 오른 아래
		for(int i=a, j=b; i<N && j<N; i++, j++) {
			board[i][j] = true;
		}
		// 대각 왼 위
		for(int i=a, j=b; i>=0 && j>=0; i--, j--) {
			board[i][j] = true;
		}
		// 대각 오른 위
		for(int i=a, j=b; i>=0 && j<N; i--, j++) {
			board[i][j] = true;
		}
		// 대각 왼 아래
		for(int i=a, j=b; i<N && j>=0; i++, j--) {
			board[i][j] = true;
		}
		
		return board;
	}
	
}
