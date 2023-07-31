package question;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class BACKJOON_10828_jkkim {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int size=0;
		for(int i=0;i<N;i++) {
			String[] strArr = br.readLine().split(" ");
			String command = strArr[0];
			if(command.equals("push")) {
				int n = Integer.parseInt(strArr[1]);
				arr[size++]=n;
			}else if(command.equals("pop")) {
				if(size==0) {
					bw.write(-1+"\n");
					bw.flush();
				}else {
					bw.write(arr[size-1]+"\n");
					bw.flush();
					arr[--size]=0;
				}
			}else if(command.equals("size")) {
				if(size==0) {
					bw.write(0+"\n");
					bw.flush();
				}else {
					bw.write(size+"\n");
					bw.flush();
				}
			}else if(command.equals("empty")) {
				if(size==0) {
					bw.write(1+"\n");
					bw.flush();
				}else {
					bw.write(0+"\n");
					bw.flush();
				}
			}else if(command.equals("top")) {
				if(size==0) {
					bw.write(-1+"\n");
					bw.flush();
				}else {
					bw.write(arr[size-1]+"\n");
					bw.flush();
				}
			}
		}
			
	}
}
