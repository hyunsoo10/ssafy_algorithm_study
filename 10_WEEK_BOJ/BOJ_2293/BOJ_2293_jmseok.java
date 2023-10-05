package BOJ_2293_동전1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//n가지 종류, 합계 k원 입력
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		//동전의 종류를 입력할 배열
		int[] nums = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			nums[i] = sc.nextInt();
		}
		
		//dp를 이용해 경우의 수를 구한다.
		int[][] dp = new int[n+1][k+1];
		
		for (int i = 0; i <= n; i++) {
			//넣지 않는 경우의 수는 항상 1가지로 고정
			dp[i][0] = 1;
		}
		
//		System.out.println(nums[1]);
		
//		for (int j = 1; j < k+1; j++) {
////			System.out.println(j%nums[1]);
//			if (j%nums[1] == 0) {
//				dp[1][j] = 1;
//			}
//		}
		
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < k+1; j++) {
				//낼수 있는 경우에
				//위에거(아예 i번째를 안쓴경우)+앞에있는거(i번째 숫자를 쓴 경우)
				if (j - nums[i] >= 0) {
					dp[i][j] = dp[i-1][j]+dp[i][j-nums[i]];
				//내지못하는 경우에는 위에 걸 그대로 받아온다.
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}	
		}
//		for (int[] i : dp) {
//			System.out.println(Arrays.toString(i));
//		}
		
		System.out.println(dp[n][k]);
		
		
		
	}

}
