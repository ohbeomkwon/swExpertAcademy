package palindrome1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int testCase = 10;
	static int T=0;
	static String[][] map = new String[8][8];
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(testCase-->0) {
			T++;
			N = Integer.parseInt(in.readLine());
			for(int i=0; i<8; i++) {
				String temp = in.readLine();
				for(int j=0; j<8; j++) {
					map[i][j] = temp.substring(j, j+1);
				}
			}
			
			int ans = 0;
			int hangcheck =0;
			int colcheck = 0;
			for(int i=0; i<8; i++) {
				for(int j=0; j<8-N+1; j++) {
					for(int k=0; k<N/2; k++) {
//                      System.out.print(map[j+k][i]+" ");
//                      System.out.print(map[j-k+(N-1)][i]);
//                      System.out.println();
						if(map[i][j+k].equals(map[i][j-k+(N-1)])) {
							hangcheck++;
						}
						if(map[j+k][i].equals(map[j-k+(N-1)][i])) {
							colcheck++;
						}
					}
					if(hangcheck == N/2) {
						ans++;
					}
					if(colcheck == N/2) {
						ans++;
					}
					hangcheck=0;
					colcheck=0;
				}
			}
			System.out.println("#"+T+" "+ans);
		}
	}
}
