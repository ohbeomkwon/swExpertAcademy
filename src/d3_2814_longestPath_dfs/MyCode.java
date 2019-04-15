package d3_2814_longestPath_dfs;

import java.util.Scanner;
// 참고해서 풀었음
public class MyCode {
	static boolean[][] map;
	static boolean[] visited;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		while(T++<testCase) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			map = new boolean[N+1][N+1];
			visited = new boolean[N+1];
			for(int m=0; m<M; m++) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				map[i][j] = map[j][i] = true;
			}
			
			max=0;
			for(int i=1; i<=N; i++) {
				dfs(i,1);
			}
			System.out.println("#"+T+" "+max);
		}
		
		sc.close();
	}
	
	public static void dfs(int start, int depth) {
		max = Math.max(max, depth);
		visited[start] = true;
		
		for(int i=1; i<map[start].length; i++) {
			if(map[start][i]==true && visited[i]==false) { // 간선이 존재하고 방문한 적이 없을 때
				dfs(i,depth+1);
			}
		}
		
		// 이곳으로 왔다는 것은 방문에 실패한 것이므로
		visited[start] = false;
	}
}
