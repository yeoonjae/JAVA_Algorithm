package week09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();

        br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                stack.pop();
            }else{
                stack.push(temp);
            }
        }

        int sum = 0 ;
        for (int a : stack) {
            sum += a;
        }
        System.out.println(sum);
    }
}
