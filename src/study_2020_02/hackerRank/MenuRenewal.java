package study_2020_02.hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRenewal {

  public static void main(String[] args) {
    String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
    int[] course = {2, 3, 4};
    System.out.println(Arrays.toString(solution(orders, course)));
  }

  public static Map<String, Integer> map = new HashMap<>();

  public static String[] solution(String[] orders, int[] course) {
    for (int i = 0; i < orders.length; i++) {
      char[] charArr = orders[i].toCharArray();
      Arrays.sort(charArr);
      for (int j = 0; j < course.length; j++) {
        if (course[j] <= orders[i].length()) {
          combi(charArr, course[j], "", 0);
        }
      }
    }
    List<String> keySetList = new ArrayList<>(map.keySet());
    Collections.sort(keySetList, (o1, o2) -> map.get(o2) - map.get(o1));
    List<String> list = new ArrayList<>();
    for (int i = 0; i < course.length; i++) {
      int maxValue = 0;

      for (String key : keySetList) {
        if (map.get(key) >= 2 && key.length() == course[i]) {
          if (map.get(key) >= maxValue) {
            list.add(key);
            maxValue = map.get(key);
          }
        }
      }
    }
    Collections.sort(list);
    String[] answer = new String[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }
    return answer;
  }

  private static void combi(char[] charArr, int course, String result, int start) {
    if (course == 0) {
      // AC 0, AC 1
      map.put(result, map.getOrDefault(result, 0) + 1);
    }

    for (int i = start; i < charArr.length; i++) {
      combi(charArr, course - 1, result + charArr[i], i + 1);
    }
  }
}
