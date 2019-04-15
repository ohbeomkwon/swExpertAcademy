package d1_no2070_bigOneSmallOneSameOne;

import java.util.Scanner;

public class MyCode {
	static int testCase;
	static int T=0;
	static String ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		while(T++<testCase) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			ans = Compair(x,y);
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
	
	public static String Compair(int x, int y) {
		if(x<y) return "<";
		else if(x>y) return ">";
		else return "=";
	}
}
