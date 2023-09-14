package BOJ_12015_가장긴증가하는부분수열2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine()) ;
		String[] str = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {//값 입력
			arr[i]=Integer.parseInt(str[i]);
		}
		List<Integer>  list = new ArrayList<>();// 부분수열 리스트
		int max;
		int min;
		int mid;
		for(int i=0;i<n;i++) {// 이진탐색하면서 가장 긴 부분수열 만들기
			if(list.size()==0||list.get(list.size()-1)<arr[i]) {//사이즈가 0이거나 만든 수열의 마지막 값보다 크면 바로 넣기
				list.add(arr[i]);
				continue;
			}
			max = list.size()-1;//이진탐색을 위한 맥스값=현재 만들어진 수열의 길이 -1(인덱스니깐
			min =0;
			while(max>min) {//이진탐색
				mid =(max+min)/2;//미드 구하기
				if(list.get(mid)>=arr[i]) {// 미드의 값이 내값보다 크거나 같으면
					max=mid;//max갱신
				}else {//작으면
					min=mid+1;//min갱신
				}
			}
			list.set(max, arr[i]);	//값 갱신		
			
		}
		System.out.println(list.size());//출력
		
	}
}
