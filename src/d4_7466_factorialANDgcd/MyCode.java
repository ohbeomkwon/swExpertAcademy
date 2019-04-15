package d4_7466_factorialANDgcd;

import java.math.BigInteger;
import java.util.Scanner;

// 시간초과 발생
// 팩토리얼을 만들고, 계속해서 나누는 과정에서 생기는 듯
public class MyCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int T=0;
		while(T++<testCase) {
			long N = sc.nextLong();
			long K = sc.nextLong();
			
			BigInteger bn = factorial(N);
			BigInteger bk = BigInteger.valueOf(K);
			// 오른쪽이 큰수
			if(bn.compareTo(bk)>0) {
				BigInteger temp = bk;
				bk =bn;
				bn = temp;
			}
			
			BigInteger gcd = getGcd(bn, bk);
			System.out.println("#"+T+" "+gcd);
			
		}
		sc.close();
	}
	public static BigInteger getGcd(BigInteger n, BigInteger k) {
//		if(n.compareTo(k)>0) {		// k가 크게 만든다.
//			BigInteger temp = k;
//			k = n;
//			n = temp;
//		}
		
		BigInteger remain = k.mod(n);
		if(remain.equals(BigInteger.ZERO)) {
			return n;
		}
		else {
			return getGcd(remain, n);
		}
		
	}
	
	public static BigInteger factorial(long d) {
		BigInteger fac = BigInteger.ONE;
		
		for(long i =1; i<=d; i++) {
			fac = fac.multiply(BigInteger.valueOf(i));
		}
		return fac;
	}
}
