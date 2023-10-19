package boj_2143_두배열의합.copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int n = sc.nextInt();
		int[] narr = new int[n];
		for(int i=0;i<n;i++) {
			narr[i]=sc.nextInt();
		}
		int m = sc.nextInt();
		int[] marr = new int[m];
		for(int i=0;i<m;i++) {
			marr[i]=sc.nextInt();
		}
		List<Integer> nList = new ArrayList<>();
		List<Integer> mList = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			int num =0;
			for(int j=i;j<n;j++) {
				num+=narr[j];
				nList.add(num);
			}
		}
		for(int i=0;i<m;i++) {
			int num =0;
			for(int j=i;j<m;j++) {
				num+=marr[j];
				mList.add(num);
			}
		}
		Collections.sort(nList);
		Collections.sort(mList);
		
		long ans =0;
		for(int i=0;i<nList.size();i++) {
			int tmp = t - nList.get(i);
			int max = mList.size();
			int min = 0;
			int mid =0;
			while(max>min) {
				mid = (max+min)/2;
				int num = mList.get(mid);
				
				if(num<=tmp) {
					min = mid+1;
				}else {
					max = mid;
				}
			}
			int upper = max;
			max = mList.size();
			min = 0;
			while(max>min) {
				mid = (max+min)/2;
				int num = mList.get(mid);
				
				if(num<tmp) {
					min = mid+1;
				}else {
					max = mid;
				}
			}
			int lower = max;
			if(lower!=upper) {
				ans += (upper-lower);
				
			}
		}
		System.out.println(ans);
		
		
	}
}
