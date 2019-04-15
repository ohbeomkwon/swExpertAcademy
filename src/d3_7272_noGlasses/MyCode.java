package d3_7272_noGlasses;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		sc.nextLine();
		while(T++<testCase) {
			String line = sc.nextLine().trim();
			String[] s = line.split(" ");
			
			
			String ans="DIFF";
			// 먼저 길이가 같은지 본다.
			if(s[0].length()!=s[1].length()) {
				System.out.println("#"+T+" "+ans);
				continue;
			}
			
			// 길이가 같다면 내용이 같은지 본다.
			String s0 = checkSpell(s[0]);
			String s1 = checkSpell(s[1]);
			if(s0.equals(s1)) {
				ans = "SAME";
			}
			else {
				ans = "DIFF";
			}
			System.out.println("#"+T+" "+ans);
			
		}
		sc.close();
	}
	
	public static String checkSpell(String s) {
		StringBuilder sb = new StringBuilder();
		char[] spell = s.toCharArray();
		for(int i=0; i<spell.length; i++) {
			sb.append(change(spell[i]));
		}
		
		String reSpell = sb.toString();
		return reSpell;
		
	}
	public static char change(char c) {
		char result;
		switch(c) {
		case 'B':
			result = 'B';
			break;
		case 'A':
		case 'D':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
			result = 'A';
			break;
		default:
			result = 'C';
			break;
		}
		return result;
	}
}
