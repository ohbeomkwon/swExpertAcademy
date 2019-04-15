package d2_1974_sudokuVerification;

import java.util.Scanner;

// 스도쿠 검증
// 주어진 스도쿠가 맞는지 틀린지를 검증
// 가로 세로 뿐 아니라 상자모양도 맞는지 검증해야 함.
public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T =0;
		int N = 9; // 스도쿠의 크기
		
		while(T++<testCase) {
			int[][] sudoku = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			int ans = sudokuCheck(N, sudoku);
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
	
	public static int sudokuCheck(int N, int[][] sudoku) {
		boolean[] test;	// 기본이 false
		// 가로탐색
		for(int i=0; i<N; i++) {
			test = new boolean[N+1];
			for(int j=0; j<N; j++) {
				if(test[sudoku[i][j]]) { // 한번 방문했음
					return 0;
				}
				else {
					test[sudoku[i][j]] = !test[sudoku[i][j]];
				}
			}
		}
		// 세로탐색
		for(int j=0; j<N; j++) {
			test = new boolean[N+1];
			for(int i=0; i<N; i++) {
				if(test[sudoku[i][j]]) { // 한번 방문했음
					return 0;
				}
				else {
					test[sudoku[i][j]] = !test[sudoku[i][j]];
				}
			}
		}
		// 3x3 상자로 탐색
		for(int i=0; i<N; i+=3) {
			for(int j=0; j<N; j+=3) {
				test = new boolean[N+1];
				for(int k=i; k<i+3; k++) {
					for(int l=j; l<j+3; l++) {
						if(test[sudoku[k][l]]) { // 한번 방문했음
							return 0;
						}
						else {
							test[sudoku[k][l]] = !test[sudoku[k][l]];
						}
					}
				}
			}
		}
		return 1;
	}
}
