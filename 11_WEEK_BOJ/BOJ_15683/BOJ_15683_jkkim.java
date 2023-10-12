package boj_감시;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] dx={-1,0,1,0};
	static int[] dy={0,1,0,-1};
	static int[][] map;
	static int[][] copyMap;
	static List<int[]> list ;
	static int ans = 123456789;
	static int[] arr; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		copyMap = new int[n][m];
		
		list= new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++){
				int num = sc.nextInt();
				if(num != 0 && num!=6) {
					//x,y,cctv 번호
					list.add(new int[] {i,j,num});
				}
				map[i][j]= num;
			}
			
		}
		
		arr = new int[list.size()];
		make(0,list.size());
		System.out.println(ans);
	}
	// 조합 만들기
	static void make(int depth ,int length) {
		if(depth == length) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++){
					copyMap[i][j]=map[i][j];
				}
			}
			for(int i=0;i<length;i++) {
				int[] tmp =list.get(i);
				int x = tmp[0];
				int y = tmp[1];
				int num = tmp[2];
				int dir = arr[i];
				cctv(num,dir,x,y);
			}
			int cnt =0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++){
					if(copyMap[i][j]==0) {
						cnt++;
					}
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		
		for(int i=0;i<4;i++) {
			arr[depth]=i;
			make(depth+1,length);
		}
	}
	//감시 카메라번호와 방향에따라 감시할 지역 분배
	static void cctv(int num ,int dir,int x,int y) {
		if(num == 1) {
			if(dir==0) {
				watch(0,x,y);
			}else if(dir==1) {
				watch(1,x,y);
			}else if(dir==2) {
				watch(2,x,y);
			}else {
				watch(3,x,y);
			}
		}else if(num == 2) {
			if(dir==0) {
				watch(0,x,y);
				watch(2,x,y);
			}else if(dir==1) {
				watch(1,x,y);
				watch(3,x,y);
			}else if(dir==2) {
				watch(2,x,y);
				watch(0,x,y);
			}else {
				watch(3,x,y);
				watch(1,x,y);
			}
		}else if(num == 3) {
			if(dir==0) {
				watch(0,x,y);
				watch(1,x,y);
			}else if(dir==1) {
				watch(1,x,y);
				watch(2,x,y);
			}else if(dir==2) {
				watch(2,x,y);
				watch(3,x,y);
			}else {
				watch(3,x,y);
				watch(0,x,y);
			}
		}else if(num == 4) {
			if(dir==0) {
				watch(0,x,y);
				watch(1,x,y);
				watch(3,x,y);
			}else if(dir==1) {
				watch(0,x,y);
				watch(1,x,y);
				watch(2,x,y);
			}else if(dir==2) {
				watch(1,x,y);
				watch(2,x,y);
				watch(3,x,y);
			}else {
				watch(0,x,y);
				watch(2,x,y);
				watch(3,x,y);
			}
		}else if(num == 5) {
			
				watch(0,x,y);
				watch(1,x,y);
				watch(2,x,y);
				watch(3,x,y);
		}
		
		
	}
	// 감시 영역 전개
	static void watch(int dir,int x,int y) {
		while(true) {
			int nx = x +dx[dir];
			int ny = y +dy[dir];
			if(nx < 0 || nx >= n || ny < 0 || ny >= m || copyMap[nx][ny] == 6) {
				break;
			}
			copyMap[nx][ny]=-1;
			x=nx;
			y=ny;
		}
	}
}

