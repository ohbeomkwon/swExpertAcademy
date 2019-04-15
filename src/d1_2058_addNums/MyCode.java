package d1_2058_addNums;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int sum=0;
		
		while(N!=0) {
			sum += N%10;
			N = N/10;
		}
		System.out.println(sum);
		
		sc.close();
	}
}
