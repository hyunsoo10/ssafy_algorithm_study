import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2294_jkbaek {

		static int[] list;
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
				int n=sc.nextInt();
				int k=sc.nextInt();
				list=new int[100001];
				for(int i=0;i<10001;i++) {
					list[i]=999999999;
				}
				for(int i=0;i<n;i++) {
					int a=sc.nextInt();
					list[a]=1;
				}
				int ans=0;
				for(int i=1;i<=k;i++) {
					int min=999999999;
					for(int j=1;j<=i/2;j++) {
//						System.out.println(j+" "+(i-j));
						if(min>list[j]+list[i-j]) {
							min=list[j]+list[i-j];
						}
					}
					if(min<999999999&&list[i]>min) {
						list[i]=min;
					}
				}
//				for(int i=0;i<20;i++) {
//					System.out.print(list[i]+" ");
//				}
				if(list[k]>=999999) {
					System.out.println(-1);
				}
				else {
					System.out.println(list[k]);					
				}
				
			}
		

}
