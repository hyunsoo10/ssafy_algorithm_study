package BOJ_15829_hashing;

import java.util.Scanner;

public class Main {
	static long r;// 31
	static long M;//1234567891
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextInt();
		
		String arr = sc.next();
		r = 31;
		M = 1234567891;
		long ans=0;
		for(int i=0;i<n;i++) {// 해싱
			char ch = arr.charAt(i);	
			ans+= (ch-'a'+1)*calc(i)%M;
			ans%=M;
		}
		System.out.println(ans);
	}
	
	public static long calc(long i) {// 31 거듭제곱 함수
		long n =1;
		for(int j=0;j<i;j++) {
			n*=r;
			n%=M;
		}
		return n;
	}
}
