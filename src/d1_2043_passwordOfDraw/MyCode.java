package d1_2043_passwordOfDraw;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int P = sc.nextInt();
		int K = sc.nextInt();
		int ans=0;
		
		if(P>K) {
			ans = P-K+1;
		}
		else if(P<K) {
			ans = 999-K+1+P+1;
		}
		else {
			ans = 1;
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}
