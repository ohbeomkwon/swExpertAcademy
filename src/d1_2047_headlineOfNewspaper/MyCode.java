package d1_2047_headlineOfNewspaper;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String headline = sc.nextLine();
		int len = headline.length();
		for(int i=0; i<len; i++) {
			sb.append(headline.substring(i, i+1).toUpperCase());
		}
		System.out.println(sb.toString());
		
		sc.close();
	}
}
