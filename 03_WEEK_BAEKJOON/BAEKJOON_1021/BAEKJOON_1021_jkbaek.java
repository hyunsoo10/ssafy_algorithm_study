import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BAEKJOON_1021_jkbaek {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //출력 명령 갯수
        int n = Integer.parseInt(bf.readLine());
        //출력
        String order = null;
        //push할때 넣을 숫자
        String number = null;
        //큐
        Queue<Integer> list = new LinkedList<>();
        //back 연산시 필요
        int lastinput = 0;
        
        //n번 반복
        for (int i = 0; i < n; i++) {
        	//입력받아서 공백 기준으로 나눔
            String s = bf.readLine();
            String array[] = s.split(" ");
            //첫 입력은 명령으로 저장
            order = array[0];
            //공백 기준으로 나눈게 2개이면 2번째꺼는 push용 숫자에 저장
            if (array.length == 2) {
                number = array[1];
            }
            //push는 int로 변형해 a에 저장 후 add
            if (order.equals("push")) {
                int a = Integer.parseInt(number);
                list.add(a);
                lastinput = a;
                continue;
                //pop할때 비었으면 -1, 있으면 peek로 탐색 후 poll로 뺌
            } else if (order.equals("pop")) {
                if (list.size() == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(list.peek() + "\n");
                    list.poll();
                }
                //사이즈 반환
            } else if (order.equals("size")) {
                bw.write(list.size() + "\n");
                continue;
                //비어있는지 여부에 따라 0 1
            } else if (order.equals("empty")) {
                if (list.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
                //peek로 맨 앞의 숫자 확인 (배출x)
            } else if (order.equals("front")) {
                if (list.size() == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(list.peek() + "\n");
                }
                //마지막으로 넣은 숫자 확인(배출x)
            } else if (order.equals("back")) {
                if (list.size() == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(lastinput + "\n");
                }
            }
        }


        bw.flush();
        bw.close();
    }
}