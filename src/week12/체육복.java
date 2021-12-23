package week12;

// 그리드 문제
public class 체육복 {

  // 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve
  public static void main(String[] args) {
    체육복 quiz = new 체육복();
    int[] lost = {1,2};
    int[] reserve = {2, 3};
    System.out.println(quiz.solution(3, lost, reserve));
  }

  // 테스트케이스 두개가 실패함 --> 추후 다시 보기
  public int solution(int n, int[] lost, int[] reserve) {
    int count = n - lost.length;

    for (int i = 0; i < lost.length; i++) {
      for (int j = 0; j < reserve.length; j++) {
        if (lost[i] == reserve[j]) {
          count++;
          lost[i] = -10;
          reserve[j] = -10;
          break;
        }
      }
    }
    for (int k : lost) {
      for (int j = 0; j < reserve.length; j++) {
        if (k == (reserve[j] - 1) || k == (reserve[j] + 1)) {
          count++;
          reserve[j] = -10;
          break;
        }
      }
    }
    return count;
  }

}
