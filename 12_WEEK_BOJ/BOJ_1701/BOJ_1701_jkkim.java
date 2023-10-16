package boj_1701;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int ans =0;
		//길이가 i 인 부분문자열
		
			// 시작 지점
			for(int j=0;j<=str.length();j++) {
				String tmp = str.substring(j,str.length());
				int max = makePi(tmp);
				ans=Math.max(max, ans);
				
			}
		
		System.out.println(ans);
	}
	
	static int makePi(String pt) {
		int[] pi = new int[pt.length()];
		int j=0;
		int max =0;
		for(int i=1;i<pt.length();i++) {
			while(j>0&&pt.charAt(i)!=pt.charAt(j)) {
				j=pi[j-1];
			}
			if(pt.charAt(i)==pt.charAt(j)) {
				pi[i] = ++j;
				max =Math.max(j, max);
			}
		}
		return max;
	}
	
}