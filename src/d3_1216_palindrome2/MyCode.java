package d3_1216_palindrome2;

import java.util.Scanner;

// 가장 긴 회문의 길이를 구하는 문제
public class MyCode {
	static int N = 100; // 격자의 크기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		int T = 0;
		while (T++ < testCase) {
			sc.nextInt(); // 테스트케이스 번호
			sc.nextLine();
			String[] s = new String[N];
			char[][] grid = new char[N][N];
			for (int i = 0; i < N; i++) {
				s[i] = sc.nextLine();
			}
			for (int i = 0; i < N; i++) {
				char[] temp = s[i].toCharArray();
				for (int j = 0; j < N; j++) {
					grid[i][j] = temp[j];
				}
			}

			int ans = countPalindrome(grid);
			System.out.println("#" + T + " " + ans);
		}

		sc.close();
	}

	public static int countPalindrome(char[][] grid) {
		int maxLen = -1; // 회문의 최대길이
		// 가로체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j ++) {
				for (int len = N-j; len>0; len--) {
					if(len<=maxLen) break;
					int cnt = 0;
					for (int k = j, l = j + len - 1; k < j + len / 2 && l >= j + len / 2; k++, l--) {
						if (grid[i][k] == grid[i][l]) {
							cnt++;
							if (cnt == len / 2) { // 회문이다!!
								//이전 길이보다 큰지 확인
								maxLen = Math.max(maxLen, len);
							}
						} else {
							break;
						}
					}
				}
			}
		}
		// 세로체크
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i ++) {
				for (int len = N-i; len>0; len--) {
					if(len<=maxLen) break;
					int cnt = 0;
					for (int k = i, l = i + len - 1; k < i + len / 2 && l >= i + len / 2; k++, l--) {
						if (grid[k][j] == grid[l][j]) {
							cnt++;
							if (cnt == len / 2) { // 회문이다!!
								//이전 길이보다 큰지 확인
								maxLen = Math.max(maxLen, len);
							}
						} else {
							break;
						}
					}
				}
			}
		}
		
		return maxLen;
	}
}
