package BOJ_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//
//기본적인 아이디어: 이진탐색으로 나무의 길이를 구한다.
//
public class Main {
	
	static int[] arr;// 스태틱 배열 선언
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// 버퍼선언
		String[] str1 = br.readLine().split(" ");//n,m입력
		int n= Integer.parseInt(str1[0]);
		int m= Integer.parseInt(str1[1]);
		arr=new int[n];//배열 객체화
		int max =0;//맥스 값 값을 입력받으면서 갱신예정
		String[] str2 = br.readLine().split(" ");
		for(int i=0;i<n;i++) {// 값을받으면서 갱신
			arr[i]=Integer.parseInt(str2[i]);
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		int min=0;
		int mid = (min+max)/2;
		long ans =calc(mid);// 답이 롱이 될수도 있음
		while(max>=min) {// max>=min이 될때 까지 반복 이하는 기본적인 이진탐색
			if(ans>m) {
				min= mid+1;
				mid = (min+max)/2;
			}else if(ans<m){
				max=mid-1;
				mid = (min+max)/2;
			}else {
				break;
			}
			
			ans =calc(mid);
		}
		System.out.println(mid);
	}
	static long calc(int n) {// 계산을 위한 메소드(n:톱의 길이)
		long sum=0;// sum 변수
		for(int i=0;i<arr.length;i++) {// 배열길이만큼 반복
			int tmp;
			if(arr[i]-n<0) {// 뺐을때 0이하면 0 
				tmp=0;
			}else {
				tmp=arr[i]-n;// 아니면 빼낸값
			}
			sum+=tmp;
		}
		return sum;//리턴
		
	}
}
