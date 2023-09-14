package BOJ_1992_jkkim;

import java.util.Scanner;
//
// 기본적인 아이디어: 4방향씩 분할 정복한다. 
//
public class BOJ_1992_jkkim {
	static int[][] arr; // 스태틱 변수로 선언한 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 배열의사이즈
		arr= new int[n][n];// 선언한 배열을 객체화
		int tmp =0;// 전부다 0이거나 1일경우 0 혹은 1만 출력해야하만 하기 때문에 이를 확인하기 위한변수
		for(int i=0;i<n;i++) {// 값 입력받기
			String[] str = sc.next().split("");
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(str[j]);
				tmp+=arr[i][j];// 변수에 값 더해주기
			}
		}
		if(tmp==0) {//만약 더한 값이 0이면 모두 0이기 때문에 0출력후 리턴
			System.out.println(0);
			return;
		}else if(tmp==n*n){//만약 더한 값이 n*n이면 모두 1이기 때문에 1출력후 리턴
			System.out.println(1);
			return;
		}
		calc(n,0,0);
		
	}
	static void calc(int n,int x,int y) {// 재귀 출력 을 위한 메서드// (n:조회할 범위,x,y:기준 좌표 
		// 4방향으로 나누고 모두 같지 않으면 재귀로 호출하여  그 부분을 다시 4개로 나누어 확인한다.
		System.out.print("(");// 구분을 위한 (출력
		int s1 = arr[x][y];// 첫값을 조회
		boolean flag = false;// 모두 같으면 펄스 다르면 트루를 반환하여 재귀 할지 말지 정하는 메서드
		for(int i=x;i<x+n/2;i++) {
			for(int j=y;j<y+n/2;j++) {
				if(arr[i][j]!=s1) {//다른 것을 찾으면 플래그를 트루로 
					flag =true;
				}
			}
		}
		if(flag) {//결과에 따라
			calc(n/2,x,y);//모두같지 않으므로 재귀
		}else {
			System.out.print(s1);// 모두 같으므로 첫 값을 추력
		}
		// 그 이하로는 나머지 3방향을 같은 방식으로 처리
		 s1 = arr[x][y+n/2];
		flag = false;
		for(int i=x;i<x+n/2;i++) {
			for(int j=y+n/2;j<y+n;j++) {
				if(arr[i][j]!=s1) {
					flag =true;
				}
			}
		}
		if(flag) {
			calc(n/2,x,y+n/2);
		}else {
			System.out.print(s1);
		}
		
		s1 = arr[x+n/2][y];
		flag = false;
		for(int i=x+n/2;i<x+n;i++) {
			for(int j=y;j<y+n/2;j++) {
				if(arr[i][j]!=s1) {
					flag =true;
				}
			}
		}
		if(flag) {
			calc(n/2,x+n/2,y);
		}else {
			System.out.print(s1);
		}
		 s1 = arr[x+n/2][y+n/2];
		flag = false;
		for(int i=x+n/2;i<x+n;i++) {
			for(int j=y+n/2;j<y+n;j++) {
				if(arr[i][j]!=s1) {
					flag =true;
				}
			}
		}
		if(flag) {
			calc(n/2,x+n/2,y+n/2);
		}else {
			System.out.print(s1);
		}
		System.out.print(")");// 구분하기 위해 마지막 )출력
		
	}
}

