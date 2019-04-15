package d2_1926_simple369Game;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		for(int i=1; i<=N; i++) {
			int portion=i;
			int remainer=-1;
			while(true) {
				remainer = portion%10;
				portion = portion/10;
				if(remainer==3 || remainer==6 || remainer==9) {
					sb.append("-");
				}
				if(portion==0) break;
			}
			if(sb.toString().isEmpty()) {
				System.out.print(i+" ");
			}
			else {
				System.out.print(sb.toString()+" ");
			}
			sb.setLength(0); // stringbuilder 초기화
		}
		
		sc.close();
	}
}
