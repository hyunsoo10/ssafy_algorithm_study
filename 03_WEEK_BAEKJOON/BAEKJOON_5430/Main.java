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

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		f1:for(int i=0;i<t;i++) {
			String[] p = br.readLine().split("");
			int n = Integer.parseInt(br.readLine());
			String str =br.readLine();
			String[] arr = str.substring(1, str.length()-1).split(",");
			Deque<String> deque = new LinkedList<>();
			for(int j =0;j<arr.length;j++) {
				deque.add(arr[j]);
			}
			boolean flag = true;
			for(int k=0;k<p.length;k++) {
				if(p[k].equals("R")) {
					flag=!flag;
				}else {
					if(deque.isEmpty()||n==0) {
						bw.write("error\n");
						continue f1;
					}else {
						if(flag) {
							deque.pollFirst();
						}else {
							deque.pollLast();
						}
					}
				}
				
			}
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
		bw.flush();
	}
}
