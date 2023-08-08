
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEKJOON_5430_hscho {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			// 스택으로 받을 리스트
			List<String> list = new ArrayList<>();

			String p = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();

			StringTokenizer st = null;

			str = str.substring(1, str.length() - 1);
			st = new StringTokenizer(str, ",");

			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());

			}

			boolean flag = true;

			// 투포인터
			int start_idx = 0;
			int end_idx = list.size() - 1;

			for (int i = 0; i < p.length(); i++) {
				// R이면 토글해주기
				if (p.charAt(i) == 'R') {
					flag = !flag;
				}
				// D인 경우
				else {

					if (flag) {
						start_idx++;

					} else {
						end_idx--;

					}

					// 첫번째 포인터가두번째 포인터를 넘었는데도 D가 나온 경우
					if (start_idx > end_idx + 1) {
						bw.write("error\n");
						break;
					}

				}

			}
			// 첫번째 포인터가 두번째 포인터를 넘었을 때 멈췄을 경우
			if (start_idx == end_idx + 1) {
				bw.write("[]\n");
			}

			if (list.size() != 0 && start_idx <= end_idx) {
				if (flag) {
					bw.write("[");
					for (int i = start_idx; i < end_idx; i++) {
						bw.write(list.get(i) + ",");
					}
					bw.write(list.get(end_idx));
					bw.write("]\n");
				} else {
					bw.write("[");
					for (int i = end_idx; i > start_idx; i--) {
						bw.write(list.get(i) + ",");
					}
					bw.write(list.get(start_idx));
					bw.write("]\n");
				}
			}
		}
	bw.flush();
	}
}
