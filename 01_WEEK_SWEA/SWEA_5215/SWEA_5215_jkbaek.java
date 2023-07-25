import java.util.Arrays;
import java.util.Scanner;
 
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
         
        for(int k=1;k<=t;k++) {
            int n=sc.nextInt();
            int l=sc.nextInt();
            int[][]dp=new int[n+1][l+1];
            int[]cal=new int[n+1];
            int[]tas=new int[n+1];
            int ans=0;
             
            for (int i=1;i<n+1;i++) {
                int a=sc.nextInt();
                int b=sc.nextInt();
                tas[i]=a;
                cal[i]=b;
            }
            for (int i=0;i<n+1;i++) {
                for(int j=0;j<l+1;j++) {
                    if(i<=0 || j<=0) {
                        dp[i][j]=0;
                    }
                    else if(j-(cal[i])<0) {
                        dp[i][j]=dp[i-1][j];
                    }
                    else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-(cal[i])]+tas[i]);
                    }
                    if (dp[i][j]>ans) {
                        ans=dp[i][j];
                    }
                }
            }
         
        System.out.println("#"+k+" "+ans);
    }
        }
         
    }