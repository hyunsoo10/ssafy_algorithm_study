package Baekjoon1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		
		//���� ��ü ����
		Stack<Integer> stack = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �Է��� n
		int N = Integer.parseInt(br.readLine());
		
		// �ʱ������� ����
		int A = 0;
		
		// +- ����� �� ���س��� �迭 ����
		String[] output_list = new String[2*N];
		int ord = 0;
		
		
		for (int i = 0; i < N; i++) {
			
			int n = Integer.parseInt(br.readLine());
			
			
			// n�� �Է¹޾��� ��,
			// Empty Exception�� �����ϱ� ���� empty�� ���̽��� ���
			// peek�� n���� ������ n���� ������ �״´�.
			if (stack.isEmpty() || stack.peek() < n) {	
				while (A < n) {
					stack.push(A+1);
					output_list[ord++] = "+";
					A++;
				}
				
				stack.pop();
				output_list[ord++] = "-";
			
			// ���� ��ܿ� n�� �����Ѵٸ� �ٷ� pop�� �Ѵ�.
			} else if (stack.peek() == n) {
				stack.pop();
				output_list[ord++] = "-";
			
			// peek�� ���� �Է��� n������ ũ�� ���� �� �����Ƿ� �ٷ� NO�� ����ϰ� return�� ���� ���ι� ����
			} else if (stack.peek() > n) {
				System.out.println("NO");
				return;
				
			}


			
		}
		
		for (String i : output_list) {
			System.out.println(i);
		}
		
		
		
		
	}
}
