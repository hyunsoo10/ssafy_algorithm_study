package Baek_1991_트리순회;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	//트리 전역변수 선운
	static TreeMap<String, Node> tree = new TreeMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		// 트리구조 입력 
		for(int i=0;i<n;i++) {
			String[] strArr= sc.nextLine().split(" ");
			int idx=0;
			//. 이면 널입력
			for(String str : strArr) {
				if(str.equals(".")) {
					strArr[idx]=null;
				}
				idx++;
			}
			//.트리에 넣기
			tree.put(strArr[0], new Node(strArr[0],strArr[1],strArr[2]));
			
			
		}
		bfs1("A");
		System.out.println();
		bfs2("A");
		System.out.println();
		bfs3("A");
		
//		System.out.println(tree);
	}
	//이진 트리 노드
	public static class Node {
		String self;
		String left;
		String right;
		public Node(String self, String left, String right) {
			super();
			this.self = self;
			this.left = left;
			this.right = right;
		}
		@Override
		public String toString() {
			return "Node [self=" + self + ", left=" + left + ", right=" + right + "]";
		}	
		
	}
	//전위
	public static void bfs1(String key){
		Node node = tree.get(key);
		System.out.print(node.self);
		if(!(node.left==null)) {
			bfs1(node.left);
		}
		if(!(node.right==null)) {
			bfs1(node.right);
		}
	}
	//중위
	public static void bfs2(String key){
		Node node = tree.get(key);
		if(!(node.left==null)) {
			bfs2(node.left);
		}
		System.out.print(node.self);
		if(!(node.right==null)) {
			bfs2(node.right);
		}
	}
	//후우
	public static void bfs3(String key){
		Node node = tree.get(key);
		if(!(node.left==null)) {
			bfs3(node.left);
		}
		if(!(node.right==null)) {
			bfs3(node.right);
		}
		System.out.print(node.self);
	}
}
