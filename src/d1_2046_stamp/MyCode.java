package d1_2046_stamp;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=0; i<num; i++) {
			System.out.print("#");
		}
		sc.close();
	}
}
