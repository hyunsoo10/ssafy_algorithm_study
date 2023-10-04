
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[k+1];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		//최소값을위해 임의의 큰수 배정
		for(int i=1;i<=k;i++) {
			dp[i]=10000001;
		}
		//dp
		for(int i=0;i<n;i++) {
			int tmp = arr[i];
			for(int j=tmp;j<=k;j++) {
				dp[j]=Math.min(dp[j-tmp]+1, dp[j]);
			}
		}
		//초기값이랑 같으면 -1 배정
		if(dp[k]==10000001) {
			System.out.println(-1);
		}else {
			
			System.out.println(dp[k]);
		}
	}
}

