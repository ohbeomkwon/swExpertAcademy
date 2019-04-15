package d3_1225_passwordMaker;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 8;
		Queue<Integer> q;
		while (sc.hasNextInt()) {
			int T = sc.nextInt();
			q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				q.add(sc.nextInt());
			}
			
			out:
			while (true) {
				int head=0;
				for (int i = 1; i <= 5; i++) {
					head = q.poll() - i;
					if (head <= 0) {
						head = 0;
						q.add(head);
						break out;
					} else {
						q.add(head);
					}
				}
			}
			
			System.out.print("#"+T+" ");
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}

		sc.close();
	}
}
