package d2_1966_sortNumber;

import java.util.Arrays;
import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T =0;
		int[] nums;
		while(T++<testCase) {
			int N = sc.nextInt();
			nums = new int[N];
			for(int i=0; i<N; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			
			System.out.print("#"+T+" ");
			for(int i=0; i<nums.length; i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
