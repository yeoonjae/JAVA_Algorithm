package week13;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

  static Set<Integer> set = new HashSet<>();

  // 1. 모든 조합의 숫자를 만든다.
  /*
   * str : 지금까지 조합된 숫자
   * others : 여때까지 조합하지 않은 숫자
   * */
  public void recursive(String str, String others) {
    // 현재 조합을 set에 추가한다.
    if (!str.equals("")) {
      int n = Integer.parseInt(str);
      // 소수여부를 판단한다.
      if (isPrime(n)) {
        set.add(n);
      }
    }
    // 남은 숫자 중 한개를 더해서 새로운 조합을 만든다.
    for (int i = 0; i < others.length(); i++) {
      recursive(str + others.charAt(i), others.substring(0,i) + others.substring(i+1));
    }
  }

  public static void main(String[] args) {
    소수찾기 quiz = new 소수찾기();
    String number = "011";
    System.out.println(quiz.solution(number));
  }

  public int solution(String numbers) {
    recursive("", numbers);
    return set.size();
  }

  public static boolean isPrime(int number) {
    if (number == 2) {
      return true;
    }
    if (number < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
