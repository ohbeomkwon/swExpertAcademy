package d4_1824_checkProgram;

import java.util.Scanner;

public class MyCode {
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	static char[][] input;
	static int direction;
	static int memory;
	static int ans;
	static int R, C;
	static int[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		while(T++<testCase) {
			R = sc.nextInt();
			C = sc.nextInt();		// R행 C열로 코드가 입력됨
			sc.nextLine();
			input = new char[R][C];
			for(int i=0; i<R; i++) {
				String s = sc.nextLine().trim();
				char[] c = s.toCharArray();
				for(int j=0; j<C; j++) {
					input[i][j] = c[j];
				}
			}
			memory=0;// 메모리에 어떤 수가 들어있는지 체크(0-15)
			direction=0;// 방향을 설정
			ans=0;		// 프로그램이 종료되었는지 확인
			visited = new int[R][C];
			
			checkCode(visited, 0,0);
			
			if(ans>0) {
				System.out.println("#"+T+" "+"YES");
			}
			else {
				System.out.println("#"+T+" "+"NO");
			}
			
		}
		sc.close();
	}
	
	public static int checkCode(int[][] visited, int y, int x) {
		if(ans>0) {
			return ans;
		}
		visited[y][x]++;
		if(visited[y][x]>10) {
			return 0;		// 같은 곳에 10번 이상 방문했으면 no를 외친다.
		}
		
		switch (input[y][x]) {
		case '_':
			if(memory==0)	direction = 0;
			else		direction = 2;
			break;
		case '|':
			if(memory==0)	direction = 1;
			else	direction=3;
			break;
		case '?':
			int[] next= {0,0};
			for(int i=0; i<4; i++) {
				next = nextStep(y,x,i);
				int ny = next[0];
				int nx = next[1];
				direction = i;
				return ans +=checkCode(visited, ny, nx);
			}
			break;
		case '.':
			break;
		case '@': // 프로그램 정지
			ans++;
			break;
		case '>':
			direction = 0;
			break;
		case '<':
			direction=2;
			break;
		case '^':
			direction = 3;
			break;
		case 'v':
			direction = 1;
			break;
		case '+':
			memory = (memory+1)%16;
			break;
		case '-':
			memory = memory-1;
			if(memory<0) memory = 15;
			break;
		default:	// 숫자가 입력될 경우에..
			memory = input[y][x]-48; 
			break;
		}
		
		int nx=0;
		int ny =0;
		int[] next = nextStep(y,x, direction);
		ny=next[0];
		nx = next[1];
		
		return ans+=checkCode(visited, ny,nx);
		
	}
	
	public static int[] nextStep(int y, int x, int direction) {
		int[] next = {0,0};
		if(y+dy[direction]>=C) {
			next[0]=0;
		}
		else if(y+dy[direction]<0) {
			next[0]=C-1;
		}
		else {
			next[0] = y+dy[direction];
		}
		if(x+dx[direction]>=R) {
			next[1] = 0;
		}
		else if(x+dx[direction]<0) {
			next[1] = R-1;
		}
		else {
			next[1] = x+dx[direction];
		}
		
		return next;
	}
	
}
