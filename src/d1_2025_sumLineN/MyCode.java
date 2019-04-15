package d1_2025_sumLineN;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum=0;
		for(int i=1; i<=num; i++) {
			sum+=i;
		}
		System.out.println(sum);
		sc.close();
	}
}
