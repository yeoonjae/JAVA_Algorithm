package week12;

import java.util.HashMap;
import java.util.Map;

public class 다단계칫솔판매 {
  /*
    한 사람이 판매를 하면 판매자는 90%의 수익을, 추천인은 10%의 수익을 가지는 구조
    추천인의 추천인이 존재할 경우 추천인역시 10%의 수익을 자신을 추천해준 추천인에게 줘야한다. (재귀..?)
    center가 나올때까지 본인 90%, 추천인 10% 이익분배를 반복해야한다.
   */

  public static void main(String[] args) {
    다단계칫솔판매 quiz = new 다단계칫솔판매();
    String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
    String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};

    String[] seller = {"young", "john", "tod", "emily", "mary"};
    int[] amount = {12, 4, 2, 5, 10};

    quiz.solution(enroll, referral, seller, amount);

    int[] result = {360, 958, 108, 0, 450, 18, 180, 1080};
  }

  static Map<String, String> map = new HashMap<>();
  static Map<String, Integer> totalAmount = new HashMap<>();

  public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    int[] answer = new int[enroll.length];

    // key : 판매원 / value : 추천인
    for (int i = 0; i < enroll.length; i++) {
      if (referral[i].equals("-")) {
        map.put(enroll[i], "center");
      } else {
        map.put(enroll[i], referral[i]);
      }
      totalAmount.put(enroll[i], 0);
    }

    for (int i = 0; i < seller.length; i++) {
      loop(seller[i], amount[i] * 100);
    }

    for (int i = 0; i < enroll.length; i++) {
      answer[i] = totalAmount.get(enroll[i]);
    }

    return answer;
  }

  public static void loop(String name, int amount) {
    if (name.equals("center") || amount == 0) {
      return;
    }
    String parent = map.get(name);
    int revenue = (int) Math.ceil(amount * 0.9);
    int parentRevenue = amount - revenue;
    totalAmount.replace(name, totalAmount.get(name) + revenue);
    loop(parent, parentRevenue);
  }

}
