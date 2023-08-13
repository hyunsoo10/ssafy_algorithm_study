package BAEK_11725_트리의부모찾기;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 트리 개수 가져오기
		int n = sc.nextInt();
		// 트리 선언
		TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
		// 트리에 루트인 1넣음 
		tree.put(1, new ArrayList<>());
		// 트리에 다른값 넣음
		for (int i = 0; i < n - 1; i++) {
			//트리에 입력받은 2값을 서로 넣어줌
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (tree.get(x) == null) {
				tree.put(x, new ArrayList<>());
				tree.get(x).add(y);
			} else {
				tree.get(x).add(y);
			}
			
			if (tree.get(y) == null) {
				tree.put(y, new ArrayList<>());
				tree.get(y).add(x);
			}else {
				tree.get(y).add(x);
			}
		}
		//트리를 차례대로 꺼낼 덱 선언
		Deque<Integer> deque = new LinkedList<>();
		//루트인 1넣고
		deque.add(1);
		// 답을 담을 배ㅕ열
		int[] ans =new int[n+1];
		// 방문여부를 담는 배열
		boolean[] visited = new boolean[n+1];
		//bfs
		while(deque.size()>0) {
			//덱에서 값하나 꺼내고
			int v = deque.pollFirst();
			//방문여부 확인후
			if(!visited[v]) {
				//연결된것 가져오기
				List<Integer> tmpList = tree.get(v);
				//가져온 리스트의 값들을
				for(int num :tmpList) {
					//방문여부 확인후
					if(!visited[num]) {
						//덱에 추가
						deque.add(num);
						//답 할당
						ans[num]=v;
					}
				}
				//방문했음으로 변경
				visited[v]=true;
			}
		}
		//정답 출력
		for(int i=2;i<=n;i++) {
			System.out.println(ans[i]);
		}
	}
}
