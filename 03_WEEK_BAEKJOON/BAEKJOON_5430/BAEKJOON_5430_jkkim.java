package Baek_5430_AC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BAEKJOON_5430_jkkim {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		//
		f1:for(int i=0;i<t;i++) {
			
			//커맨드받기
			String[] p = br.readLine().split("");
			//배열 길이 받기
			int n = Integer.parseInt(br.readLine());
			//배열 받고 덱에 추가
			String str =br.readLine();
			String[] arr = str.substring(1, str.length()-1).split(",");
			Deque<String> deque = new LinkedList<>();
			for(int j =0;j<arr.length;j++) {
				deque.add(arr[j]);
			}//배열 받고 덱에 추가
			
			// 앞뒤 방향을 정하는 플래그
			boolean flag = true;
			
			//커맨드 확인
			for(int k=0;k<p.length;k++) {
				//플래그 변경
				if(p[k].equals("R")) {
					flag=!flag;
				}else {
					//덱이 비어있거나 최초배열의 길이가 0일때 D를 수행하려하면  에러 출력
					if(deque.isEmpty()||n==0) {
						bw.write("error\n");
						continue f1;
					}else {
						//플래그에따라 앞뒤값 제거
						if(flag) {
							deque.pollFirst();
						}else {
							deque.pollLast();
						}
					}
				}
				
			}
			
			//양식에 맞게 출력
			if(deque.size()==0||n==0) {
				bw.write("[");
				bw.write("]\n");
			}else {
				if(flag) {
					bw.write("["+deque.pollFirst());
					int size = deque.size();
					for(int j=0;j<size;j++) {
						bw.write(","+deque.pollFirst());
					}
					bw.write("]\n");
				}else {
					bw.write("["+deque.pollLast());
					int size = deque.size();
					for(int j=0;j<size;j++) {
						bw.write(","+deque.pollLast());
					}
					bw.write("]\n");
				}
			}
		}
		//출력문 발송
		bw.flush();
	}
}
