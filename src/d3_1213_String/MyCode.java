package d3_1213_String;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		int T=0;
		while(T++<testCase) {
			T=sc.nextInt();
			sc.nextLine();
			
			String word = sc.nextLine();
			String sen = sc.nextLine();
			int len = word.length();

			int ans = 0;
			while(true) {
				int index = sen.indexOf(word);
				if(index>=0) {
					ans++;
					sen = sen.substring(index+len);
				}
				else {		// 없을 경우
					break;
				}
			}
			
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
}
