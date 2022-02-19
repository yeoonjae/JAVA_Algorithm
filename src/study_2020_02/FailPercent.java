package study_2020_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FailPercent {

  /**
   * 프로그래머스 - 실패율 (Lv.1)
   */
  public static void main(String[] args) {
    int n = 5;
    int[] stages = {2, 1, 2, 6, 2, 4, 3, 3}; // 3,4,2,1,5
    int n2 = 4;
    int[] stages2 = {4, 4, 4, 4, 4};  // 4,1,2,3

    FailPercent failPercent = new FailPercent();
    System.out.println();
    System.out.println(Arrays.toString(failPercent.solution(n, stages)));
  }

  public int[] solution(int n, int[] stages) {
    Map<Integer, Double> map = new HashMap<>();
    int[] answer = new int[n];
    List<Integer> list = Arrays.stream(stages).boxed().collect(Collectors.toList());
    for (int i = 1; i <= n; i++) {
      int tempSize = list.size();
      int count = 0;
      for (int j = list.size() - 1; j >= 0; j--) {
        if (list.get(j) == i) {
          count++;
          list.remove(j);
        }
      }
      map.put(i, (double) count / tempSize);
    }
    List<Entry<Integer, Double>> resultList = new ArrayList<>(map.entrySet());
    resultList.sort(Entry.comparingByValue());
    List<Integer> answers = new ArrayList<>();

    for (int i = 0; i < resultList.size(); i++) {
      if (resultList.get(i).getKey() < resultList.get(i + 1).getKey()) {

      }
    }
    System.out.println(resultList);
    for (int i = resultList.size() -1 ; i >= 0; i--) {
      System.out.println(resultList.get(i).getKey());
      answer[i] = resultList.get(i).getKey();
    }
    return answer;
  }
}
