import java.util.Scanner;

public class BAEKJOON_1946_jkbaek{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int tt=0;tt<t;tt++) {
		int n=sc.nextInt();
		//서류등수 담을 list1과 면접등수 담을 list2
		int[]list1=new int[n+1];
		int[]list2=new int[n+1];
		//면접등수의 최솟값
		int min=n+1;
		//정답 카운터
		int ans=0;
		//list1에 서류등수 오름차순으로 담고
		//list2도 같은 인덱스에 담기도록 담음
		//인덱스가 같으면 같은 사람
		for(int i=1;i<=n;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			list1[a]=a;
			list2[a]=b;
			}
		//순회를 돌 동안 서류등수가 낮아지므로, 면접등수가 기존 합격자보다 높아야(작아야) 합격 가능
		for(int i=1;i<=n;i++) {
			if(list2[i]<min) {
				//합격시 최솟값 갱신하고 정답카운트 1 올림
				min=list2[i];
				ans++;
			}
		}
		System.out.println(ans);
		}
	}
}