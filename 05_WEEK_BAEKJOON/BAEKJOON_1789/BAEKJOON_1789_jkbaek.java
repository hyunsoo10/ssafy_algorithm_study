import java.util.Scanner;

public class BAEKJOON_1789_jkbaek{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long a=0;
		long ans=0;
		while(ans<=n) {
			ans=ans+a;
			a++;
		}
		System.out.println(a-2);
	}
}