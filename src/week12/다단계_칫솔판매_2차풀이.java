package week12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔판매_2차풀이 {

  public static void main(String[] args) {
    다단계_칫솔판매_2차풀이 quiz = new 다단계_칫솔판매_2차풀이();
    String[] enrolls = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
    String[] referrals = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
    String[] sellers = {"young", "john", "tod", "emily", "mary"};
    int[] amounts = {12, 4, 2, 5, 10};
    System.out.println(Arrays.toString(quiz.solution(enrolls, referrals, sellers, amounts)));
  }

  static Map<String, String> map = new HashMap<>(); // enroll, refferal
  static Map<String, Integer> totalAmount = new HashMap<>(); // 이름 , 수익

  public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    int[] answers = new int[enroll.length];

    for (int i = 0; i < enroll.length; i++) {
      if (referral[i].equals("-")) {
        map.put(enroll[i], "center");
      } else {
        map.put(enroll[i], referral[i]);
      }
      totalAmount.put(enroll[i], 0);
    }
    for (int i = 0; i < seller.length; i++) {
      calculateRevenue(seller[i], amount[i] * 100);
    }
    for (int i = 0; i < enroll.length; i++) {
      answers[i] = totalAmount.get(enroll[i]);
    }
    return answers;
  }

  public static void calculateRevenue(String name, int amount) {
    String temp = name;
    int price = amount;
    while (true) {
      String parent = map.get(temp); // 추천인
      int revenue = (int) Math.ceil(price * 0.9); // 이익금
      int parentRevenue = price / 10;
      if (temp.equals("center") || price == 0) {
        break;
      }
      totalAmount.put(temp, totalAmount.get(temp) + revenue);
      price = parentRevenue;
      temp = parent;
    }
  }

  // 좀 더 깔끔하게 개선
  public static void calculateRevenue2(String name, int amount) {
    if (name.equals("center") || amount == 0) {
      return;
    }
    String parent = map.get(name); // 추천인
    int revenue = (int) Math.ceil(amount * 0.9); // 이익금
    int parentRevenue = amount / 10;
    totalAmount.put(name, totalAmount.get(name) + revenue);
    amount = parentRevenue;
    name = parent;
    calculateRevenue2(name, amount);
  }
}
