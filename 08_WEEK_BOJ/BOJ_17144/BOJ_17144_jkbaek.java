import java.util.Scanner;

public class BOJ_17144_jkbaek {
	static int[][][]pan;
	static int irow;
	static int jcol;
	static int startupi;
	static int startupj;
	static int startdowni;
	static int startdownj;
	static int beforei;
	static int beforej;
	static int nowi;
	static int nowj;
	//시작지점을 찾는 메소드
	//전체 배열을 순회하며 배열의 값이 -1이면 해당 점을 시작지점(윗부분)으로 둔다 
	public static void spoint() {
		outer : for(int i=0;i<irow;i++) {
			for(int j=0;j<jcol;j++) {
				if(pan[i][j][0]==-1) {
					startupi=i;
					startupj=j;
					//시작지점(아랫부분)은 윗부분+1
					startdowni=i+1;
					startdownj=j;
					break outer;
				}
			}
		}
	}
	//위로 도는 사이클
	public static void upcir() {
		//시작지점(공기청정기 윗부분)의 한칸 위를 빨아들임
		pan[startupi-1][startupj][0]=0;
		//한칸씩 빨아들이며 전진하도록
		beforei=startupi-1;
		beforej=startupj;
		nowi=startupi-1;
		nowj=startupj;
		//위쪽 벽에 닿을때까지 전진하며 빨아들임
		while(nowi>0) {
			nowi--;
			pan[beforei][beforej][0]=pan[nowi][nowj][0];
			beforei--;
		}
		//오른쪽 벽에 닿을때까지 전진하며 빨아들임
		while(nowj<jcol-1) {
			nowj++;
			pan[beforei][beforej][0]=pan[nowi][nowj][0];
			beforej++;
		}
		//아래쪽 공기청정기의 i좌표에 닿을때까지 전진하며 빨아들임
		while(nowi<startupi) {
			nowi++;
			pan[beforei][beforej][0]=pan[nowi][nowj][0];
			beforei++;
		}
		//왼쪽 공기청정기에 닿을때까지 전진하며 빨아들임
		while(nowj>0) {
			nowj--;
			pan[beforei][beforej][0]=pan[nowi][nowj][0];
			beforej--;
		}
		//마지막에 공기청정기인 -1을 빨아들여 입력됐으므로 0으로 초기화
		pan[beforei][beforej+1][0]=0;
	}
	//아래로 도는 사이클, 위와 동일
	public static void downcir() {
		pan[startdowni+1][startdownj][0]=0;
		beforei=startdowni+1;
		beforej=startdownj;
		nowi=startdowni+1;
		nowj=startdownj;
		while(nowi<irow-1) {
			nowi++;
			pan[beforei][beforej][0]=pan[nowi][nowj][0];
			beforei++;
		}
		while(nowj<jcol-1) {
			nowj++;
			pan[beforei][beforej][0]=pan[nowi][nowj][0];
			beforej++;
		}
		while(nowi>startdowni) {
			nowi--;
			pan[beforei][beforej][0]=pan[nowi][nowj][0];
			beforei--;
		}
		while(nowj>0) {
			nowj--;
			pan[beforei][beforej][0]=pan[nowi][nowj][0];
			beforej--;
		}
		pan[beforei][beforej+1][0]=0;
	}
	//확산하는 메소드
	public static void kakusan() {
		//모든 배열을 순회 돌면서
		for(int i=0;i<irow;i++) {
			for(int j=0;j<jcol;j++) {
				//minus:확산되는 양(한 방향마다)
				int minus=pan[i][j][0]/5;

				//pan[][][1]의 배열에는 확산될 양이 임시 저장되는 양을 담음
				//확산 후 바로 확산된 칸에 더하면 그 칸에서 확산이 일어날때 오류 발생
				//임시 저장 후 모든 칸에서 확산이 일어난 뒤에 그 칸으로 가라앉힘
				
				//위가 벽이나 공기청정기가 아니라면 위로 확산 
				if(i>0&&pan[i-1][j][0]!=-1) {
					pan[i-1][j][1]+=minus;
					pan[i][j][0]-=minus;
				}
				//왼쪽
				if(j>0&&pan[i][j-1][0]!=-1) {
					pan[i][j-1][1]+=minus;
					pan[i][j][0]-=minus;
				}
				//아래
				if(i<irow-1&&pan[i+1][j][0]!=-1) {
					pan[i+1][j][1]+=minus;
					pan[i][j][0]-=minus;
				}
				//오른쪽
				if(j<jcol-1) {
					pan[i][j+1][1]+=minus;
					pan[i][j][0]-=minus;
				}
				
			}
		}
		//모든 확산이 끝나고 임시저장된 먼지를 가라앉히는 작업
		for(int i=0;i<irow;i++) {
			for(int j=0;j<jcol;j++) {
				pan[i][j][0]+=pan[i][j][1];
				pan[i][j][1]=0;
			}
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		irow=sc.nextInt();
		jcol=sc.nextInt();
		int t=sc.nextInt();
		int sum=0;
		pan=new int[irow][jcol][2];
		for(int i=0;i<irow;i++) {
			for(int j=0;j<jcol;j++) {
				pan[i][j][0]=sc.nextInt();
			}
		}
		spoint();
		//t번 확산, 위사이클, 아래사이클을 돌림
		for(int x=0;x<t;x++) {
			kakusan();
			upcir();
			downcir();
		}
		//모든 칸의 수를 더함
		for(int i=0;i<irow;i++) {
			for(int j=0;j<jcol;j++) {
				sum+=pan[i][j][0];
			}
		}
		//공기청정기 2만큼 더해줌
		System.out.println(sum+2);
	}
}