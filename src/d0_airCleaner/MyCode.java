package d0_airCleaner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MyCode {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int W, H, S;
	static Queue<Dust> q;
	static int[][] room;
	static List<Dust> cleaner;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T = 0;
		while (T++ < testCase) {
			W = sc.nextInt(); // 가로
			H = sc.nextInt(); // 세로
			S = sc.nextInt(); // 소요시간(초)

			room = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					room[i][j] = sc.nextInt();
				}
			}

			q = new LinkedList<>();
			cleaner = new ArrayList<>();
			
			bfs(0);
			
			int ans = 2;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					ans += room[i][j]; 
				}
			}
			
			System.out.println("#"+T+" "+ans);
			
		}
		sc.close();
	}

	public static void bfs(int s) {
		if (s == S) {
			return;
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (room[i][j] > 0) {
					q.add(new Dust(i, j, room[i][j]));
				} else if (room[i][j] < 0) {
					cleaner.add(new Dust(i, j, room[i][j]));
				}
			}
		}

		while (!q.isEmpty()) {
			Dust d = q.poll();
			int i = d.i;
			int j = d.j;
			int myDust = d.dust;

			int dust = myDust / 5; // room[i][j]의 먼지량
			int cnt = 0;

			if (i == 0 && j == 0) {
				for (int c = 0; c < 4; c++) {
					if (c == 2 || c == 3)
						continue;
					room[i + dr[c]][j + dc[c]] += dust;
					cnt++;
				}
			} else if (i == 0 && j == W - 1) {
				for (int c = 0; c < 4; c++) {
					if (c == 0 || c == 3)
						continue;
					room[i + dr[c]][j + dc[c]] += dust;
					cnt++;
				}
			} else if (i == H - 1 && j == 0) {
				for (int c = 0; c < 4; c++) {
					if (c == 1 || c == 2)
						continue;
					room[i + dr[c]][j + dc[c]] += dust;
					cnt++;
				}
			} else if (i == H - 1 && j == W - 1) {
				for (int c = 0; c < 4; c++) {
					if (c == 0 || c == 1)
						continue;
					room[i + dr[c]][j + dc[c]] += dust;
					cnt++;
				}
			} else if (i == 0) {
				for (int c = 0; c < 4; c++) {
					if (c == 3)
						continue;
					room[i + dr[c]][j + dc[c]] += dust;
					cnt++;
				}
			} else if (i == H - 1) {
				for (int c = 0; c < 4; c++) {
					if (c == 1)
						continue;
					room[i + dr[c]][j + dc[c]] += dust;
					cnt++;
				}
			} else if (j == 0) {
				for (int c = 0; c < 4; c++) {
					if (c == 2)
						continue;
					room[i + dr[c]][j + dc[c]] += dust;
					cnt++;
				}
			} else if (j == W - 1) {
				for (int c = 0; c < 4; c++) {
					if (c == 0)
						continue;
					room[i + dr[c]][j + dc[c]] += dust;
					cnt++;
				}
			} else {
				for (int c = 0; c < 4; c++) {
					room[i + dr[c]][j + dc[c]] += dust;
					cnt++;
				}
			}

			room[i][j] = myDust - (dust * cnt); // 퍼진 먼지 빼기

			for (int c = 0; c < 2; c++) {
				room[cleaner.get(c).i][cleaner.get(c).j] = cleaner.get(c).dust;
			} // 공기청정기 원상복구
		}	// 먼지 퍼짐 종료
		
		// 먼지 회전 시작
		// 위쪽 회전
		int dir = 3;
		int pi = cleaner.get(0).i + dr[dir];
		int pj = cleaner.get(0).j + dc[dir];
		while (true) {
			if ((pi == 0 && pj == 0) || (pi == 0 && pj == W - 1) || (pi == cleaner.get(0).i && pj == W - 1)) {
				dir = (dir + 1) % 4;
			}
			if (pi == cleaner.get(0).i && pj == cleaner.get(0).j + 1) {
				room[pi][pj] = 0;
				break;
			} else {
				room[pi][pj] = room[pi + dr[dir]][pj + dc[dir]];
				pi = pi + dr[dir];
				pj = pj + dc[dir];
			}
		}// 위쪽 회전 쫑료
		// 아래쪽 회전 시작
		dir = 1;
		pi = cleaner.get(1).i + dr[dir];
		pj = cleaner.get(1).j + dc[dir];
		while (true) {
			if ((pi == H - 1 && pj == 0) || (pi == H - 1 && pj == W - 1) || (pi == cleaner.get(1).i && pj == W - 1)) {
				dir = (4 + dir - 1) % 4;
			}
			if (pi == cleaner.get(1).i && pj == cleaner.get(1).j + 1) {
				room[pi][pj] = 0;
				break;
			} else {
				room[pi][pj] = room[pi + dr[dir]][pj + dc[dir]];
				pi = pi + dr[dir];
				pj = pj + dc[dir];
			}
		}// 아래쪽 회전 종료
		
		s++;
		bfs(s);
	}
}

class Dust {
	int i, j, dust;

	public Dust(int i, int j, int dust) {
		this.i = i;
		this.j = j;
		this.dust = dust;
	}
}
