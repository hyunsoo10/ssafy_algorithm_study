package boj_4195_친구네트워크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static int[] p;
	static int[] c;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			//입력및 선언
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map =  new HashMap<>();
			p=new int[2*n];
			c=new int[2*n];
			int idx=0;
			// 유니온 파인드
			for(int i=0;i<n;i++) {
				String[] str = br.readLine().split(" ");
				String first = str[0];
				String second = str[1];
				//맵에 없으면 추가
				if(!map.containsKey(first)) {
					map.put(first, idx);
					p[idx]=idx;
					c[idx]=1;
					idx++;
				}
				if(!map.containsKey(second)) {
					map.put(second, idx);
					p[idx]=idx;
					c[idx]=1;
					idx++;
				}
				//부모가 다르면 유니온
				if(find(map.get(first))!=find(map.get(second))) {
					union(map.get(first),map.get(second));
				}
				//출력문 작성
				sb.append(c[find(map.get(first))]+"\n");
				
			}
		}
		System.out.print(sb.toString());
	}
	//파인드 메소드
	static int find(int x) {
		if(x!=p[x]) {
			return p[x]=find(p[x]);
		}
		return p[x];
	}
	//유니온 메소드
	static void union(int x, int y) {
		// 더할 값을 저장
		int tmp = c[find(y)];
		// 부모바꾸기
		p[find(y)] = p[find(x)];
		// 값 더하기
		c[find(x)] += tmp;
	}
}