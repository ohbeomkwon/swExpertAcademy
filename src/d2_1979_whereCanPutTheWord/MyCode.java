package d2_1979_whereCanPutTheWord;

import java.util.Scanner;

// 가로세로 단어퀴즈에 단어 넣기
// 빈 공백에 칸이 맞는 곳에 단어를 넣을 수 있는지 찾는다.
// 칸수가 딱 맞아야 넣을 수 있다.
// 0과 1로 표시되고 1로 표시된 곳에 단어를 넣을 수 있다.
public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T = 0;
		while (T++ < testCase) {
			int N = sc.nextInt(); // 퍼즐의 가로세로길이
			int K = sc.nextInt(); // 단어의 길이
			int ans = 0; // 결과값.(넣을 수 있는 칸의 갯수)
			int[][] puzzle = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}

			// 가로 탐문
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - K; j++) {
					if (puzzle[i][j] == 0)		continue;
					else {
						if(j==0 || puzzle[i][j-1]==0) {
							int cnt = 0;
							for (int k = j; k < j + K; k++) {
								cnt += puzzle[i][k];
							}
							if (cnt == K) { // 1인 칸과 글자수가 동일
								if (j + K > N - 1 || puzzle[i][j + K] == 0) { // 다음 칸이 0이거나 배열 바깥인 경우
									ans++;
								} 
								else	continue;		// 다음칸이 1인 경우
							} 
							else	continue;
						}
						else	continue;
					}
				}
			}

			// 세로 탐문
			for (int j = 0; j < N; j++) {
				for (int i = 0; i <= N - K; i++) {

					if (puzzle[i][j] == 0)		continue;
					else {
						if(i==0 || puzzle[i-1][j]==0) {
							int cnt = 0;
							for (int k = i; k < i + K; k++) {
								cnt += puzzle[k][j];
							}
							if (cnt == K) { // 1인 칸과 글자수가 동일
								if (i + K > N - 1 || puzzle[i+K][j] == 0) { // 다음 칸이 0이거나 배열 바깥인 경우
									ans++;
								} 
								else	continue;		// 다음칸이 1인 경우
							} 
							else	continue;
						}
						else	continue;
					}
				}
			}
			
			System.out.println("#"+T+" "+ans);
		}// while end

		sc.close();
	}
}
