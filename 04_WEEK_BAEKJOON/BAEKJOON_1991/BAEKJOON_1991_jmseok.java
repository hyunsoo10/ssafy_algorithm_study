package BAEKJOON_1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//트리클래스 생성
class Tree {
	char value;
	Tree left;
	Tree right;
	
	Tree (char value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		
	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        //각 노드에 주어진 char값마다 tree클래스를 생성해놓는다.
        //value값이 char가 아니면 배열로 생성해도 무방하다.
        Map<Character, Tree> nodes = new HashMap<>();
        for (char c = 'A'; c < 'A' + N; c++) {
            nodes.put(c, new Tree(c));
        }
        
        
        //생성된 tree클래스마다 left, right value를 입력
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            char value = str[0].charAt(0);
            char leftValue = str[1].charAt(0);
            char rightValue = str[2].charAt(0);
            
            buildTree(nodes, value, leftValue, rightValue);
            
        }
        
        //반드시 A가 root가 되므로
        Tree root = nodes.get('A');
        
        preOrderTraverse(root);
        System.out.println();

        inOrderTraverse(root);
        System.out.println();

        postOrderTraverse(root);
        System.out.println();
        
        
	}
	
	//트리
	static Tree buildTree(Map<Character, Tree> nodes, char value, char leftValue, char rightValue) {
        Tree node = nodes.get(value);
        if (leftValue != '.') {
            node.left = nodes.get(leftValue);
        }
        if (rightValue != '.') {
            node.right = nodes.get(rightValue);
        }
        return node;
    }
	
	//전위탐색
		static void preOrderTraverse(Tree tree) {
	        if (tree != null) {
	            System.out.print(tree.value);
	            preOrderTraverse(tree.left);
	            preOrderTraverse(tree.right);
	        }
		    return;
		}
		
		//중위탐색
		static void inOrderTraverse(Tree tree) {
	        if (tree != null) {
	            inOrderTraverse(tree.left);
	            System.out.print(tree.value);
	            inOrderTraverse(tree.right);
	        }
		    return;
		}
		
		
		//후위탐색
		static void postOrderTraverse(Tree tree) {
	        if (tree != null) {
	            postOrderTraverse(tree.left);
	            postOrderTraverse(tree.right);
	            System.out.print(tree.value);
	        }
		    return;
		}

}
