package question;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BAEKJOON_1021_jkkim {
	public static void main(String[] args) {
		//스캐너 선언
		Scanner sc = new Scanner(System.in);
		//n입력받음
		int n = sc.nextInt();
		//m입력받음
		int m = sc.nextInt();
		//덱 선언
		Deque<Integer> deque = new LinkedList<>();
		//덱에 1부터 n 까지 값 추가
		for(int i=1;i<=n;i++) {
			deque.add(i);
		}
		//정답 선언후 0으로 초기화
		int ans=0;
		//m회 만큼 반복;
		for(int i=0;i<m;i++) {
			//빼내야할 값 입력받음
			int tmp = sc.nextInt();
			// 빼내야할 값이 바로있으면 값을 꺼냄
			if(deque.peekFirst()==tmp) {
				deque.pollFirst();
				//아니면
			}else {
				//앞에서 빼면 카운팅
				int firstCount =0;
				//뒤에서 빼면  카운팅
				int lastCount =0;
				// 덱 복사
				Deque<Integer> deque2 = new LinkedList<>(deque);
				//firstCount를 찾는 포문
				for(;;) {
					//앞의 값을 제거하고 뒤에 대입
					deque.addLast(deque.pollFirst());
					//firstCount증가
					firstCount++;
					//만약 맨 앞의 값이 같다면
					if(deque.peekFirst()==tmp) {
						//제거하고
						deque.pollFirst();
						//반복문 멈춤
						break;
					}
				}
				//lastCount를 찾는 포문
				for(;;) {
					//뒤의 값을 제거하고 앞에 대입
					deque2.addFirst(deque2.pollLast());
					//lastCount증가
					lastCount++;
					//만약 맨 앞의 값이 같다면
					if(deque2.peekFirst()==tmp) {
						//제거하고
						deque2.pollFirst();
						//반복문 멈춤
						break;
					}
				}
				//두 반복문이 끝나고 비교해서 작은걸 ans에 더한다
				if(firstCount>lastCount) {
					ans+=lastCount;
				}else {
					ans+=firstCount;
				}
			}
		}
		//ans출력
		System.out.println(ans);
	}
}
