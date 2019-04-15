package d3_1491_decoWall;

import java.util.Scanner;

// 연산량을 줄이는 것이 관건
// 필요없는 연산을 걷어주지 않으면 시간이 너무 오래걸린다.
public class MyCode {
	static int N, A, B;
	static long min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0; 
		while(T++<testCase) {
			N = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			min = Long.MAX_VALUE;
			
			int a = (int) Math.sqrt(N)+1;	// 숫자 제한
			for(int i=1; i<a; i++) {
				for(int j=i; j<N; j++) {
					calculate(i,j);
				}
			}
			
			System.out.println("#"+T+" "+min);
			
		}
		sc.close();
	}
	
	public static void calculate(int r, int c) {
		long multi = r*c;
		if(multi>N) return;
		
		long result = (long)A*Math.abs(r-c) + (long)B*(N-(r*c));
		min = Math.min(min, result);
	}
}
