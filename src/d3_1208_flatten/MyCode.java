package d3_1208_flatten;

import java.util.Arrays;
import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		int T=0;
		int N = 100;		// 가로길이 또는 숫자의 갯수
		while(T++<testCase) {
			int dump = sc.nextInt();
			int[] boxes = new int[N];
			for(int i=0; i<N; i++) {
				boxes[i] = sc.nextInt();
			}
			for(int i=0; i<dump; i++) {
				Arrays.sort(boxes);
				boxes[0]++;
				boxes[N-1]--;
			}
			Arrays.sort(boxes);
			int ans = boxes[N-1] - boxes[0];
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
}
