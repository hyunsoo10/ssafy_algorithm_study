import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEKJOON_11725_hscho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 노드 개수
		
		//트리 구조 표현을 위한 그래프
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		
		//인덱스 1번 맞춰서 부터 담기 위해 n+1크기만큼 리스트 생성
		for(int i = 0; i<=n; i++) {
			tree.add(new ArrayList<>());
		}
		
		// 그래프 입력
		for(int i = 0; i<n-1; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			tree.get(n1).add(n2);
			tree.get(n2).add(n1);
		}
		
		//방문 확인 배열
		boolean[] visited = new boolean[n+1];
		//부모 노드 저장 배열
		int[] parentNode = new int[n+1];
		
		
		//BFS
		Queue<Integer> queue = new LinkedList<>();
		visited[0] = true;
		visited[1] = true;
		queue.add(1);
		
		//queue가 빌 때 까지
		while(!queue.isEmpty()) {
			int target = queue.remove();
			for(int node : tree.get(target)) {
				//만약 방문하지 않았다면
				if(!visited[node]) {
					visited[node] = true;//방문
					parentNode[node] = target; // 부모노드에 저장
					queue.add(node);
				}
			}
		}
		
		//2의 부모 노드부터 순차적을 출력
		for(int i = 2; i<=n; i++) {
			System.out.println(parentNode[i]);
		}
		
	}
}
