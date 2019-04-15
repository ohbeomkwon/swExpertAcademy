package d1_no2068_maximumNumber;

import java.util.Scanner;

public class MyCode {
	static int testCase;
	static int T=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		while(T++<testCase) {
			int max = -1;
			for(int i=0; i<10; i++) {
				int num=sc.nextInt();
				if(num>max) {
					max = num;
				}
			}
			System.out.println("#"+T+" "+max);
		}
		sc.close();
	}
}
