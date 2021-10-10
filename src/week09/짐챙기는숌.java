package week09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 짐챙기는숌 {

    // 분류 : 그리디 알고리즘
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 책의 개수, 최대 무게
        StringTokenizer st = new StringTokenizer(br.readLine());

        int bookCnt = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        // 박스안에 들은 책의 무게
        int boxWeight = 0;

        // 박스의 개수
        int boxCnt = 1;
        if (bookCnt != 0) {

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < bookCnt; i++) {
                int bookWeight  = Integer.parseInt(st.nextToken());
                if (bookWeight  + boxWeight <= maxWeight) {  // 박스 무게 + 책 무게 =  최대 무게보다 적을 때
                    boxWeight += bookWeight ;    // 박스에 책무게를 더한다.
                } else {  // 박스무게 + 책 무게 = 최대 무게보다 많을 때
                    boxCnt++; // 박스의 개수 증가
                    boxWeight = bookWeight ; // 박스에 책무게 대입
                }
            }
        } else {
            boxCnt = 0;
        }

        System.out.println(boxCnt);

    }
}
