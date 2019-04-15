package d3_1228_cryptogram1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//	첫 번째 줄 : 원본 암호문의 길이 N ( 10 ≤ N ≤ 20 의 정수)
//	두 번째 줄 : 원본 암호문
//	세 번째 줄 : 명령어의 개수 ( 5 ≤ N ≤ 10 의 정수)
//	네 번째 줄 : 명령어
public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		int T = 0;
		List<Integer> list;
		List<Integer> insertList;
		while(T++<testCase) {
			int N = sc.nextInt(); 				// 암호문의 길이
			list = new LinkedList<>();
			for(int i=0; i<N; i++) {
				list.add(sc.nextInt());			// 원본 암호문
			}
			int M = sc.nextInt();					//명령어의 갯수
			for(int i=0; i<M; i++) {
				sc.next();// 문자 I 제거
				int index = sc.nextInt();		// 앞에 추가 할 인덱스
				int K = sc.nextInt();				// 추가할 갯수
				insertList = new LinkedList<>();
				for(int j=0; j<K; j++) {
					insertList.add(sc.nextInt());
				}
				list.addAll(index, insertList);
			}
			
			System.out.print("#"+T+" ");
			for(int i=0; i<10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
