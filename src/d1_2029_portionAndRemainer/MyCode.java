package d1_2029_portionAndRemainer;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase= sc.nextInt();
		int T=0; 
		while(T++<testCase) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int portion = a/b;
			int remainer = a%b;
			
			System.out.println("#"+T+" "+portion+" "+remainer);
		}
		sc.close();
	}
}
