package d4_1486_highRack;

import java.util.Scanner;

// 남의코드 보고 씀
public class MyCode {
	static int N;
	static int B;
	static int[] height;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		while(T++<testCase) {
			N = sc.nextInt();	 	// 직원 수
			B = sc.nextInt();		// 탑의 높이
			height = new int[N];	// 각 직원의 높이
			for(int i=0; i<N; i++) {
				height[i] = sc.nextInt();
			}
			
			min = Integer.MAX_VALUE; // 가장 작게 차이가 나는 키
			dfs(0,0);
			
			System.out.println("#"+T+" "+(min-B));
			
		}
		sc.close();
	}
	
	public static void dfs(int index, int sum) {
		if(sum>=min) return; // 최소값을 구하는 것이므로
		if(sum>=B) {
			min = Math.min(min, sum);
			return; // 더 더해봤자 더 커지기만 하므로
		}
		if(index>=N) return;	
		
		// 해당 인덱스를 선택했을 때
		dfs(index+1, sum+height[index]);
		// 선택하지 않았을 때
		dfs(index+1, sum);
		// 건너뛰는 경우를 만들어서 여러갈래로 뻗게 한다.
	}
}
