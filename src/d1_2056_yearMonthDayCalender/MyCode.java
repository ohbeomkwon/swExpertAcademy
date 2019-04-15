package d1_2056_yearMonthDayCalender;

import java.util.Scanner;

public class MyCode {
	static int testCase;
	static int T=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		while(T++<testCase) {
			int num = sc.nextInt();
			int day = num%100;
			num = num/100;
			int month = num%100;
			num = num/100;
			int year = num;
			
			boolean check = checkCalender(year, month, day);
			String ans;
			if(check) {
				String y = String.format("%04d", year);
				String m = String.format("%02d", month);
				String d = String.format("%02d", day);
				ans = y+"/"+m+"/"+d;
			}
			else {
				ans = "-1";
			}
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
	
	public static boolean checkCalender(int year, int month, int day) {
		if(month<1 || month>12) return false;
		if(day<1 || day>31) return false;
		if(month==2) {
			if(day>28) return false;
			else return true;
		}
		else if(month==4 || month==6 || month==9 || month==11) {
			if(day>30) return false;
			else return true;
		}
		else return true;
	}
}
