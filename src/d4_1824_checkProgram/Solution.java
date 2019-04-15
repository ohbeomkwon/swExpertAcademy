package d4_1824_checkProgram;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int R, C;
	static char[][] command;
	static boolean[][][][] visit;	// dir ram r c 를 넣음
	// 같은 값을 가지고 한번 더 지나가는지를 확인
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static char stop = '@';
	static char rightOrLeft = '_'; // RAM에 있는 값이 0이면 오른쪽, 아니면 왼쪽
	static char upOrDown = '|'; // RAM에 있는 값이 0이면 아래, 아니면 위
	static char plusOne = '+'; // (RAM+1)%16
	static char minusOne = '-'; // {16+(RAM-1)}%16

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T = 0;
		while (T++ < testCase) {
			R = sc.nextInt();
			C = sc.nextInt();
			sc.nextLine();
			
			command = new char[R][C];
			visit = new boolean[4][16][R][C]; // dir 4방향, ram크기가 0-15, r, c
			for (int i = 0; i < R; i++) {
				String s = sc.nextLine();
				char[] c = s.toCharArray();
				for (int j = 0; j < C; j++) {
					command[i][j] = c[j];
				}
			}

			if (bfs()) {
				System.out.println("#" + T + " YES");
			} else {
				System.out.println("#" + T + " NO");
			}

		}
		sc.close();
	}

	public static boolean bfs() {
		Queue<Step> queue = new LinkedList<>();
		Step cur = new Step(0, 0, 0, 0);// 방향, 램, r, c 위치를 넣은 객체생성
		queue.add(cur);
		int dir, ram, r, c;
		char sign;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			dir = cur.dir;
			ram = cur.ram;
			r = cur.r;
			c = cur.c;
			sign = command[r][c];

			if (sign == stop)
				return true;

			if (sign >= '0' && sign <= '9')
				ram = Character.getNumericValue(sign);
			else if (sign == plusOne)
				ram = (ram + 1) % 16;
			else if (sign == minusOne)
				ram = (16 + (ram - 1)) % 16;
			else if (sign == rightOrLeft)
				dir = (ram == 0) ? 0 : 2;
			else if (sign == upOrDown)
				dir = (ram == 0) ? 1 : 3;
			else if (sign == '>')
				dir = 0;
			else if (sign == 'v')
				dir = 1;
			else if (sign == '<')
				dir = 2;
			else if (sign == '^')
				dir = 3;
			
			int nr, nc;
			if(sign=='?') {	// 네 방향을 모두 확인해야 함
				for(int i=0; i<4; i++) {
					if(!visit[i][ram][r][c]) {
						visit[i][ram][r][c] = true;
						nr=(R+(r+dr[i]))%R;
						nc = (C+(c+dc[i]))%C;
						queue.add(new Step(i,ram, nr, nc));
					}
				}
			}
			else {
				if(!visit[dir][ram][r][c]) {
					visit[dir][ram][r][c] = true;
					nr = (R+(r+dr[dir]))%R;
					nc = (C+(c+dc[dir]))%C;
					queue.add(new Step(dir,ram,nr,nc));
				}
			}
		}
		return false;
		
	}
}

class Step {
	public int dir, ram, r, c;

	public Step(int dir, int ram, int r, int c) {
		this.dir = dir;
		this.ram = ram;
		this.r = r;
		this.c = c;
	}
}
