package study_2020_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1924 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] monthArray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] dateArray = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int month = Integer.parseInt(st.nextToken());
    int day = Integer.parseInt(st.nextToken());

    int dayCount = 0;

    for (int i = 0; i < month - 1; i++) {
      dayCount += monthArray[i];
    }
    dayCount += day;

    System.out.println(dateArray[dayCount % 7]);
  }
}
