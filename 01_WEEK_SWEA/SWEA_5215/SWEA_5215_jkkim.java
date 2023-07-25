package question;

import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class SWEA_5215_jkkim {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int N = sc.nextInt();
			int L = sc.nextInt();
			int[] P = new int[N+1];
			int[] C = new int[N+1];		
			for(int i = 1 ;i<=N;i++) {
				P[i] = sc.nextInt();
				C[i] = sc.nextInt();
			}
			int[][] arr = new int[N+1][L+1];
			for(int i = 0;i<N+1;i++) {
				for(int j = 0;j<L+1;j++) {
					if(i==0||j==0) {
						arr[i][j]=0;
					}else if(C[i]>j) {
						arr[i][j]=arr[i-1][j];
					}else {
						arr[i][j] = Math.max(P[i]+arr[i-1][(j-C[i])], arr[i-1][j]);
					}
				}
			}
			int ans = arr[N][L];
			System.out.println("#"+test_case+" "+ans);
		}
		
	}
	

	
	
}
