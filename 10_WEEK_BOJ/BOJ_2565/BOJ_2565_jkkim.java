
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		//입력및 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine()) ;
		int[] arr = new int [500001];
		int[] arr2 = new int [500001];
		List<Integer>  lista = new ArrayList<>();
		
		int maxidx=0;
		for(int i=0;i<n;i++) {
			String[] str = br.readLine().split(" ");
			int num = Integer.parseInt(str[0]);
			int num2 = Integer.parseInt(str[1]);
			lista.add(num);
			arr[num]=num2;
			arr2[num2]=num;
			if(maxidx<num){
				maxidx=num;
			}
		}
		
		List<Integer>  list = new ArrayList<>();
		int[] idx = new int[500001];
		list.add(-2000000000);
		int max;
		int min;
		int mid;
		int index=1;
		//입력및 선언끝
		//정렬
		Collections.sort(lista);
		//lis
		for(int i=0;i<n;i++) {
			// 값 가져와서
			int I = lista.get(i);
			//정답 리스트가 비어있거나  리스트 마지막 값보다 크면 넣기
			if(list.size()==0||list.get(list.size()-1)<arr[I]) {
				list.add(arr[I]);
				continue;
			}
			//아닐경우 이분탐색으로 값 넣어 주기
			max = list.size()-1;
			min =0;
			while(max>min) {
				mid =(max+min)/2;
				if(list.get(mid)>=arr[I]) {
					max=mid;
				}else {
					min=mid+1;
				}
			}
			list.set(max, arr[I]);	
			
		}
		System.out.println(n-(list.size()-1));
		
	}
}

