package BOJ_17144_미세먼지_안녕;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int r;
	static int c;
	static int[][] arr;
	static int x1;
	static int x2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r =sc.nextInt();
		c = sc.nextInt();
		arr =  new int[r][c];
		int t = sc.nextInt();
		for(int i=0;i<r;i++) {//입력받으면서 청정기 위치확인
			for(int j=0;j<c;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==-1&&x1==0) {
					x1=i;
					x2=i+1;
				}
			}
		}
		for(int i=0;i<t;i++) {//t번 만큼 반복
			diffusion();
			wind();
			
		}
		int ans = 2;//청정기가 -1 이라 2를 초기값을 줌
		for(int i=0;i<r;i++) {//먼지 양측정
			for(int j=0;j<c;j++) {
				ans+=arr[i][j];
			}
		}
		System.out.println(ans);
	}
	public static void diffusion() {//확산 메서드
		int[][] tmp = new int [r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				int cnt =0;
				if(i-1>=0&&arr[i-1][j]!=-1) {
					tmp[i-1][j]+=arr[i][j]/5;
					cnt++;
				}
				if(i+1<r&&arr[i+1][j]!=-1) {
					tmp[i+1][j]+=arr[i][j]/5;
					cnt++;
				}
				if(j-1>=0&&arr[i][j-1]!=-1) {
					tmp[i][j-1]+=arr[i][j]/5;
					cnt++;
				}
				if(j+1<c&&arr[i][j+1]!=-1) {
					tmp[i][j+1]+=arr[i][j]/5;
					cnt++;
				}
				arr[i][j]-=arr[i][j]/5*cnt;
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				arr[i][j]+=tmp[i][j];
			}
		}
		
		
	}
	public static void wind() {//바람 메서드
		int[][] tmp = new int [r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				tmp[i][j]=arr[i][j];
			}
		}
		for(int i=1;i<c-1;i++) {
			tmp[x1][i+1]=arr[x1][i];
		}
		for(int i=x1;i>0;i--) {
			tmp[i-1][c-1]=arr[i][c-1];
		}
		for(int i=c-1;i>0;i--) {
			tmp[0][i-1]=arr[0][i];
		}
		for(int i=0;i<x1;i++) {
			tmp[i+1][0]=arr[i][0];
		}
		tmp[x1][0]=-1;
		tmp[x1][1]=0;
		
		for(int i=1;i<c-1;i++) {
			tmp[x2][i+1]=arr[x2][i];
		}
		for(int i=x2;i<r-1;i++) {
			tmp[i+1][c-1]=arr[i][c-1];
		}
		for(int i=c-1;i>0;i--) {
			tmp[r-1][i-1]=arr[r-1][i];
		}
		for(int i=r-1;i>x2;i--) {
			tmp[i-1][0]=arr[i][0];
		}
		tmp[x2][0]=-1;
		tmp[x2][1]=0;
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				arr[i][j]=tmp[i][j];
			}
		}
	}
}
