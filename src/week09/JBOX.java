package week09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class JBOX {

    static BufferedReader br;
    static BufferedWriter bw;

    // 처음 풀이한 방법
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {  // arr 배열의 개수만큼 반복
            for (int j = 0; j < arr[i]; j++) {  // 세로 반복 (3)번 반복
                for (int k = 0; k < arr[i]; k++) {  // 가로반복 (3)번 반복
                    if (j == 0 || j == arr[i] - 1 || k == 0 || k == arr[i]-1) {
                        System.out.print("#");
                    } else if (k != 0 || k != arr[i] - 1) {
                        System.out.print("J");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    // 다른 사람 풀이 참고 후 풀어본 방법
    void solution2() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {  // arr 배열의 개수만큼 반복
            int temp = Integer.parseInt(br.readLine());
            for (int j = 0; j < temp; j++) {  // 세로 반복 (3)번 반복
                for (int k = 0; k < temp; k++) {  // 가로반복 (3)번 반복
                    if ((j == 0) || (j == temp - 1) || (k == 0) || (k == temp - 1)) {
                        bw.write("#");
                    } else if ((k != 0) || (k != temp - 1)) {
                        bw.write("J");
                    }
                }
                bw.write("\n");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
