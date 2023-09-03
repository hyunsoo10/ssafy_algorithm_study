package BOJ_10830;

import java.util.Scanner;
//
//기본적인 아이디어 : 1. 1000으로 나눈 나머지를 구할거라면 곱하기 전에 나눠도 상관없다.
//				 2.지수법칙 활용
//
public class Main {
	static int[][] arr;// 원본배열 선언
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();//배열사이즈 입력
		long B=sc.nextLong();//제곱횟수 입력
		arr = new int[N][N];// 배열 객체화

		for (int i=0; i<N; i++) {// 값 입력
			for (int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt()%1000;// 1000으로 나눈 나머지로 입력받는다.
			}
		}
		int[][] ans = calc2(arr,B)  ;// 정답 배열
				

		for(int i=0; i<N; i++) {// 답 출력
			for(int j=0; j<N; j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
				
	}
	static int[][] calc(int[][] a,int[][] b){// 행렬 제곱 메서드
		int[][] c = new int[a.length][a.length];// 제곱한 값 저장할 행렬 
		//행렬은제곱할때 값이 변하면 안돼서 새로 만들어야함
		
		for (int i=0; i<c.length; i++) {// 제곱
			for (int j=0; j<c.length; j++) {
				for (int k=0; k<c.length; k++) {
					c[i][j]+=a[i][k]*b[k][j];
					c[i][j]%=1000;// 1000으로 나눠준다.
				}
			}
		}
		
		return c;
		
	}
	static int[][] calc2(int[][] a, long b){
		
		if(b==1) {// 1이면 그냥 리턴
			return a;
		}
		int[][] c = calc2(a,b/2);// 지수를 반으로 나눠서 재귀호출
		
		c =calc(c,c);// 재귀로 반환받은 값 제곱 ex) b==7 arr^3*arr^3; 따라서 홀수 일때는 원본배열을 한번 더 곱해준다
		
		if(b%2==1) {// 홀수면 
			c = calc(c,arr);// 원본배열 한번더 곱해준다.
		}
		return c;// 곱한배열 리턴
		
	}
}
