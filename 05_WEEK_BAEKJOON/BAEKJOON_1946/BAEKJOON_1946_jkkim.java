package BAEK_1946_신입사원;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int m = sc.nextInt();
			int max=0;
				
			Map<Integer, Integer> map = new HashMap<>();
			for(int j=0;j<m;j++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				if(n1==1) {
					max=n2;
				}
				map.put(n1, n2);
			}
			int ans=1;	
			for(int j=1;j<=m;j++) {
				if(map.get(j)<max) {
					ans++;
					max=map.get(j);
				}
			}
			System.out.println(ans);
		}
	}
}
