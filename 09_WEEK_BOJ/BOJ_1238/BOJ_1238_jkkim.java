package BOJ_1238_파티;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		List<Map<Integer, Integer>> list = new ArrayList<>();
		for(int i =0;i<=N;i++) {
			list.add(new HashMap<>());
		}
		
		
		for(int i=0;i<M;i++) {// 입력
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			list.get(A).put(B, C);
		}
		int ans = 0;
		int[] arr = new int[N+1];
		int[] Xarr = new int[N+1];
		int[] Xarr2 = new int[N+1];
		for(int i=1;i<=N;i++) {
			
			for(int j=0;j<=N;j++) {
				arr[j]=100*N;
			}
			boolean[] visit = new boolean[N+1];
			Queue<Integer> Q = new LinkedList<>();
			Q.add(i);
			arr[i]=0;
			while(!Q.isEmpty()) {// 다익스트라
				int next = Q.poll();
				int min = Integer.MAX_VALUE;
				int minIdx =  -1;
				for(int n :list.get(next).keySet()) {
					if(!visit[n]) {
						int tmp = list.get(next).get(n);
						arr[n]= Math.min(arr[n], arr[next]+tmp);
					}
					
					
				}
				for(int j=1;j<=N;j++) {
					if(!visit[j]&&arr[j]<min) {
						min=arr[j];
						minIdx=j;
					}
				}
				if(minIdx!=-1) {
					visit[minIdx]=true;
					Q.add(minIdx);
				}
				
				
			}
			if(i==X) {
				for(int j=0;j<=N;j++) {
					Xarr[j]=arr[j];
				}
			}else {
				Xarr2[i]=arr[X];
			}
			
		}
		for(int i=1;i<=N;i++) {//출력
			if(i!=X&&(Xarr[i]+Xarr2[i])>ans) {
				ans=Xarr[i]+Xarr2[i];
			}
		}
		System.out.println(ans);
		
	}
}
