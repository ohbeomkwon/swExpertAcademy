package d2_1959_towNumberArrays;

import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T = 0;
		while (T++ < testCase) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] A;
			int[] B; 
			int[] t1 = new int[N];
			int[] t2 = new int[M];
			for (int i = 0; i < N; i++) {
				t1[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				t2[i] = sc.nextInt();
			}
			
			// B가 항상 크도록 만든다.
			if(N>M) {
				A = t2;
				B = t1;
			}
			else {
				A = t1;
				B = t2;
			}
			
			int ans = makeMax(A, B);
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
	
	public static int makeMax(int[] A, int[] B) {
		int len = B.length - A.length+1;
		int max=Integer.MIN_VALUE;
		for(int k=0; k<len; k++) {
			int sum=0;
			for(int i=0; i<A.length; i++) {
				sum += A[i] * B[i+k];
			}
			max = Math.max(max, sum);
		}
		return max;
	}
}
