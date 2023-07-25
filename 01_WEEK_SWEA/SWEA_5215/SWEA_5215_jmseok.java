import java.util.Scanner;
import java.util.Arrays;


public class SWEA_5215_jmseok {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Test_N = sc.nextInt();
		for (int k = 0; k < Test_N; k++) {
			int F_num = sc.nextInt();
			int C_lim = sc.nextInt();
			int[][] FC_list = new int[F_num][C_lim];
			
			
			for (int i = 0; i < F_num; i++) {
				int F_i = sc.nextInt();
				int C_i = sc.nextInt();
				
				for (int j = 0; j < C_lim; j++) {	
			
					// i = 0 �϶�, �迭�� ù���� �Ʒ��� ����
					if (i == 0) {
						if (C_i <= j) {
							FC_list[i][j] = F_i;
						} else {
							FC_list[i][j] = 0;
						}
					}
					
					// i = 1, �� �迭�� ��°�ٺ��ʹ� �迭�� ���ٿ� ����� �ִ��� Ȱ���Ѵ�.
					if (i >= 1) {
						if (C_i <= j) {
							
							if (FC_list[i-1][j] >= (F_i + FC_list[i-1][j-C_i])) {
								FC_list[i][j] = FC_list[i-1][j];
							} else {
								FC_list[i][j] = F_i + FC_list[i-1][j-C_i];
							}
						} else {
							FC_list[i][j] = FC_list[i-1][j];
						}
					}
					
					/////////////////////////////
					
				}
				
			}
			
			System.out.println("#"+(k+1)+" "+FC_list[F_num-1][C_lim-1]);

		}
	}

}
