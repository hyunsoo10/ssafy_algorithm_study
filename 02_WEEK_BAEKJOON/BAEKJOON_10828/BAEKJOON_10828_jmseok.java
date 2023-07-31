package Baekjoon10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
	public static void main(String[] args) throws IOException {
		
		//���� ��ü ����
		Stack<Integer> stack = new Stack<>();
		
		//�ð� �ʰ��� ���� Scanner�� �ƴ� BufferedReader�� �̿�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�Լ��� ���� �Է�
		int N = Integer.parseInt(br.readLine());
		
		//�Է��� �Լ��� ������ŭ �ݺ�
		for (int i = 0; i < N; i++) {
			
			//� �Լ��� �Է��ϴ��Ŀ� ���� ���� �ൿ�� if, else if ������ ���� ����
			String input = br.readLine();
			String[] input_list = input.split(" ");
			
			//push�ϴ� ��쿡��
			if (input_list[0].equals("push")) {
				
				//������ �߰��� �Է¹޴´�
				int num = Integer.parseInt(input_list[1]);
				
				// ���� push�޼��带 ���� �����ؾ�������, stackŬ������ �̹� �ڹٿ��� �������ִ�.
				// �Ƹ� �ڹٿ� �������� �ʴ´ٸ�, Array�� �޼��带 ���� ������ �� ���� ��
				stack.push(num);
			} else if (input_list[0].equals("pop")) {
				
				//stack�� == null �� �̿��ϸ� �ȵǰ�, isEmpty�޼��带 ����Ͽ� ����ִ��� Ȯ���ؾ��Ѵ�.
				//stack�� ����������� �׳� ����ִ� ��ü������� null�� ��������ʴ´�.
				//pop�޼���� peek�޼���� �̹� �������ִ�.
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
				
				// ���� �������� ���
			} else if (input_list[0].equals("size")) {
				
				System.out.println(stack.size());
				
				
				//stack empty�޼��嵵 �̹� ����������
			} else if (input_list[0].equals("empty")) {
				if (stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				
				//top��� peek�޼��尡 �̹� �������ִ�.
			} else if (input_list[0].equals("top")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
				
			}
			
			
			
			
			
			
		}
		
		
		
		
		
	}

}
