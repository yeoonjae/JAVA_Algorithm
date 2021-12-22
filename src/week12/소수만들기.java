package week12;

import java.util.HashSet;
import java.util.Set;

public class 소수만들기 {

  public static void main(String[] args) {
    소수만들기 quiz = new 소수만들기();
    int[] nums = {1,2,7,6,4};
    System.out.println(quiz.solution(nums)) ;
  }

  public int solution(int[] nums) {
    int sum = 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i+1; j < nums.length; j++) {
        for (int q = j+1; q < nums.length; q++) {
          sum = nums[i] + nums[j] + nums[q];
          if(checkDecimal(sum)) count++;
        }
      }
    }
    return count;
  }

  private boolean checkDecimal(int number) {
    boolean isDecimal = true;
    if (number < 2) {
      isDecimal = false;
    }

    if (number == 2) {
      isDecimal = true;
    }

    for (int i = 2; i < number; i++) {
      if(number % i == 0) isDecimal = false;
    }
    return isDecimal;
  }
}
