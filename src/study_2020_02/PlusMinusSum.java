package study_2020_02;

public class PlusMinusSum {

  public static void main(String[] args) {
    int[] absolutes = {1, 2, 3};
    boolean[] signs = {false, false, true};
    System.out.println(solution(absolutes, signs));

  }

  public static int solution(int[] absolutes, boolean[] signs) {
    int sum = 0;
    for (int i = 0; i < absolutes.length; i++) {
//      sum += absolutes[i] * (signs[i] ? 1 : -1);
      if (signs[i]) {
        sum += absolutes[i];
      } else {
        sum -= absolutes[i];
      }
    }
    return sum;
  }
}
