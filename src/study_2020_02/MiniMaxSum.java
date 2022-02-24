package study_2020_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MiniMaxSum {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(List.of(1, 3, 5, 7, 9));
    int[] arr = new int[5];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < 5; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    miniMaxSum(arr);

    scanner.close();
    solution(list);
  }

  public static void solution(List<Integer> arr) {
    arr.sort(Comparator.naturalOrder());
    long minSum = 0L;
    long maxSum = 0L;

    for (int i = 0; i < arr.size(); i++) {
      long compSum = 0L;

      for (int j = 0; j < arr.size(); j++) {
        if (i != j) {
          compSum += arr.get(j);
        }
      }
      if (i == 0) {
        minSum = compSum;
        maxSum = compSum;
      } else {
        if (minSum > compSum) {
          minSum = compSum;
        }

        if (maxSum < compSum) {
          maxSum = compSum;
        }
      }
    }
    System.out.println(minSum + " " + maxSum);
  }

  static void miniMaxSum(int[] arr) {
    long minSum = 0L;
    long maxSum = 0L;

    for (int i = 0; i < arr.length; i++) {
      long compSum = 0L;

      for (int j = 0; j < arr.length; j++) {
        if (i != j) {
          compSum += arr[j];
        }
      }

      if (i == 0) {
        minSum = compSum;
        maxSum = compSum;
      } else {
        if (minSum > compSum) {
          minSum = compSum;
        }

        if (maxSum < compSum) {
          maxSum = compSum;
        }
      }
    }

    System.out.println(minSum + " " + maxSum);

  }

}
