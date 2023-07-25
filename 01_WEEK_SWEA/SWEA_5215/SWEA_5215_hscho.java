
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt(); //재료 개수
			int L = sc.nextInt(); //제한 칼로리
			
			int[] value = new int[N+1]; 	// value 를 담을 배열
			int[] calories = new int[N+1]; //칼로리를 담을 배열
			
			// 입력값 받기
			for (int i = 1; i < N+1; i++) {
				value[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}
			
			//dp 배열 
			int[][] dp = new int[N+1][L+1];
			
			for(int i = 1; i<N+1; i++) {
				for(int j = 1; j<L+1; j++) {
					
					//넣을 값의 칼로리가 제한 칼로리 보다 크다면
					if( calories[i] > j ) {
						//이 값을 넣기 이전의 값이 최대값
						dp[i][j] = dp[i-1][j];
					}
					//넣을 값의 칼로리가 제한 칼로리보다 작거나 같다면
					else {
						//그 값을 넣었을 때의 값과 넣지 않았을 때의 값을 비교해서 최대값을 대입
						//1. 넣지 않았을 떄의 값 : dp[i-1][j]
						//2. 그 칼로리를 넣는다면, 그 칼로리의 value + 그  칼로리만큼 뻈을 때의 최대 값 : j + dp[i-1][L-j]
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-calories[i]]+value[i]);
					}
					
				}
			}
			
			System.out.printf("#%d %d",test_case, dp[N][L]);
            System.out.println();
		}
	}
}