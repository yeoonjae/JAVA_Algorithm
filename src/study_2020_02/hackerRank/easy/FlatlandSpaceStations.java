package study_2020_02.hackerRank.easy;

import java.util.Arrays;

public class FlatlandSpaceStations {

  public static void main(String[] args) {
    int n = 5;
    int[] c = {0, 4};
    int i = flatlandSpaceStations(n, c);
    System.out.println(i);
  }

  static int flatlandSpaceStations(int n, int[] c) {
    Arrays.sort(c);
    System.out.println(Arrays.toString(c));
    int max = c[0];
    for (int i = 1; i < c.length; ++i) {
      int diff = c[i] - c[i - 1];
      System.out.println(diff);
      int length = diff / 2;
      max = Math.max(max, length);
    }
    max = Math.max(max, n - c[c.length - 1] - 1);
    System.out.println(max);
    return max;
  }
}
