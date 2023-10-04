
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		//입력과 선언
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[k+1];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		//0값에 1
		dp[0]=1;
		//dp
		for(int i=0;i<n;i++) {
			int tmp = arr[i];
			for(int j=tmp;j<=k;j++) {
				dp[j]+=dp[j-tmp];
			}
		}
		//값 출력
		System.out.println(dp[k]);
	}
}

