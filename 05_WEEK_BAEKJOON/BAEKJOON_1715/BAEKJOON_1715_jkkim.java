package BAEK_1715_카드정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();// 개수 입력 합니다.
		PriorityQueue<Integer> queue = new PriorityQueue<>();//우선순위큐 선언
		int ans = 0;	//정답
		for(int i =0;i<n;i++) {//큐에 값 하나씩 넣기
			queue.add(sc.nextInt());
		}
		while(queue.size()>1) {//큐의 사이즈가 1이 될때까지 
			int num =queue.poll()+queue.poll();//2개씩 빼고 더해서
			ans+=num;// 정답에 더해주고
			queue.add(num);//더한값을 큐에 다시넣음
		}
		System.out.println(ans);// 출력
	}
}
