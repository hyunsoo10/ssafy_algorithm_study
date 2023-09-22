package BOJ_1939_중량제한;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class Main {
	static class Node implements Comparable<Node> {
		int v, w; //끝점, 가중치
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		//내림차순
		@Override
		public int compareTo(Node o) {
			return dist[o.v] - dist[this.v];
		}

		
	}
	
	static int N, M;
	static int[] dist;
	
	//인접리스트를 사용한다.
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); //섬의 수
		M = Integer.parseInt(input[1]); //다리의 수
		
		//ArrayList라는 객체의 배열
		List<Node>[] adjList = new ArrayList[N+1]; //1번마을부터 시작 //주어진 정점과 연결된 간선들을 모으고, 정점이 여러개이므로 그 배열
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<Node>();
		} //초기화&생성 시켜놓고 시작
		
		
		
		for (int i = 0; i < M; i++) {
			String[] inputRoad = br.readLine().split(" ");
			int A = Integer.parseInt(inputRoad[0]); //시작마을
			int B = Integer.parseInt(inputRoad[1]); //도착마을
			int C = Integer.parseInt(inputRoad[2]); //중량제한(가중치)
			
			//A마을에 도로를 추가한다
			
			adjList[A].add(new Node(B, C));
			adjList[B].add(new Node(A, C));
		} //도로입력까지 완료
		
		String[] inputTarget = br.readLine().split(" ");
		
		int X = Integer.parseInt(inputTarget[0]); //공장의 위치
		int target = Integer.parseInt(inputTarget[1]); //목표 지점
		
		
		
		dist = new int[N+1]; //최장중량을 저장할 배열 //기본값0
		 // 무한대로 채워놓고
		
		
		boolean[] visited = new boolean[N+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		visited[X] = true;
		
		for (Node e : adjList[X]){
			dist[e.v] = e.w;
		    
		}
		
		pq.addAll(adjList[X]);
		
		int pick = 1;
		
		
		
		//매번 소요시간이 가장 작은 정점을 뽑으면서 모든 정점을 돌건데
		//마지막 건 안돌아도 문제가 없으므로
		while (pick != N-1) {
			
			if (pq.isEmpty()){
			    break;
			}

			Node node = pq.poll(); //가장 중량제한이 큰 놈을 선택
			
			//다 우겨넣었기때문에 방문한 놈은 skip
			if (visited[node.v]){
			    continue;
			}
			
			visited[node.v] = true; // 방문처리
			pick++;
			
			//갱신
			for (Node e : adjList[node.v]){
			    
			    if (!visited[e.v] && dist[e.v] < Math.min(dist[node.v], e.w)){
			        dist[e.v] = Math.min(dist[node.v], e.w);
			        pq.addAll(adjList[e.v]);
			    }
			    
			}
			
			
			
		}
		
		
		
//		System.out.println(Arrays.toString(dist));
		System.out.println(dist[target]);
		
		

		
		
		
	}
	
	
	

	

}