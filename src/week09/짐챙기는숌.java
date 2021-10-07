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

        // 책의 무게
        int box = 0;
        int count = 1;
        if (bookCnt != 0) {

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < bookCnt; i++) {
                int book = Integer.parseInt(st.nextToken());
                if (book + box <= maxWeight) {  // 박스 무게 + 책 무게 =  최대 무게보다 적을 때
                    box += book;    // 박스에 책무게를 더한다.
                } else {  // 박스무게 + 책 무게 = 최대 무게보다 많을 때
                    count++; // 박스의 개수 증가
                    box = book; // 박스에 책무게 대입
                }
            }
        } else {
            count = 0;
        }

        System.out.println(count);

    }
}
