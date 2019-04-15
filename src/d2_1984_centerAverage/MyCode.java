package d2_1984_centerAverage;

import java.util.Arrays;
import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		int N = 10; // 10개의 수를 입력받음
		int[] nums = new int[N];
		
		while(T++<testCase) {
			for(int i=0; i<N; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			int sum=0;
			for(int i=1; i<N-1; i++) {
				sum += nums[i];
			}
			float ave = (float)sum/(N-2);
			int ans = Math.round(ave);
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
}
