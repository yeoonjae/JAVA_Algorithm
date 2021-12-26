package week12;

import java.util.Arrays;

public class 로또최고순위_최저순위 {

  public static void main(String[] args) {
    로또최고순위_최저순위 quiz = new 로또최고순위_최저순위();
    int[] lottos = {45, 4, 35, 20, 3, 9};
    int[] winNums = {20, 9, 3, 45, 4, 35};
    quiz.solution(lottos, winNums);
  }

  public int[] solution(int[] lottos, int[] winNums) {
    // 최고순위와 최저순위를 정한다.
    // 0은 알아볼 수 없는 숫자
    // 우선 winNums와 lottos와 일치하는 개수를 구한다.
    // 일치한 개수 + 0의 개수가 최고순위
    // 일치한 개수가 최저순위

    int correctCount = 0;
    int zero = 0;
    int[] rank = {6, 6, 5, 4, 3, 2, 1};

    for (int j = 0; j < lottos.length; j++) {
      for (int i = 0; i < winNums.length; i++) {
        if (winNums[i] == lottos[j]) {
          correctCount++;
        }
      }
      if (lottos[j] == 0) {
        zero++;
      }
    }
    int[] answer = new int[2];
    answer[0] = rank[correctCount+zero];
    answer[1] = rank[correctCount];

    return answer;
  }

}
