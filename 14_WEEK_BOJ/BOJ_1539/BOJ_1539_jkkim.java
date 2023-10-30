package boj_1539_이진검색트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		//섬은 1
		long sum = 1;
		// 첫번째 값 
		int first = Integer.parseInt(br.readLine());
		// 깊이 배열
		int[] depth = new int[n];
		//트리선언
		TreeSet<Integer> tree = new TreeSet<>();
		// 첫값 넣기
		tree.add(first);
		//첫값 깊이지정
		depth[first]=1;
		// 남은 값 넣기
		for(int i=1;i<n;i++) {
			//값 입력
			int num =Integer.parseInt(br.readLine());
			//깊이 정하기
			if(tree.higher(num)==null) {
				depth[num]=depth[tree.lower(num)]+1;
			}else if(tree.lower(num)==null) {
				depth[num]=depth[tree.higher(num)]+1;
			}else {
				depth[num]=Math.max(depth[tree.higher(num)], depth[tree.lower(num)])+1;
			}
			//값 더해주기
			sum+=depth[num];
			//트리에 넣기
			tree.add(num);
		}
		//출력
		System.out.println(sum);
	}
	
}
