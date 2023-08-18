package BAEK_1715_카드정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int ans = 0;	
		for(int i =0;i<n;i++) {
			queue.add(sc.nextInt());
		}
		while(queue.size()>1) {
			int num =queue.poll()+queue.poll();
			ans+=num;
			queue.add(num);
		}
		System.out.println(ans);
	}
}
