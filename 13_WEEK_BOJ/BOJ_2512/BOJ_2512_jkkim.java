package boj_2512_예산;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int m = sc.nextInt();
		//정렬
		Arrays.sort(arr);
		int min =0;
		int max =arr[n-1]+1;
		int mid =0;
		//upperbound 이분탐색
		while(max>min) {
			mid=(max+min)/2;
			int tmp =0;
			for(int i=0;i<n;i++) {
				if(arr[i]>mid) {
					tmp += mid;
				}else {
					tmp += arr[i];
				}
			}
			if(tmp<=m) {
				min =mid+1;
			}else {
				max =mid;
			}
		}
		System.out.println(max-1);
	}
}
