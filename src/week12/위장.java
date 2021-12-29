package week12;

import java.util.HashMap;
import java.util.Map;

public class 위장 {

  public static void main(String[] args) {
    위장 quiz = new 위장();
    String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"},
        {"green_turban", "headgear"}};
    System.out.println(quiz.solution(clothes));
  }

  public int solution(String[][] clothes) {
    Map<String, Integer> map = new HashMap<>();
    int answer = 0;
    /*
      풀이방법 : key : 의상의 종류, value : 의상의 이름
      만약 key가 존재한다 --> value + 1로 저장
      경우의 수를 구하려면... 개수를 곱한다..?
     */

    for (int i = 0; i < clothes.length; i++) {
      map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
    }
    for (String key : map.keySet()) {
      // 경우의 수 : (의상의 개수 + 1) * (의상의 개수 + 1) * (의상의 개수 + 1)
      answer *= map.get(key) + 1;
    }
    // 최소 한개의 옷을 입어야 하기 때문에 -1을 해준다.
    return answer - 1;
  }

}
