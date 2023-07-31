package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BAEKJOON_1874_jkkim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		List<Integer> stackList = new ArrayList<>();
		int idx = 0;
		int num=1;
		List<String> ansList = new ArrayList<>();
		while(idx<n) {
			if(stackList.size()==0) {
				ansList.add("+");
				stackList.add(num++);
			}else if(stackList.get(stackList.size()-1)==arr[idx]) {
				ansList.add("-");
				stackList.remove(stackList.size()-1);
				idx++;
			}else {
				ansList.add("+");
				stackList.add(num++);
			}
			if(num>n+1) {
				System.out.println("NO");
				break;
			}
		}
		if(num<=n+1) {
			for(String ans : ansList) {
				System.out.println(ans);
			}
		}
		
	}
}
