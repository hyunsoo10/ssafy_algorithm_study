import java.util.Scanner;

public class BAEKJOON_1991_hscho {

	static int[][] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		sc.nextLine();

		// 트리 생성
		// 0번 인덱스 - 왼쪽 자식, 1번 인덱스 - 오른쪽 자식
		tree = new int[26][2];

		for (int i = 0; i < N; i++) {
			String[] tmp = sc.nextLine().split(" ");
			int node = tmp[0].charAt(0) - 'A'; // 인덱스로 변환해서 A대신 0으로 활용
			char left = tmp[1].charAt(0);
			char right = tmp[2].charAt(0);

			// 자식 노드가 없을 경우 -1 저장
			if (left == '.') {
				tree[node][0] = -1;
			} else {
				tree[node][0] = left - 'A'; // 인덱스로 저장
			}
			if (right == '.') {
				tree[node][1] = -1;
			} else {
				tree[node][1] = right - 'A'; // 인덱스로 저장
			}
		}
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
		System.out.println();
	}
	public static void preOrder(int now) {
		if(now == -1)
			return;
		System.out.print((char) (now+'A')); // 1. 현재 노드 출력
		preOrder(tree[now][0]); //2. 왼쪽 탐색
		preOrder(tree[now][1]); //3. 오른쪽 탐색
	}
	public static void inOrder(int now) {
		if(now == -1)
			return;
		inOrder(tree[now][0]); //2. 왼쪽 탐색
		System.out.print((char) (now+'A')); // 1. 현재 노드 출력
		inOrder(tree[now][1]); //3. 오른쪽 탐색
	}
	public static void postOrder(int now) {
		if(now == -1)
			return;
		postOrder(tree[now][0]); //2. 왼쪽 탐색
		postOrder(tree[now][1]); //3. 오른쪽 탐색
		System.out.print((char) (now+'A')); // 1. 현재 노드 출력
	}
}
