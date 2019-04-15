package d4_7465_villageGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class MyCode {
	static int N, M;
	static boolean[][] known;
	static boolean[] check;
	static List<Pair> list;
	static Queue<Integer> q;
	static Set<Integer> set;
	static List<Set> group;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T = 0;
		while (T++ < testCase) {
			N = sc.nextInt();
			M = sc.nextInt();
			list = new ArrayList<>();
			for(int i=0; i<M; i++) {
				list.add(new Pair(sc.nextInt(), sc.nextInt()));
			}

			known = new boolean[N + 1][N + 1];
			for (int i = 0; i < list.size(); i++) {
				known[list.get(i).i][list.get(i).j] = true;
				known[list.get(i).j][list.get(i).i] = true;
			} // 방향성이 없으므로 둘 다 체크
			check = new boolean[N + 1];

			group = new ArrayList<>();

			bfs(1);
			
			int ans = group.size();
			System.out.println("#"+T+" "+ans);
		}
		sc.close();
	}

	public static void bfs(int person) {
		set = new HashSet<>();
		q = new LinkedList<>();

		q.add(person);
		while (!q.isEmpty()) {
			int p = q.poll();
			if (check[p] == false) {
				check[p] = true;
				set.add(p);
				for (int j = 1; j <= N; j++) {
					if (known[p][j] == true) {
						q.add(j);
					}
					
				}
			}
		}
		
		// 연관된 인물들의 고리가 끝났을 때..
		group.add(set);
		
		for(int i=1; i<=N; i++) {
			if(check[i]==false) {
				bfs(i);
				return;
			}
		}
		
		// 이곳까지 왔다는 것은 모두 체크했다는 뜻
		// return 값이 void 이므로 다른 처리가 필요 없을 듯
		

	}

}

class Pair {
	int i, j;

	public Pair(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
