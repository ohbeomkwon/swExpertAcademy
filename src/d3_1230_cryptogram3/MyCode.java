package d3_1230_cryptogram3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		int T=0;
		List <Integer> list;
		List <Integer> insertList;
		while(T++<testCase) {
			int N = sc.nextInt();			// 원본암호문의 길이
			list = new LinkedList<>();
			for(int i=0; i<N; i++) {
				list.add(sc.nextInt());	// 원본 암호문
			}
			int M = sc.nextInt();			//명령어 갯수
			for(int i=0; i<M; i++) {
				String command = sc.next();
				
				if(command.equals("I")) {
					int index = sc.nextInt();	// 수정시작 인덱스
					int K = sc.nextInt();			// 갯수
					insertList = new LinkedList<>();
					for(int j=0; j<K; j++) {
						insertList.add(sc.nextInt());
					}
					list.addAll(index, insertList);
				}
				else if(command.equals("D")) {
					int index = sc.nextInt();	// 수정시작 인덱스
					int K = sc.nextInt();			// 갯수
					for(int j=0; j<K; j++) {
						list.remove(index);
					}
				}
				else if(command.equals("A")) {
					int K = sc.nextInt();
					for(int j=0; j<K; j++) {
						list.add(sc.nextInt());
					}
				}
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
