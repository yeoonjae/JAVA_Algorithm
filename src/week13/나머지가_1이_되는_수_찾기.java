package week13;

public class 나머지가_1이_되는_수_찾기 {

  public static void main(String[] args) {
    나머지가_1이_되는_수_찾기 quiz = new 나머지가_1이_되는_수_찾기();
    System.out.println(quiz.solution(10));
  }
  public int solution(int n) {
    int answer = 0;
    for (int i = 1; i < n; i++) {
      if (n % i == 1) {
        answer = i;
        break;
      }
    }
    return answer;
  }
}
