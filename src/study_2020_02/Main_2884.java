package study_2020_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2884 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int hour = Integer.parseInt(st.nextToken());
    int minute = Integer.parseInt(st.nextToken());

    int resultMinute = minute - 45;
    if (resultMinute < 0) {
      hour = (hour == 0) ? 23 : hour-1;
      resultMinute = 60 - Math.abs(resultMinute);
    }

    System.out.println(hour + " "+resultMinute);

  }
}
