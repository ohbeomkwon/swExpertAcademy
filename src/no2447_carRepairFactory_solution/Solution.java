package no2447_carRepairFactory_solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N;
	static int M;
	static int K;
	static int A;
	static int B;
	static ArrayList<Integer> visited;
	static int ans;
	static Queue<Integer> recWait;
	static Queue<Integer> repWait;
	static int[] rec;
	static int[] rep;
	static int[] recTime;
	static int[] repTime;
	static int[] receipt;
	static int[] repair;
	static Queue<Integer> arrive;
	static int out;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();		// 테스트케이스의 갯수
		for(int testCase=1; testCase <= T; testCase++) {
			N = sc.nextInt();		// 접수창구 갯수
			M = sc.nextInt();		// 정비창국 갯수
			K = sc.nextInt();		//  방문 고객 수
			A = sc.nextInt()-1;		// 방문한 접수창구
			B = sc.nextInt()-1;		// 방문한 정비창구
			
			receipt = new int[N];		// 접수처리 시간
			repair = new int[M];		// 정비처리 시간
			arrive = new LinkedList<>();
			rec  = new int[N];			// 접수창구에 들어있는 고객번호
			recTime = new int [N];	// 접수창구의 상태
			rep = new int [M];			// 정비창구에 들어있는 고객번호
			repTime = new int[M];	// 정비창구의 상태
			visited = new ArrayList<>();
			ans = 0;
			out = 0;
			recWait = new LinkedList<>();		// 접수창구 대기열
			repWait = new LinkedList<>();		// 정비창구 대기열
			
			for(int i=0; i<N; i++) {
				receipt[i] = sc.nextInt();		// 각 접수창구별 소요시간 입력
			}
			for(int i=0; i<M; i++) {
				repair[i] = sc.nextInt();		// 각 정비창구별 소요시간 입력
			}
			for(int i=0; i<K; i++) {
				arrive.add(sc.nextInt());		// 고객별 도착시간 입력
			}
			
			int cnum = 0;		// 고객번호
			int time = 0;
			
			here:		// 라벨 설정 - 라벨명 here(여러개의 반복문을 탈출)
			while(true) {
				while(!arrive.isEmpty()) {
					if(time != arrive.peek()) break;		
					// 고객번호는 1부터 시작
					arrive.poll();
					cnum++;
					recWait.add(cnum);
				}
				
				// 접수창구 끝난사람 있으면 정비창구 대기줄에 추가
				for(int i=0; i<N; i++) {
					if(rec[i]!=0 && recTime[i]==0) {
						int num = rec[i];
						repWait.add(num);	// 접수창구에있던 고객번호를 정비창구 대기줄에 넣음
						rec[i] = 0;	// 해당 접수창구 초기화
					}
				}
				
				// 접수창구가 비었으면 대기줄에서 꺼내서 접수창구에 할당
				while(isReceiptEmpty()) {	// 빈 접수창구가 있는지 확인
					if(recWait.isEmpty()) break;		// 접수창구 대기열이 비었으면 break
					int num = recWait.poll();
					allocateReceipt(num);
				}
				
				// 정비창구 끝나면 비워줌
				for(int i=0; i<M; i++) {
					if(rep[i] !=0 && repTime[i]==0) {
						rep[i] = 0;
						out++;
//						System.out.println("out : "+out);
						if(out==K) break here;	// 나간 사람의 수가 전체 손님의 수와 같으면 while문 탈출
					}
				}
				
				// 정비창구가 비었으면 대기줄에서 꺼내서 정비창구에 할당
				while(isRepairEmpty()) {
					if(repWait.isEmpty()) break;		// 정비창구대기열이 비었으면 break
					int num = repWait.poll();
					allocateRepair(num);
				}
				
				// 각 창구에 있는 남은 시간을 -1 해줌
				for(int i=0; i<N; i++) {
					if(rec[i] !=0) recTime[i]--;	// 손님이 있으면 시간을 -1한다
				}
				for(int i=0; i<M; i++) {
					if(rep[i]!=0) repTime[i]--;
				}
				time++;
			}	// while문 종료
			
			
			if(ans==0) ans=-1;
			System.out.println("#"+testCase+" "+ans);
		}
	}
	
	public static boolean isReceiptEmpty() {
		for(int i=0; i<N; i++) {
			if(rec[i]==0 && recTime[i]==0) return true;
		}
		return false;
	}
	public static void allocateReceipt(int num) {
		for(int i=0; i<N; i++) {
			if(rec[i]==0 && recTime[i]==0) {
				if(i==A) visited.add(num);
				rec[i] = num;
				recTime[i] = receipt[i];
				break;
			}
		}
	}
	
	public static boolean isRepairEmpty() {
		for(int i=0; i<M; i++) {
			if(rep[i]==0 && repTime[i]==0) return true;
		}
		return false;
	}
	public static void allocateRepair(int num) {
		for(int i=0; i<M; i++) {
			if(rep[i]==0 && repTime[i]==0) {
				if(i==B) {
					if(visited.contains(num)) {	// visited에 있다는 이야기는 A창구에 방문한 적이있다는 뜻
//						System.out.println("====== "+A+" , "+B+" 둘 다 방문한 고객번호: "+num);
						ans += num;
					}
				}
				rep[i] = num;
				repTime[i] = repair[i];
				break;
			}
		}
	}
	
}
