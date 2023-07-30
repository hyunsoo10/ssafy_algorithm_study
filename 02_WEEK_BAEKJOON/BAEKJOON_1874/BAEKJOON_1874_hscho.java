import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BAEKJOON_1874_hscho {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp = 1; // push한 숫자 마지막 값 표현
		boolean flag = true; // 수열 만들 수 있는지 여부 체크 변수

		// 주어진 스택 수열을 받을 리스트
		List<Integer> resultList = new ArrayList<>();
		// 값 쌓을 스택
		Stack<Integer> pushedStack = new Stack<>();
		// 명령어 쌓을 리스트
		List<String> commandList = new ArrayList<>();

		// 입력값 리스트에 저장
		for (int i = 1; i <= N; i++) {
			resultList.add(Integer.parseInt(br.readLine())); // 스택 수열 입력 받기
		}

		for (int num : resultList) {
			for (int i = temp; i <= num; i++) {
				pushedStack.push(i);
				commandList.add("+");
				temp++;
			}

			// pushedStack에 값이 있을 때만 pop 작업 진행
			if (pushedStack.size() != 0) {
				// pushedStack의 top 값이 현재 출력 해야 하는 num 값보다 큰 경우는 해당 수열 생성 불가
				if (pushedStack.peek() > num) {
					flag = false; // 수열 생성 가능 여부 false
					break;
				} else {
					// pushedStack의 top이 현재 num과 같을 경우 계속 pop
					while (pushedStack.peek() == num) {
						pushedStack.pop();
						commandList.add("-");
						// pushedStack에 값이 없으면 반복문 탈출
						if (pushedStack.size() == 0)
							break;
					}
				}

			}

		}

		br.close();
		if (flag) {
			for (String s : commandList) {
				System.out.println(s);
			}
		} else
			System.out.println("NO");

	}
}
