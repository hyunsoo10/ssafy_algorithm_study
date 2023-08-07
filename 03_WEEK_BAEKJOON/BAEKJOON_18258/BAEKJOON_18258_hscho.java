import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BAEKJOON_18258_hscho {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;

		//queue 구현할 Deque
		Deque<Integer> myQueue = new ArrayDeque<>();
		
		//출력할 결과 담을 리스트
		List<Integer> result = new ArrayList<>();
		

		for (int i = 0; i < N; i++) {
			String keyword = br.readLine();

			//push가 키워드에 포함되어 있으면 value에 push할 값을 받는다
			if (keyword.contains("push")) {
				st = new StringTokenizer(keyword, " ");
				String command = st.nextToken();
				int value = Integer.parseInt(st.nextToken());
				//myQueue에 value push(addLast) - 마지막 요소에 추가
				myQueue.addLast(value);
			} else {
				switch (keyword) {
				case ("front"):
					if (myQueue.size() == 0) {
						result.add(-1);
					} else {
						//peekFirst(맨 앞에 있는 요소)
						result.add(myQueue.peekFirst());
					}
					break;
				case ("back"):
					if (myQueue.size() == 0) {
						result.add(-1);
					} else {
						//peekLast(맨 뒤에 있는 요소)
						result.add(myQueue.peekLast());
					}
					break;
				case ("size"):
					result.add(myQueue.size());
					break;
				case ("pop"):
					if (myQueue.size() == 0) {
						result.add(-1);
					} else {
						//Stack의 pop과 똑같음
						result.add(myQueue.pop());
					}
					break;
				case ("empty"):
					if (myQueue.size() == 0) {
						result.add(1);
					} else {
						result.add(0);
					}
					break;
				}
			}
		}
		
		for(int i =0; i<result.size(); i++) {
			bw.write(result.get(i) + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
