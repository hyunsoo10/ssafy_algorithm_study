package question;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class BAEKJOON_18258_jkbaek {

	public static void main(String[] args) throws IOException {
		//버퍼 리더 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//버퍼 라이터 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//n을 입력받음
		int N = Integer.parseInt(br.readLine());
		//덱 생성
		Deque<Integer> queue = new LinkedList<>();
		//n회 반복함
		for (int i = 0; i < N; i++) {
			// 명령어를 입력받아  공백으로 분할하여 배열에 저장
			String[] strArr = br.readLine().split(" ");
			//배열 첫번째 값을 명령어로 저
			String command = strArr[0];
			//스위치문으로 명령어를 넣어서
			switch (command) {
			//케이스 마다 실행
			case "push": {
				//푸쉬는 배열 2번째 값으로 값을 받아아
				int n = Integer.parseInt(strArr[1]);
				//값을 넣고 브레이크
				queue.add(n);
				break;
			}
			case "pop": {
				//팝은 배열이 비어있으면
				if (queue.isEmpty()) {
					//-1을 출력문에 작성 줄바꿈
					bw.write(-1 + "\n");
					//아니면
				} else {
					//첫번째 값을 출력문에 작성 줄바꿈 첫번째 값 제거
					bw.write(queue.poll() + "\n");
				}
				break;
			}
			case "size": {
				//사이즈는 비어있으면
				if (queue.isEmpty()) {
					//-1을 출력문에 작성 줄바꿈
					bw.write(0 + "\n");
					//아니면
				} else {
					//사이즈를 출력문에 작성 줄바꿈
					bw.write(queue.size() + "\n");
				}
				break;
			}
			case "empty": {
				//empty는 비어있으면
				if (queue.isEmpty()) {
					//1을 출력문에 작성 줄바꿈
					bw.write(1 + "\n");
					//아니면
				} else {
					//0을 출력문에 작성 줄바꿈
					bw.write(0 + "\n");
				}
				break;
			}
			case "front": {
				//front는 비어있으면
				if (queue.isEmpty()) {
					//1을 출력문에 작성 줄바꿈
					bw.write(-1 + "\n");
				} else {
					//맨앞의 값을 조회후 출력문에 작성 줄바꿈
					bw.write(queue.peek() + "\n");
				}
				break;
			}
			case "back": {
				//back는 비어있으면
				if (queue.isEmpty()) {
					//1을 출력문에 작성 줄바꿈
					bw.write(-1 + "\n");
				} else {
					//맨뒤의 값을 조회후 출력문에 작성 줄바꿈
					bw.write(queue.peekLast() + "\n");
					break;
				}

			}

			}

		}
		//for문에서 작성한 출력문을 실제로 출력
		bw.flush();
	}
}

