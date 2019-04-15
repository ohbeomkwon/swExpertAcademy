package d2_1961_numberArrayRotation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T = 0;
		int[][] cube;
		int[][] cube90;
		int[][] cube180;
		int[][] cube270;
		Queue<Integer> q = new LinkedList<>();

		while (T++ < testCase) {
			int N = sc.nextInt();
			cube = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cube[i][j] = sc.nextInt();
				}
			}

			// 시작점을 바꿔서 새로 읽어들인다
			// 90도
			for (int j = 0; j < N; j++) {
				for (int i = N - 1; i >= 0; i--) {
					q.add(cube[i][j]);
				}
			}
			cube90 = makeCube(N, q);
			q.clear();

			// 180도
			for (int i = N - 1; i >= 0; i--) {
				for (int j = N - 1; j >= 0; j--) {
					q.add(cube[i][j]);
				}
			}
			cube180 = makeCube(N, q);
			q.clear();

			// 270도
			for (int j = N - 1; j >= 0; j--) {
				for (int i = 0; i < N; i++) {
					q.add(cube[i][j]);
				}
			}
			cube270 = makeCube(N, q);
			q.clear();

			// 출력
			System.out.println("#" + T);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(cube90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(cube180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(cube270[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();
	}

	public static int[][] makeCube(int N, Queue<Integer> q) {
		int[][] rCube = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				rCube[i][j] = q.poll();
			}
		}
		return rCube;
	}

}
