package BOJ_1939_중량제한;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


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
			return o.w - this.w;
		}

		
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	static int[] dist;
	
	//인접리스트를 사용한다.
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //섬의 수
		M = Integer.parseInt(st.nextToken()); //다리의 수
		
		//ArrayList라는 객체의 배열
		List<Node>[] adjList = new ArrayList[N+1]; //1번마을부터 시작 //주어진 정점과 연결된 간선들을 모으고, 정점이 여러개이므로 그 배열
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<Node>();
		} //초기화&생성 시켜놓고 시작
		
		
		
		for (int i = 0; i < M; i++) {
			StringTokenizer inputRoad = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(inputRoad.nextToken()); //시작마을
			int B = Integer.parseInt(inputRoad.nextToken()); //도착마을
			int C = Integer.parseInt(inputRoad.nextToken()); //중량제한(가중치)
			
			//A마을에 도로를 추가한다
			
			adjList[A].add(new Node(B, C));
			adjList[B].add(new Node(A, C));
		} //도로입력까지 완료
		
		String[] inputTarget = br.readLine().split(" ");
		
		//공장의 위치
		int X = Integer.parseInt(inputTarget[0]); 
		
		//목표 지점
		int target = Integer.parseInt(inputTarget[1]);
		
		
		
		dist = new int[N+1]; //최장중량을 저장할 배열 //기본값0
		boolean[] visited = new boolean[N+1];

		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		//공장지점은 무한한 중량을 옮길 수 있다고 생각할 수 있음
		dist[X] = INF;
		pq.add(new Node(X, INF));
		
		while (!(pq.isEmpty())) {
			
			
			//가장 중량제한이 큰 다리를 뽑는다.
			Node node = pq.poll();
			
			//다리의 도착점을 
			//갱신을 위한 출발섬으로 두면 된다.
			int start = node.v; 
			int w = node.w;
			
			if (visited[start]) {
				continue;
			}
			
			visited[start] = true;
				
			//start섬으로 연결된 다리들과 도착지점들에 대하여
			//갱신을 진행한다.
			for (Node e : adjList[start]) {
				//도착지점으로 향하는 다리의 중량제한값과
				//이미 갱신된 상태의 출발섬의 중량제한 값의 min이
				//도착지점에 줄 중량제한 값이다.
				//weight값이 도착지점에 이미 존재하는
				//중량제한값보다 크면 갱신하고
				//크지 않으면 이미 가치가 없는 루트이므로
				//갱신할 필요가 없다.
			    if (dist[e.v] < Math.min(w, e.w)){
			        dist[e.v] = Math.min(w, e.w);
			        //갱신이 됐을 경우
			        //해당 경로를 가능한 최단경로지점으로 추가한다.
			        pq.add(new Node(e.v, dist[e.v]));
			    }
			    
			}
			
			
			
		}
		
		
		
//		System.out.println(Arrays.toString(dist));
		System.out.println(dist[target]);
		
		

		br.close();
		
		
	}
	
	
	

	

}