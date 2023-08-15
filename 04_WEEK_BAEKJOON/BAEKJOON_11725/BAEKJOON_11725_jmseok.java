package BAEKJOON_11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//노드의 개수 입력
		int N = Integer.parseInt(br.readLine());
		
		//양방향 그래프
		//트리의 경우에는 무향 그래프이다. (그러나 계층구조를 가지므로 단방향 그래프로 생각해도 무방하다.)
		//다중그래프가 아닌 단순그래프이다. (변의 개수가 1개만 존재 => boolean으로 연결관계표현)
		//그래프를 구현하려면 점(노드)의 개수
		//그리고 노드 간의 연결관계를 파악하면된다.
		//1과 2가 연결돼있다면, 2와 1도 연결돼있는가?
		//행 부분을 부모계층,
		//열 부분을 자식계층으로 생각한다.
		//boolean[i][j]는 노드 i가 부모이고, 노드 j가 자식이라면 true를 집어넣는다.
		
		//노드는 1~N으로 주어지므로 
		boolean[][] tree = new boolean[N+1][N+1];
		
		//노드 입력은 2xN 이차원 배열로 입력받는다
		int[][] inputNode = new int[2][N]; 
		
		//문제의 트리의 선의 개수는 N-1개여야한다.
		int cnt = 0;
		
		for (int i = 1; i < N; i++) {
			
			String[] str = br.readLine().split(" ");
			
			int A = Integer.parseInt(str[0]);
			int B = Integer.parseInt(str[1]);
			
			inputNode[0][i] = A;
			inputNode[1][i] = B;
			
			//입력 시 둘 중에 하나가 1이면, 루트인 1은 반드시 부모가 되므로
			if (A == 1) {
				tree[1][B] = true;
				cnt++;
			} else if (B == 1) {
				tree[1][A] = true;
				cnt++;
			}
			
		}
		
		
		//A와 B중 어느 하나가 부모가 존재하면 
		//나머지는 반드시 자식이 된다.(단, A, B가 서로 부모-자식관계가 아닐 경우에)
		//부모(연결선)의 개수가 N-1개가 되면 중지한다.
		while (cnt < N-1) {
			for (int n = 1; n < N; n++) {
				int A = inputNode[0][n];
				int B = inputNode[1][n];
				
				for (int i = 1; i <= N; i++) {
					
					//A의 부모가 존재하고, 그 부모가 B가 아닐 경우에
					if (tree[i][A] == true && tree[B][A] == false) {
						tree[A][B] = true;
						cnt++;
						break;
						
					//B의 부모가 존재하고, 그 부모가 A가 아닐 경우에
					} else if (tree[i][B] == true && tree[A][B] == false){
						tree[B][A] = true;
						cnt++;
						break;
						
					}
				}
	
			}
		}
		
//		System.out.println();
//		System.out.println(cnt);
//		for (boolean[] i : tree) {
//			System.out.println(Arrays.toString(i));
//		}
		
		//2번노드부터 부모노드를 순차적으로 출력한다.
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (tree[j][i] == true) {
					System.out.println(j);
					break;
				}
			}
			
		}
		
		//메모리 초과
		

	}

	
}
