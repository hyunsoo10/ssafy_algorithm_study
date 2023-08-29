import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class BAEKJOON_10828_jkbaek {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Stack<Integer> list=new Stack<>();
		String x = null;
		String y=null;
		
		for (int i=0;i<n;i++) {
			String s = bf.readLine();
			String array[] = s.split(" ");
			x=array[0];
			if(array.length==2) {
				y=array[1];
				}
			
			if (x.equals("push")) {
				int a=Integer.parseInt(y);
				list.push(a);
				continue;
			}
			else if(x.equals("pop")) {
				if(list.size()==0) {
					System.out.println(-1);
				}
				else {
					System.out.println(list.peek());
				list.pop();
				}
			}
			else if(x.equals("size")) {
				System.out.println(list.size());
				continue;
			}
			else if(x.equals("empty")) {
				if(list.empty()==true) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			else if(x.equals("top")) {
				if(list.size()==0) {
					System.out.println(-1);
				}
				else {
					System.out.println(list.peek());
				}
			}
		}
}
}