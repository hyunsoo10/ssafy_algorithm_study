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
			
			//Ŀ�ǵ�ޱ�
			String[] p = br.readLine().split("");
			//�迭 ���� �ޱ�
			int n = Integer.parseInt(br.readLine());
			//�迭 �ް� ���� �߰�
			String str =br.readLine();
			String[] arr = str.substring(1, str.length()-1).split(",");
			Deque<String> deque = new LinkedList<>();
			for(int j =0;j<arr.length;j++) {
				deque.add(arr[j]);
			}//�迭 �ް� ���� �߰�
			
			// �յ� ������ ���ϴ� �÷���
			boolean flag = true;
			
			//Ŀ�ǵ� Ȯ��
			for(int k=0;k<p.length;k++) {
				//�÷��� ����
				if(p[k].equals("R")) {
					flag=!flag;
				}else {
					//���� ����ְų� ���ʹ迭�� ���̰� 0�϶� D�� �����Ϸ��ϸ�  ���� ���
					if(deque.isEmpty()||n==0) {
						bw.write("error\n");
						continue f1;
					}else {
						//�÷��׿����� �յڰ� ����
						if(flag) {
							deque.pollFirst();
						}else {
							deque.pollLast();
						}
					}
				}
				
			}
			
			//��Ŀ� �°� ���
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
		//��¹� �߼�
		bw.flush();
	}
}
