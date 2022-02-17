package study_2020_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 신고 결과 받기 - 프로그래머스 (Lv.1)
 */
public class UserDeclaration {

  public static void main(String[] args) {
    UserDeclaration userDeclaration = new UserDeclaration();
    String[] idList = {"muzi", "frodo", "apeach", "neo"};
//    String[] idList = {"con", "ryan"};
    String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
//    String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
    int k = 2;
    System.out.println(userDeclaration.solution(idList, report, k));

  }

  public int[] solution(String[] idList, String[] report, int k) {
    Set<String> set = new HashSet<>();
    Arrays.stream(report).forEach(value -> set.add(value));

    Map<String, Integer> countMap = new HashMap<>();
    Map<String, Integer> recordMap = new HashMap<>();

    String[] record2 = set.toArray(new String[set.size()]);
    for (int i = 0; i < record2.length; i++) {
      String[] str = record2[i].split(" ");
      countMap.put(str[1], countMap.getOrDefault(str[1], 0) + 1);
    }

    for (int i = 0; i < record2.length; i++) {
      String[] str = record2[i].split(" ");
      if (countMap.get(str[1]) >= k) {
        recordMap.put(str[0], recordMap.getOrDefault(str[0], 0) + 1);
      }
    }

    int[] answer = new int[idList.length];
    for (int i = 0; i < idList.length; i++)
      answer[i] = recordMap.getOrDefault(idList[i], 0);
    return answer;
  }
}
