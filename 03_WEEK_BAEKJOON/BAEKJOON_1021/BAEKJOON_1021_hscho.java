import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BAEKJOON_1021_hscho {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> linkList = new LinkedList<>();
		Deque<Integer> myQueue = new ArrayDeque<>();

		// 첫번째 원소를 뽑아낸다 - > poll
		// 2 : 왼 쪽으로 한칸 이동 -> poll 후 addLast
		// 3 : 오른쪽으로 한칸 이동 -> removeLast 후 addFirst

		int N = sc.nextInt(); // 큐의 크기
		int M = sc.nextInt(); // 뽑아내려고 하는 수의 개수

		//1~N까지 담은 Queue 생성
		for (int i = 1; i <= N; i++) {
			linkList.add(i);
		}

		//뽑을 숫자 담을 queue 생성
		for (int i = 0; i < M; i++) {
			myQueue.addLast(sc.nextInt());
		}
		
		int sum = 0; // 2번 3번 연산 횟수 담을 변수
		
		//myQueue에서 다 뽑을 때 까지
		while(myQueue.size()!=0) {
			int target = myQueue.poll();
			//target숫자의 인덱스
			int index = linkList.indexOf(target);
			
			//target요소가 중간 인덱스보다 앞 뒤에 있는지 파악하지 위한 변수
			int standard;
			
			if(linkList.size()%2 == 0) {
				standard = linkList.size()/2;
			}else {
				standard = linkList.size()/2+1;
			}
			//target이 중간값보다 왼쪽에 위치한다면 -> 2번 수행
			if(index < standard) {
				for(int i = 0; i<index; i ++) {
					linkList.addLast(linkList.poll());//첫번째 요소 뽑아서 맨 뒤로
					sum++; //연산 횟수 추가
				}
				linkList.pollFirst();//index요소에 도달하면 뽑아내기
			} else {
				for(int i = linkList.size()-1; i>=index; i --) {
					linkList.addFirst(linkList.pollLast());//마지막 요소 뽑아서 첫번째로
					sum++; //연산 횟수 추가
				}
				linkList.pollFirst();//index요소 도달하면 뽑아내기
			}
			
			
		}
		System.out.println(sum);

		
		

	}
}
