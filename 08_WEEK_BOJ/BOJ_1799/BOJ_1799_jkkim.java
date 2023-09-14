package BOJ_1799_비숍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer> x;//말을 놓을수 있는 좌표값 저장하는 리스트
	static List<Integer> y;
	static boolean[] daegak1;//좌하로 내려가는 대각선
	static boolean[] daegak2;//우하로 내려가는 대각선 
	static int n;//체스판 길이
	static int ans = 0;//답
	static int realans = 0;//진짜 답
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		daegak1=new boolean[n*2];
		daegak2=new boolean[n*2];
		x = new ArrayList<Integer>();
		y = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(str[j]);
				if (num == 1) {
					x.add(i);
					y.add(j);
					
				}
			}
		}
		find(0,0,0);//체스판 흰색칸
		realans+=ans;
		ans=0;
		find(0,0,1);//체스판 검정칸
		realans+=ans;
		System.out.println(realans);
	}

	static void find(int step,int cnt,int num) {//단계,놓은 비숍 수, 흰칸 검은칸 구분을 위한 변수
		if (step == x.size()) {// 마지막 가능한 자리를 확인하면 리턴
			ans= Math.max(ans, cnt);
			return;
		}
		int dx = x.get(step);//좌표 가져오기
		int dy = y.get(step);
		if((dx+dy)%2==num&&!daegak1[dx+dy]&&!daegak2[n-(dx-dy)]) {// 좌대각 우대각 그리고 칸의 색을 확인하여 놓을수 있으면 넘어감
			daegak1[dx+dy]=true;
			daegak2[n-(dx-dy)]=true;
			find(step+1,cnt+1,num);
			daegak1[dx+dy]=false;
			daegak2[n-(dx-dy)]=false;
		}
		find(step+1,cnt,num);//재귀
	}

}
