package Baek_4803_트리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {
	//사이클 전역변수
	static int cycleCnt=0;
	static int treeCnt=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		//반복
		while(true) {
			treeCnt=0;
			cycleCnt=0;
			//케이스
			cnt++;
			int n = sc.nextInt();
			int m = sc.nextInt();
			//종료 조건문
			if(n==0&&m==0) {
				break;
			}
			// 트리 를 담는 맵
			TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
			// 트리 생성
			for(int i=1;i<n+1;i++) {
				tree.put(i, new ArrayList<>());
			}
			// 트리 연결
			for(int i=0;i<m;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				tree.get(x).add(y);
				tree.get(y).add(x);
			}
			//방문했는지 판별하는 배열
			boolean[] visited=new boolean[n+1];
			// 완료했는지 판별하는 배열
			boolean[] complete=new boolean[n+1];
			// 사이클의 루트를 저장하는 리스트
			List<Integer> cycleList = new ArrayList<>();
			// 1번 노드 부터 탐색 시작  방문하지 않은 노드에 첫방문시 그 노드 가 루트가 되며 나무의 숫자추가
			for(int i=1;i<=n;i++) {
				if(!(visited[i])) {
					treeCnt++;
					bfs(i,i,0,tree,visited,complete,cycleList);
				}
				
			}
			
			
			//나무 수에 따른 출력
			if(treeCnt-cycleCnt==1) {
				System.out.println("Case "+cnt+": "+"There is one tree.");
			}else if(treeCnt-cycleCnt<1) {
				System.out.println("Case "+cnt+": "+"No trees.");
			}else {
				System.out.println("Case "+cnt+": A forest of "+(treeCnt-cycleCnt)+" trees.");
			}
			
			
		}
	}
	public static void bfs(int key ,int root,int parentKey,TreeMap<Integer, List<Integer>> tree,boolean[] visited,boolean[] complete,List<Integer> cycleList) {
		//노드에 연결된 다른 노드 리스트
		List<Integer> list = tree.get(key);
		//방문하지 않았으면
		if (!(visited[key])) {
			// 방문했다고 표시후
			visited[key] = true;
			//노드 리스트 탐색
			for (int i : list) {
				//만약 부모 노드면 넘어감
				if(i==parentKey) {
					// 방문하지 않았으면 한단계 더 내려감
				}else if (!(visited[i])) {
					bfs(i,root,key, tree, visited, complete,cycleList);
					//방문했는데 완료되지 않은 노드가 부모노드도 아니면 그건 사이클 
				}else if(!(complete[i])) {
					// 사이클 루트 리스트에서 만약에 그 루트가 없을때 만 사이클 수 증가
					if(!(cycleList.contains(root))) {
						cycleList.add(root);
						cycleCnt++;
					}
					
				}
			}
		}
		// 완료 배열에 완료했다고 해줌
		complete[key]=true;
	}
}
