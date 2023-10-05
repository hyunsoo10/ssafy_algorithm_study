package BOJ_2294_동전2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static final int INF = Integer.MAX_VALUE-1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// n가지 종류, 합계 k원 입력
		int n = sc.nextInt();
		int k = sc.nextInt();

		// 동전의 종류를 입력할 배열
		int[] nums = new int[n+1];

		for (int i = 1; i <= n; i++) {
			nums[i] = sc.nextInt();
		}

		// dp를 이용해서 최소 개수를 구한다.
		int[][] dp = new int[n + 1][k + 1];
		
		//동전이 없으면 절대 넣을 수 없다.
		//INF으로 하는 이유는 최소개수를 구해야하므로
		for (int i = 1; i < k+1; i++) {
			dp[0][i] = INF;
		}
		
		//0원은 0개가 필요(어챂 0으로 초기화돼있음


		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				//i번째 동전을 넣을 수 있다면
				//여기서 동전을 가치순으로 정렬을 하면 굳이 두번 비교할 필요는 없을 것 같기도..? 
				//근데 edge케이스가 존재할 수도 있을 것 같아서 그냥 두번비교
				if (j - nums[i] >= 0) {
					int min1 = Math.min(dp[i-1][j-nums[i]]+1, dp[i][j-nums[i]]+1);
					dp[i][j] = Math.min(dp[i-1][j], min1);
				//못넣으면 그냥 위에걸 받아온다
				} else {
					dp[i][j] = dp[i-1][j];
				}
				
			}
		}
//		for (int[] i : dp) {
//			System.out.println(Arrays.toString(i));
//		}
		
		if (dp[n][k] == INF) {
			System.out.println(-1);
		} else {
			System.out.println(dp[n][k]);
		}
		

	}

}
