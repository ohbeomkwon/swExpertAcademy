package d1_1936_rockScissorsPaper;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		String winner = new String();
		
		if((a-b)==-1 || (a-b)==2) {
			winner = "B";
		}
		else {
			winner = "A";
		}
		
		System.out.println(winner);
		
		sc.close();
	}
}
