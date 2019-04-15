package d2_1946_simpleCompression;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		while(T++<testCase) {
			int N = sc.nextInt();	// 1이상 10이하
			String[] word = new String[N];
			int[] num = new int[N];
			
			for(int i=0; i<N; i++) {
				word[i] = sc.next();
				num[i] = sc.nextInt();
//				sc.nextLine();		계속 런타임 에러가 났는데.. 이것이 문제.. 
//											마지막부분 입력받을 때 입력을 계속해서 받아 시간을 계속 잡아먹음
			}
			int max=0;
			for(int i=0; i<num.length; i++) {
				max += num[i];
			}
			
			
			System.out.println("#"+T);
			int cnt=0;
			for(int i=0; i<N;i++) {
				for(int j=num[i]; j>0; j--) {
					System.out.print(word[i]);
					cnt++;
					if(cnt%10==0 || cnt==max) {
						System.out.println();
					}
				}
			}
			
//			위와 아래 둘 중에 뭘로 해도 상관 없음.
			
//			List<String> list = new ArrayList<>();
//			for(int i=0; i<N; i++) {
//				for(int j=num[i]; j>0; j--) {
//					list.add(word[i]);
//				}
//			}
//			System.out.println("#"+T);
//			int cnt=0;
//			for(int i=0; i<list.size(); i++) {
//				System.out.print(list.get(i));
//				cnt++;
//				if(cnt%10==0 || cnt==max) {
//					System.out.println();
//				}
//			}
		}
		sc.close();
	}
}
