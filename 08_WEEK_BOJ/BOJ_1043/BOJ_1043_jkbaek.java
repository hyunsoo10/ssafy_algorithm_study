import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1043_jkbaek {
	//사람 수
	static int n;
	//bfs용 visited 배열
	static int[] visited;
	//people:진실을 아는 사람 배열 (1:진실 앎 / 0:모름)
	static int[] people;
	//pan:같은 파티에 참여하는지 간선 저장 배열
	static int[][]pan;
	static void bfs(int kn) {
		for(int i=0;i<n+1;i++) {
			if(pan[kn][i]==1&&visited[i]==0) {
				visited[i]=1;
				people[i]=1;
				bfs(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		//m:파티 수
		int m=sc.nextInt();
		//know:아는 사람 수
		int know=sc.nextInt();
		pan=new int[n+1][n+1];
		people=new int [n+1];
		visited=new int [n+1];
		//초기 정답값은 파티 수
		int ans=m;
		//knows:알고있는 사람 명단(번호)
		int[]knows=new int[know];
		for(int i=0;i<know;i++) {
			knows[i]=sc.nextInt();
			//people:인덱스에 해당하는 사람이 알고있음
			people[knows[i]]=1;
		}
		//파티를 2차원 배열로 받음
		int [][]party=new int[m+1][51];
		for(int i=0;i<m;i++) {
			//partypeople:파티의 사람 수
			int partypeople=sc.nextInt();
			//plist:파티에 참여한 사람 명단
			int[]plist=new int[partypeople];
			for(int j=0;j<partypeople;j++) {
				plist[j]=sc.nextInt();
				party[i][j]=plist[j];
			}
			//같은 파티에 참여한 사람끼리 간선을 이음
			for(int j=0;j<plist.length;j++) {
				for(int k=0;k<plist.length;k++) {
					pan[plist[j]][plist[k]]=1;
					
					if(people[plist[j]]==1) {
						people[plist[k]]=1;
					}
				}
			}
		}
		//bfs 진행
		for(int i=0;i<know;i++) {
			bfs(knows[i]);
		}
		//모든 파티에 대해 진실을 아는 사람이 있을때마다 ans 줄임
		for(int i=0;i<m;i++) {
			outer : for(int j=0;j<n;j++) {
					if(people[party[i][j]]==1) {
						ans--;
						break outer;
				}
			}
		}
		System.out.println(ans);
	}
}
