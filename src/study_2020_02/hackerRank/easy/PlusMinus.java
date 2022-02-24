package study_2020_02.hackerRank.easy;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class PlusMinus {

  public static void main(String[] args) {

    List<Integer> arr = List.of(1, 1, 0, -1, -1);
    solution(arr);
  }
  public static void solution(List<Integer> arr) {
    int[] result = new int[3];
    for (int i = 0; i < arr.size(); i++) {
      if(arr.get(i) < 0) result[1]++;
      else if(arr.get(i) > 0) result[0]++;
      else result[2]++;
    }
    String[] answer = new String[3];
    for (int i = 0; i < result.length; i++) {
      double temp = (double) result[i] / arr.size();
      answer[i] = String.format("%.6f", temp);
      System.out.println(answer[i]);
    }

  }

}
