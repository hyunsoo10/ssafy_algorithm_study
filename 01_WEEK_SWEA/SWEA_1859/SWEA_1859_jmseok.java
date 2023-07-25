import java.util.Scanner;
import java.util.ArrayList;

public class SWEA_1859_jmseok {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			
			
			int N = sc.nextInt();
			int[] sc_list = new int[N];
			
			for (int i = 0; i < N; i++) {
				int N_e = sc.nextInt();
				sc_list[i] = N_e;
			}
			
			int sell_total = 0;
			
			// 거꾸로 가는 거 고려
			int local_max_down = sc_list[N-1];
			
			for (int i = N-1; i >= 0; i--) {
				if (i == 0) {
					break;
				}
				
				if (i > 0) {
					if (sc_list[i] < sc_list[i-1]) {
						if (local_max_down < sc_list[i-1]) {
							local_max_down = sc_list[i-1];
						} else if (local_max_down >= sc_list[i-1]) {
							sell_total = sell_total + local_max_down - sc_list[i-1];
						}
					} else if (sc_list[i] > sc_list[i-1]) {
						sell_total = sell_total + local_max_down - sc_list[i-1];
					}
				}
				
				
			}
			
		System.out.println("#"+(t+1)+" "+sell_total);
		}	}			
}



