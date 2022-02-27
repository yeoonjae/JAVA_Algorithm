package study_2020_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2490 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = new String[3];
    String[] resultArr = {"D", "C", "B", "A", "E"};

    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int count = 0;
      while (st.asIterator().hasNext()) {
        if (st.nextToken().equals("1")) {
          count++;
        }
      }
      System.out.println(resultArr[count]);
    }
  }
}
