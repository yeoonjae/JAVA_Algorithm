package study_2020_02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BigNumber {

  public static void main(String[] args) {
    BigNumber bigNumber = new BigNumber();

    int[] numbers = {3, 30, 34, 5, 9};
    System.out.println(bigNumber.solution(numbers));
  }

  private static List<Integer> list = new ArrayList<>();

  public String solution(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      createString(0, numbers, String.valueOf(numbers[i]));
    }
    Collections.sort(list, Collections.reverseOrder());

    System.out.println(list);
    return null;
  }

  private void createString(int index, int[] numbers, String str) {
    if (index == numbers.length -1) {
      list.add(Integer.parseInt(str));
      return;
    }
    for (int j = index; j < numbers.length; j++) {
      if (index == j) {
        continue;
      }
      createString(index + 1, numbers, str + String.valueOf(numbers[j]));
    }
  }
}
