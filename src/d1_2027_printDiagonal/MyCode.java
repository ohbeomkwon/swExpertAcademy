package d1_2027_printDiagonal;
/*
#++++
+#+++
++#++
+++#+
++++#

 그대로 출력하기
 * */
public class MyCode {
	public static void main(String[] args) {
		String a = "#";
		String b = "+";
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(i==j) {
					System.out.print(a);
				}
				else {
					System.out.print(b);
				}
			}
			System.out.println();
		}
	}
}
