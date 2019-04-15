package d1_2019_doubleDouble;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int start = 1;
		System.out.print(start+" ");
		for(int i=0; i<num; i++) {
			start *=2;
			System.out.print(start+" ");
		}
		sc.close();
	}
}
