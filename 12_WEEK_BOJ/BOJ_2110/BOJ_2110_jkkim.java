package boj_2110_공유기설치;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i =0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		//정렬
		Arrays.sort(arr);
		// 이분탐색을 위한 변수
		int min = 0;
		int max = arr[n-1]-arr[0]+1;
		int mid =0;
		// 이분탐색
		while(max>min) {
			// 최소길이 별  집 개수 카운팅
			mid = (min+max)/2;
			int cnt =1;
			int last = arr[0];
			
			for(int i =1;i<n;i++) {
				int  now = arr[i];
				if(now-last>=mid) {
					cnt++;
					last = now;
				}
			}
			// 카운팅 결과로 이분탐색 변수 갱신
			if(cnt >=c) {
				min = mid+1;
			}else {
				max = mid;
			}
			
		}
		// 
		System.out.println(min-1);
	}
}

