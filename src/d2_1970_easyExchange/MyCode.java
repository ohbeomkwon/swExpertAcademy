package d2_1970_easyExchange;

import java.util.Scanner;


//	거스름돈 거슬러주기
//	거슬러주어야 할 돈(N)이 입력된다
// 사용하는 돈은 50000원 10000원 5000원 1000원 5000원 100원 50원 10원
// 각 단위별로 사용해야하는 돈의 갯수를 구하시오
public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T =0; 
		int[] money = {50000,10000,5000,1000,500,100,50,10};
		while(T++<testCase) {
			int N = sc.nextInt();		// 거슬러주어야 하는 돈 (10<=N<=1000000)
			int[] exchange = new int[money.length];
			for(int i=0; i<money.length; i++) {
				exchange[i] = N/money[i];
				N = N%money[i];
			}
			
			System.out.println("#"+T);
			for(int i=0; i<exchange.length; i++) {
				System.out.print(exchange[i]+" ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
