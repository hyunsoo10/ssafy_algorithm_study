package BAEK_1789_수들의합;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long num = sc.nextLong();
		int ans  = -1;
		for(int i=1;num>=0;i++) {
			num-=i;
			ans++;
		}
		System.out.println(ans);
	}
}
