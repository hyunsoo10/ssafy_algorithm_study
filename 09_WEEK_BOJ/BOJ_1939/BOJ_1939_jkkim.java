package BOJ_1939_중량제한;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int X ;//공장위치 X,Y
	static int Y ;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//섬 개수
		int m = sc.nextInt();// 다리개수
		int max = 0;
		List<Map<Integer,Integer>> map = new ArrayList<>();//인접리스트
		for(int i =1;i<=n;i++) {// 섬만큼 입력
			map.add(new HashMap<>());
		}
		for(int i=0;i<m;i++) {// 다리 정보 저장
			int A =sc.nextInt()-1;//0부터라 -1
			int B =sc.nextInt()-1;
			int C =sc.nextInt();
			if(C>max) {// 맥스 갱신
				max=C;
			}
			if(map.get(A).containsKey(B)&&map.get(A).get(B)>=C) {// 만약 이미 다리가 있는데 그다리가 크거나 같은 하중을 견디면 그대로 둠 
				continue;
			}else {// 아닐경우에만 바꿈
				map.get(A).put(B, C);
				map.get(B).put(A, C);
			}
		}
		X= sc.nextInt()-1;//0부터라 -1
		Y =sc.nextInt()-1;
		int min=0;
		while(min<=max) {// max가 클동안 반복(이진탐색)
			int mid = (max+min)/2;
			flag =false;
			Queue<Integer> Q = new LinkedList<>();//bfs를 위한 큐
			Q.add(X);// 공장위치 
			boolean[] visit = new boolean[n+1];//bfs를 위한 방문배열
			visit[X]=true;//공장위치
			while(!Q.isEmpty()) {//bfs
				int next = Q.poll();
				if(next == Y){//공장에 도착했으면 트루 로 바꾸고 멈춤
					flag=true;
					break;
				}
				for(int num :map.get(next).keySet()) {
					int tmp = map.get(next).get(num);//다리의 중량 가져오기
					if(tmp>mid&&!visit[num]) {//중량이 mid보다 크고 방문하지 않았으면 큐에 넣음
						visit[num]=true;//방문했음
						Q.add(num);
					}
				}
			}
			if(flag) {// 트루면 값이 큰것ㅇ이기 때문에 min을 갱신
				min=mid+1;
			}else {//false면 값이 작은것이기 때문에 max 갱신
				max=mid-1;
			}
				
		}
		System.out.println(max);//출력
		
		
	}
}
