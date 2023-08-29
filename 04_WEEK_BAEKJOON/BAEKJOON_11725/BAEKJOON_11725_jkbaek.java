import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEKJOON_11725_jkbaek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> submap1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> submap2 = new HashMap<Integer, Integer>();
        Stack<Integer> sub1 = new Stack<Integer>();
        Stack<Integer> sub2 = new Stack<Integer>();
        Stack<Integer> sub11 = new Stack<Integer>();
        Stack<Integer> sub22 = new Stack<Integer>();

        map.put(1, -1);
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (!map.containsKey(a) && !map.containsKey(b)) {
                submap1.put(a, b);
                sub1.add(a);
                sub11.add(b);
                continue;
            }
            if (!map.containsKey(a)) {
                map.put(a, b);
            }
            if (!map.containsKey(b)) {
                map.put(b, a);
            }
        }

        while (!sub1.isEmpty() || !sub2.isEmpty()) {
            while (!sub1.isEmpty()) {
                a = sub1.peek();
                sub1.pop();
                b = sub11.peek();
                sub11.pop();
                if (!map.containsKey(a) && !map.containsKey(b)) {
                    submap2.put(a, b);
                    sub2.add(a);
                    sub22.add(b);
                    continue;
                }
                if (!map.containsKey(a)) {
                    map.put(a, b);
                }
                if (!map.containsKey(b)) {
                    map.put(b, a);
                }
            }

            while (!sub2.isEmpty()) {
                a = sub2.peek();
                sub2.pop();
                b = sub22.peek();
                sub22.pop();
                if (!map.containsKey(a) && !map.containsKey(b)) {
                    submap1.put(a, b);
                    sub1.add(a);
                    sub11.add(b);
                    continue;
                }
                if (!map.containsKey(a)) {
                    map.put(a, b);
                }
                if (!map.containsKey(b)) {
                    map.put(b, a);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            bw.write(map.get(i) + "\n");
        }

        br.close();
        bw.close();
    }
}
