package question;

import java.util.Arrays;
import java.util.Scanner;


public class SWEA_1859_jkkim {
	 public static void main(String args[]) throws Exception
     {
         
         Scanner sc = new Scanner(System.in);
         int T;
         T=sc.nextInt();
        
         
         for(int test_case = 1; test_case <= T; test_case++)
         {
        	 int arrLength = Integer.parseInt(sc.next());
        	 int[] arr = new int[arrLength];// 숫자 배열
        	 sc.nextLine();
        	 String[] sArr = sc.nextLine().split(" ");
        	 
        	 for(int i = 0; i<arr.length; i++) {
        		 arr[i] =  Integer.parseInt(sArr[i]);
        	 }
        	 long ans=0;
        	 int standard_idx = arr.length-1;
        	 for(int i = arrLength-2; i>=0;i--) {
        		if(arr[standard_idx]>arr[i]) {
        			ans+=arr[standard_idx]-arr[i];
        		}else if(i!=0) {
        			if(arr[standard_idx]<arr[i]&&arr[i]>arr[i-1]) {
            			standard_idx=i;
        			}
        		}
        	 }
        	 
        	 System.out.printf("#%d %d\n",test_case,ans);
        	 
         }
         
}
}
