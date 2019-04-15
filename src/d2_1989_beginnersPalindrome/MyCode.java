package d2_1989_beginnersPalindrome;

import java.util.Scanner;

// 초심자의 회문검사. !!!하나의 단어가 주어진다!!!!
public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		int T = 0;
		while(T++<testCase) {
			String word = sc.nextLine().trim();
			char[] cut = word.toCharArray();
			int end = word.length()-1;
			int len = word.length();
			int half = len/2;
			int ans=1;
			for(int i=0; i<=half; i++) {
				char a = cut[i];
				char b = cut[end-i];
				if(cut[i]!=cut[end-i]) {
					ans = 0;
					break;
				}
			}
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
}
