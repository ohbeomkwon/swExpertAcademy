package d3_1215_palindrome1;

import java.util.Scanner;

public class MyCode {
	static int N = 8;		// 가로세로배열의 크기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		int T=0;
		while(T++<testCase) {
			int palindrome = sc.nextInt();	// 회문의 길이
			sc.nextLine();
			String[] s = new String[N];
			char[][] grid = new char[N][N];
			for(int i=0; i<N; i++) {
				s[i] = sc.nextLine();
			}
			for(int i=0; i<N; i++) {
				char[] temp = s[i].toCharArray();
				for(int j=0; j<N; j++) {
					grid[i][j] = temp[j];
				}
			}
			// input end
			
			int ans = checkPalindrome(palindrome, grid);
			System.out.println("#"+T+" "+ans);
			
		}// while end
		sc.close();
	}
	
	public static int checkPalindrome(int p, char[][] grid) {
		int len = N-p+1;
		int sum=0;
		int check=p/2;
		// 가로체크
		for(int i=0; i<N; i++) {
			for(int j=0; j<len; j++) {
				int cnt=0;
				for(int k=j, l=j+p-1; k<j+p/2 && l>=j+p/2 ; k++, l--) {
					if(grid[i][k]==grid[i][l]) {
						cnt++;
						if(cnt==check) {
							sum++;
						}
					}
					else 	break;
				}
			}
		}
		// 세로체크
		for(int j=0; j<N; j++) {
			for(int i=0; i<len; i++) {
				int cnt=0;
				for(int k=i, l=i+p-1; k<i+p/2 && l>=i+p/2; k++, l--) {
					if(grid[k][j]==grid[l][j]) {
						cnt++;
						if(cnt==check) {
							sum++;
						}
					}
					else break;
				}
			}
		}
		
		return sum;
	}
	
}
