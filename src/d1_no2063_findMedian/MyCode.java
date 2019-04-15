package d1_no2063_findMedian;

import java.util.Arrays;
import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int median = N/2;
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		System.out.println(nums[median]);
		
		sc.close();
	}
}
