package study_2020_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10798 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[][] charArr = new char[5][15];
    for (int i = 0; i < charArr.length; i++) {
      String str = br.readLine();
      for (int j = 0; j < str.length(); j++) {
        charArr[i][j] = str.charAt(j);
      }
    }

    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < charArr.length; j++) {
        if (charArr[j][i] == 0) {
          continue;
        }
        System.out.print(charArr[j][i]);
      }
    }
  }
}
