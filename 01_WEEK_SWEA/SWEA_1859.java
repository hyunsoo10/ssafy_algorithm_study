import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int quantity = sc.nextInt(); // 상품 개수
			int[] goods = new int[quantity]; // 상품 받을 배열 선언
			long profit = 0; // 이익 담을 변수 초기화

			// 상품 배열 값 입력 받기
			for (int i = 0; i < goods.length; i++) {
				goods[i] = sc.nextInt();
			}

			// System.out.println(Arrays.toString(goods));

			// 맨 뒤에 값 인덱스
			int index = goods.length - 1;

			// 맨 뒤부터 이익 계산하기
			for (int i = index - 1; i >= 0; i--) {

				// 매매날 이전 금액이 더 저렴하면 차액을 이익으로 추가
				if (goods[i] <= goods[index]) {
					profit += goods[index] - goods[i];
				}
				// 매매날 이전 금액이 더 커지는 순간에 다시 인덱스 초기화
				else {
					index = i;
				}

			}

			System.out.println("#" + test_case + " " + profit);

		}
	}
}