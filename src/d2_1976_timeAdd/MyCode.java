package d2_1976_timeAdd;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		int T = 0;
		while(T++<testCase) {
			int hour = 0;
			int minute = 0;
			for(int i=0; i<2; i++) {
				hour += sc.nextInt();
				minute += sc.nextInt();
			}
			
			int extra = minute/60;
			minute = minute%60;
			hour +=extra;
			hour = hour%12;
			if(hour==0) {
				hour = 12;
			}
			
			System.out.println("#"+T+" "+hour+" "+minute);
			
		}// while end
		
		
		sc.close();
	}
}
