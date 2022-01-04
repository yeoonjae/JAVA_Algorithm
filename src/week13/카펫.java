package week13;

import java.util.Arrays;

public class 카펫 {

  public static void main(String[] args) {
    카펫 quiz = new 카펫();
    System.out.println(Arrays.toString(quiz.solution(24, 24)));
  }

  public int[] solution(int brown, int yellow) {
    // 브라운의 개수 : 2height + 2width - 4
    int[] answer = new int[2];
    int sum = brown + yellow;
    for (int i = 3; i < sum; i++) {
      for (int j = 3; j < sum; j++) {
        if (sum == i * j) {
          if (brown == ((i * 2) + (j * 2) - 4)) {
            answer[1] = j;
            answer[0] = i;
          }
        }
      }
    }
    return answer;
  }
}
