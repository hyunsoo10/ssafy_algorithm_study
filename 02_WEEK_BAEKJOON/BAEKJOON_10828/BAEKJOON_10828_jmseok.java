package Baekjoon10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
	public static void main(String[] args) throws IOException {
		
		//스택 객체 형성
		Stack<Integer> stack = new Stack<>();
		
		//시간 초과로 인해 Scanner가 아닌 BufferedReader를 이용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//함수의 개수 입력
		int N = Integer.parseInt(br.readLine());
		
		//입력한 함수의 개수만큼 반복
		for (int i = 0; i < N; i++) {
			
			//어떤 함수를 입력하느냐에 따라 취할 행동을 if, else if 구문을 통해 구현
			String input = br.readLine();
			String[] input_list = input.split(" ");
			
			//push하는 경우에는
			if (input_list[0].equals("push")) {
				
				//정수를 추가로 입력받는다
				int num = Integer.parseInt(input_list[1]);
				
				// 원래 push메서드를 따로 구현해야하지만, stack클래스가 이미 자바에는 구현돼있다.
				// 아마 자바에 존재하지 않는다면, Array와 메서드를 통해 구현할 수 있을 듯
				stack.push(num);
			} else if (input_list[0].equals("pop")) {
				
				//stack은 == null 을 이용하면 안되고, isEmpty메서드를 사용하여 비어있는지 확인해야한다.
				//stack은 비어있을때도 그냥 비어있는 객체취급이지 null로 취급하지않는다.
				//pop메서드와 peek메서드는 이미 구현돼있다.
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
				
				// 스택 사이즈의 경우
			} else if (input_list[0].equals("size")) {
				
				System.out.println(stack.size());
				
				
				//stack empty메서드도 이미 구현돼있음
			} else if (input_list[0].equals("empty")) {
				if (stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				
				//top대신 peek메서드가 이미 구현돼있다.
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
