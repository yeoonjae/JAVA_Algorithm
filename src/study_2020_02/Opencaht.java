package study_2020_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Opencaht {

  /**
   * 프로그래머스 - 오픈채팅방 (Lv.2)
   * */
  public static void main(String[] args) {
    Opencaht opencaht = new Opencaht();
    String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
        "Enter uid1234 Prodo", "Change uid4567 Ryan"};
    System.out.println(opencaht.solution(record));
  }

  public String[] solution(String[] record) {
    List<String> list = new ArrayList<>();
    Map<String, String> nickNameMap = new HashMap<>();
    for (int i = 0; i < record.length; i++) {
      String[] str = record[i].split(" ");
      if (str.length > 2) {
        nickNameMap.put(str[1], str[2]);
      }
    }
    for (int i = 0; i < record.length; i++) {
      String[] str = record[i].split(" ");
      if (str[0].equals("Enter")) {
        list.add(nickNameMap.get(str[1])+"님이 들어왔습니다.");
      } else if (str[0].equals("Leave")) {
        list.add(nickNameMap.get(str[1]) + "님이 나갔습니다.");
      }
    }
    return list.toArray(new String[list.size()]);
  }
}
