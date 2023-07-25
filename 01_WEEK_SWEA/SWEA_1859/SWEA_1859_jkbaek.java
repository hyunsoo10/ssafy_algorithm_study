import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number = sc.nextInt();
        long []anslist = new long [number];
        int help=0;
        for (int x=0;x<number;x++) {
            int ipryok = sc.nextInt();
            int max=0;
            int maxnum=0;
            long ans=0;
            int[]list = new int [ipryok];
            //첫 최댓값 구하기
            for (int i=0;i<ipryok;i++) {
                int wonso=sc.nextInt();
                list[i] = wonso;
                if (max<wonso) {
                    max=wonso;
                    maxnum=i;
                }
            }
            for (int i=0;i<maxnum;i++) {
                ans=ans+max-list[i];
    //          System.out.println(ans+"=1차중간//"+max+"=1차최고");
            }
            for (int i=maxnum+1;i<list.length;i++) {
                int newmax=0;
                int newmaxnum=maxnum;
                int[]newlist = new int[list.length-maxnum-1];
                //첫 최댓값 이후 n번째 최댓값 루프로 구하기
                for (int j=i;j<list.length;j++) {
                    newlist[j-i]=list[j];
                    if (newmax<newlist[j-i]) {
                        newmax=newlist[j-i];
                        newmaxnum=j-i;
                    }
                }
//              System.out.println(newmax);
                //n번째 최댓값까지 더하기
                for (int k=0;k<newmaxnum;k++) {
                    ans=ans+newmax-newlist[k];
                    help=help+1;
                }
                i=i+help;
                help=0;
            }
            anslist[x]=ans;
             
             
    }
        for(int y=0;y<number;y++) {
            int yy=y+1;
            System.out.println("#"+yy+" "+anslist[y]);
        }
    }
}