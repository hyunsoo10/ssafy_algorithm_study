import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//선언및 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		boolean[][] dp = new boolean[n][n];
		String[] str = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(str[i]);
			dp[i][i]=true;
		}
		
		int m= Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		//펠린드롬 확인 하면서 dp 메모
		for(int i=0;i<m;i++) {
			String[] str2 = br.readLine().split(" ");
			
			int a= Integer.parseInt(str2[0])-1;
			int b= Integer.parseInt(str2[1])-1;
			//이전에 확인된 펠린드롬이면 바로 1
			if(dp[a][b]) {
				sb.append(1+"\n");
				continue;
				// 아니면 펠린드롬 확인
			}else {
				
				if(find(a,b)) {
					sb.append(1+"\n");
					//펠린드롬이 확인되면 메모
					for(int j=0;j<(b-a+1)/2;j++) {
						dp[a+j][b-j]=true;
					}
				}else {
					sb.append(0+"\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
	//펠린드롬 확인하는 메소드
	 static boolean find( int start, int end) {
	        int len = (end - start + 1) / 2;
	        for (int i = 0; i < len; i++) {
	            if (arr[start + i] != arr[end - i]) {
	                return false;
	            }
	        }
	        return true;
	    }
}
