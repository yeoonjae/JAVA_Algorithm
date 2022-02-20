package study_2020_02.hackerRank.easy;

import java.util.Arrays;

public class BigSort {

  //  6
//  31415926535897932384626433832795
//  1
//  3
//  10
//  3
//  5
  public static void main(String[] args) {
    BigSort bigSort = new BigSort();
    String[] str = {"6", "31415926535897932384626433832795", "1", "3", "10", "3", "5"};
    System.out.println(Arrays.toString(bigSort.bigSorting(str)));
  }

  public String[] bigSorting(String[] unsorted) {

    Arrays.sort(unsorted, (x, y) -> {
      System.out.print("시작 arr : " + Arrays.toString(unsorted) + " x : " + x + " y : " + y);
      if (x.length() == y.length()) {
        System.out.print("   x.compareTo(y): " + x.compareTo(y) + "\n");
        return x.compareTo(y); // 자리수에 상관없이 첫째자리만 보고 오름차순 정렬
      } else {
        System.out.print("     x.length() - y.length(): " + (x.length() - y.length()) + "\n");
        return x.length() - y.length(); // 자리수에 상관없이 오름차순 정렬
      }
    });
    return unsorted;
  }

}
