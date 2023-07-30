import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEKJOON_10828_hscho {
	public static void main(String[] args) throws IOException {
		// push X : 정수 X를 스택에 넣는다
		// pop : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 비어있으면 -1을 출력한다
		// size : 스택에 들어 있는 정수의 개수를 출력
		// empty : 스택이 비어있으면 1, 아니면 0을 출력
		// top : 스택의 가장 위에 있는 정수를 출력. 비어 있으면 -1을 출력

		//Scanner를 사용하면 시간 초과
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		// 값을 담을 리스트 선언
		List<Integer> myStack = new ArrayList<>();

		// 명령 작업 N 만큼 반복
		for (int i = 0; i < N; i++) {
			//String keyword = sc.next();
			String keyword = br.readLine();
			
			//keyword에 공백이 있다면 -> push
			if(keyword.contains(" ")) {
				st = new StringTokenizer(keyword, " ");
				String command = st.nextToken();
				int value = Integer.parseInt(st.nextToken());
				
				myStack.add(value);
			}

			switch (keyword) {
			//Scanner 사용시 필요한 것
//			case ("push"):
//				myStack.add(sc.nextInt());
//				break;
			case ("pop"):
				int lastIndex = myStack.size()-1;
				// 스택이 비어 있을 경우 -1 출력
				if (myStack.size() == 0) {
					System.out.println("-1");
				} else {
					//맨 위에 있는 값(마지막 인덱스 값) 출력
					System.out.println(myStack.get(lastIndex));
					//마지막 값 빼주기
					myStack.remove(lastIndex);
				}
				break;
			case ("size"):
				//myStack 크기 출력
				System.out.println(myStack.size());
			break;
			case ("empty"):
				//스택이 비어있으면 1 출력
				if(myStack.size()==0)
					System.out.println("1");
				//스택이 비어 있지 않으면 0 출력
				else
					System.out.println("0");
				break;
			case ("top"):
				int lastIndex2 = myStack.size()-1;
				//스택이 비어 있으면 -1 출력
				if(myStack.size()==0)
					System.out.println("-1");
				else {
					System.out.println(myStack.get(lastIndex2));
				}
				break;
			}
		}
		
		br.close();

	}
}
