package study_2020_02;

import java.util.HashMap;
import java.util.Map;

public class NumberAndEnglishWord {

  /**
   * 프로그래머스 - 숫자 문자열과 영단어 (Lv.1)
   */
  public static void main(String[] args) {
    NumberAndEnglishWord numberAndEnglishWord = new NumberAndEnglishWord();
    String s = "one4seveneight";
    numberAndEnglishWord.solution(s);
  }

  public int solution(String s) {
    Map<String, Integer> map = new HashMap<>();
    String[] word = {"zero", "one","two","three","four","five","six","seven","eight","nine"};
    for (int i = 0; i < word.length; i++) {
      map.put(word[i], i);
    }

    for (int i = 0; i < word.length; i++) {
      if (s.contains(word[i])) {
        s = s.replace(word[i], String.valueOf(map.get(word[i])));
      }
    }
    return Integer.parseInt(s);
  }
}
