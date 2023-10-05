package BOJ_12920_평범한배낭2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//물건의 종류의 수
		int N = Integer.parseInt(st.nextToken());
		//들 수 있는 가방의 최대 무게
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> things = new ArrayList<>();
	
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			//물건의 무게
			int V = Integer.parseInt(st.nextToken());
			//물건의 만족도
			int C = Integer.parseInt(st.nextToken());
			//물건의 개수
			int K = Integer.parseInt(st.nextToken());
			
			int idx = 0;
			while ((K - (1 << idx)) >= 0) {
				//묶음의 무게
				int bundleV = V * (1 << idx);
				//묶음의 만족도
				int bundleC = C * (1 << idx);

				things.add(new int[] {bundleV, bundleC});
				//쓰고 남은 개수
				K = K - (1 << idx);
				idx++;
			}
			
			//남은 것도 모두 집어넣자.
			things.add(new int[] {V*K, C*K});
		}
		
		//물건의 종류에 따른 개수
		int size = things.size();
		
		//DP를 적용하자.
		int[][] dp = new int[size+1][M+1];
		
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= M; j++) {
				//물건을 못넣는 상황이면 그냥 위에걸 받아온다.
				//인덱스는 0부터 시작이므로 
				int[] thing = things.get(i-1);
				if (j < thing[0]) {
					dp[i][j] = dp[i-1][j];
					
				//넣을 수 있는 상황이면
				} else {
					//이미 앞에서 최적만족도를 구했다고 가정하에
					//넣었을 때의 만족도와 안넣었을 때 만족도를 비교해서 큰걸 넣으면 된다.
					dp[i][j] = Math.max(dp[i-1][j-thing[0]] + thing[1], dp[i-1][j]);
					
				}	
			}
		}
		
		System.out.println(dp[size][M]);
		
		
	}

}
