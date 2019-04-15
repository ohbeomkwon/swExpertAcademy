package d4_3074_immigration;

import java.util.Scanner;
// 이진탐색 문제
// 입력방식만 좀 다를 뿐 주요코드는 동일하다
public class Solution1 {
	static int N, M, maxTime;
	static int[] time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		while(T++<testCase) {
			N = sc.nextInt();		// 창구 수
			M = sc.nextInt();		// 사람 수
			time = new int[N];
			maxTime=0; // 가장 오래걸리는 창구의 시간을 기록
			for(int i=0; i<N; i++) {
				time[i] = sc.nextInt();
				maxTime = Math.max(maxTime, time[i]);
			}
			
			long ans = binarySearch();
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}
	
	// 이진탐색을 이용하여 풀이
	public static long binarySearch() {
		long left =1;
		long right = maxTime*(long)M; // 가장 오래걸리는 창구로 모두 갈 경우
		long total, mid;
		while(left<=right) {
			mid = (left+right)/2;
			total=0;
			for(int i=0; i<N; i++) {
				total += mid/time[i];
			}
			if(total<M) {
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		return left;
	}
}
