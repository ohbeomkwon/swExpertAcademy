package d3_1244_maxPrize_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


// 참고해서 풀었다..
public class MyCode {
	static int max;
	static int N;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		List <Integer> list;
		while(T++<testCase) {
			int n = sc.nextInt();		// 최초의 숫자
			N = sc.nextInt();					// 교환할 수 있는 횟수
			
			list = new ArrayList<>();
			while(n!=0) {
				list.add(0,n%10);
				n = n/10;
			}
			max = 0;
			check = new boolean [1000000];// 메모이제이션을 위한 장치
			
			dfs(list,0);
			
			System.out.println("#"+T+" "+max);
			
		}
		sc.close();
	}
	
	public static void dfs(List<Integer> list, int depth) {
		// list를 숫자로 전환
		int num=0;
		for(int i=0; i<list.size(); i++) {
			num += list.get(i) * Math.pow(10, list.size()-i-1);
		}
		if(depth==N) {
			max = Math.max(num, max);
			return;
		}
		
		// 메모를 체크해서 다져온 숫자인지 확인
		if(check[num]==true) {
			return;
		}
		else {
			check[num] = true;
		}
		
		// 숫자를 바꾸는 작업
		for(int i=0; i<list.size()-1; i++) {
			for(int j=i+1; j<list.size(); j++) {
				Collections.swap(list, i, j);
				dfs(list,depth+1);
				Collections.swap(list, j, i);
			}
		}
		
		
	}
	
	
}
