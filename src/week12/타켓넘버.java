package week12;

public class 타켓넘버 {

  public static void main(String[] args) {
    타켓넘버 quiz = new 타켓넘버();
    int[] number = {1, 1, 1, 1, 1};
    System.out.println(quiz.solution(number, 3));
  }

  static int returnValue = 0;

  public int solution(int[] numbers, int target) {
    int answer = 0;
    int sum = 0;
    for (int i = 0; i < numbers.length; i++) {
      sum += numbers[i];
    }
    for (int i = 0; i < numbers.length; i++) {
      dfs(0, sum, numbers, target);
    }
    answer = returnValue;
    return answer;
  }

  public static void dfs(int start, int sum, int[] numbers, int target) {
    int[] plusMaius = {0, 1};
    if (start == numbers.length) {
      if (sum == target) {
        returnValue++;
      }
      return;
    }
    for (int i = 0; i < plusMaius.length; i++) {
      int value = plusMaius[i];
      if (value == 0) {
        sum += numbers[start];
      } else {
        sum -= numbers[start];
      }

      dfs(start + 1, sum, numbers, target);

      if (value == 0) {
        sum -= numbers[start];
      } else {
        sum += numbers[start];
      }
    }
    System.out.println(returnValue);
  }
}
