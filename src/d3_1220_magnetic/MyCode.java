package d3_1220_magnetic;

import java.util.Scanner;

public class MyCode {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		int T = 0;
		while (T++ < testCase) {
			N = sc.nextInt(); // 정사각형 테이블의 크기
			int[][] table = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			} // 1은 N극 2는 S극. table 위쪽은 N극 아래쪽은 S극

			// 100회 동안의 이동상황을 한턴씩 찍어보자
//			int cnt = N;
//			int[][] moveEnd = move(cnt, table);
			int[][] moveEnd = moveTable(table);
			int ans = count(moveEnd);
			
			System.out.println("#"+T+" "+ans);
			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(moveEnd[i][j]+" ");
//				}
//				System.out.println();
//			}
			
		}
		sc.close();
	}
	
	public static int[][] moveTable(int[][] table) {
		// N극 이동 아래부터 위로 올라옴
		for(int i=N-1; i>=0; i--) {
			for(int j=0; j<N; j++) {
				if(table[i][j]==1) {
					table[i][j] = 0;
					// 아래로 갈 수 있는지 확인한다.
					for(int k=i+1; k<N; k++) {
						if(table[k][j]==2 || table[k][j]==1) {// 어디선가 부딫히면.. 바로 윗칸에 1을 둔다
							table[k-1][j]=1;
							break;
						}
					}
				}
			}
		}
		
		// S극 이동 위에서부터 아래로..
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(table[i][j]==2) {
					table[i][j] = 0;
					//위로 갈 수 있는지 확인
					for(int k=i-1; k>=0; k--) {
						if(table[k][j]==1 || table[k][j]==2) {
							table[k+1][j] = 2;
							break;
						}
					}
				}
			}
		}
		
		return table;
	}
	
	
	
	
//	public static int[][] move(int cnt, int[][] table) {
//		cnt--;
//		if (cnt < 0) {
//			return table;
//		} 
//		else {
//			int[][] temp = new int[N][N];
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if (table[i][j] == 1) {
//						if (i + 1 < N) {
//							if (table[i + 1][j] == 0 || table[i + 1][j] == 1) {
//								temp[i][j] = 0;
//								temp[i + 1][j] = 1;
//							} else {
//								temp[i][j] = 1;
//							}
//						} else {
//							temp[i][j] = 0;
//						}
//
//					} else if (table[i][j] == 2) {
//						if (i - 1 >= 0) {
//							if (table[i - 1][j] == 0 || table[i - 1][j] == 2) {
//								temp[i][j] = 0;
//								temp[i-1][j] = 2;
//							} else {
//								temp[i][j] = 2;
//							}
//						} else {
//							temp[i][j] = 0;
//						}
//					}
//
//				}
//			}
//			return move(cnt, temp);
//		}
//	}
	
	public static int count(int[][] table) {
		int cnt=0;
		for(int j=0; j<N; j++) {
			for(int i=0; i<N; i++) {
				if(table[i][j]==1 && table[i+1][j]==2) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
}
