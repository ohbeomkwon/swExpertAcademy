package d3_1221_GNS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyCode {
	static String[] nums= {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	static Map<Integer, String> intMap = new HashMap<>();
	static Map<String, Integer> sMap = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		for(int i=0; i<nums.length; i++) {
			sMap.put(nums[i], i);
			intMap.put(i, nums[i]);
		}
		
		while(T++<testCase) {
			String tc = sc.next();
			int N = sc.nextInt();
			sc.nextLine();
			String[] words = new String[N];
			for(int i=0; i<N; i++) {
				words[i] = sc.next();
			}
			
			// 새로운 비교문을 만들어야 하나?
			// 일단 꼼수로..
			int[] number = new int[N];
			for(int i=0; i<N; i++) {
				number[i] = sMap.get(words[i]);
			}
			Arrays.sort(number);
			String[] ans = new String[N];
			for(int i=0; i<N; i++) {
				ans[i] = intMap.get(number[i]);
			}
			
			System.out.println(tc);
			for(int i=0; i<N; i++) {
				System.out.print(ans[i]+" ");
			}
			
			
		}
		sc.close();
	}
}
