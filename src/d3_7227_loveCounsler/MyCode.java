package d3_7227_loveCounsler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyCode {
	static int N;
	static List<Dot> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		while(T++<testCase) {
			N = sc.nextInt();
			list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				list.add(new Dot(sc.nextInt(), sc.nextInt()));
			}
			
			
		}
		
		sc.close();
	}
}
class Dot {
	int x, y;
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
