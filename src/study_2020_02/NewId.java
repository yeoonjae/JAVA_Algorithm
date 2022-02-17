package study_2020_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class NewId {

  /**
   * 카카오 신규 아이디 추천 - 프로그래머스 (Lv.1)
   * <p>
   * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다. 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를
   * 제거합니다. 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다. 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면
   * 제거합니다. 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다. 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를
   * 제외한 나머지 문자들을 모두 제거합니다. 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다. 7단계 new_id의
   * 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
   */
  public static void main(String[] args) {
    NewId newId = new NewId();
//    String originid = "...!@BaT#*..y.abcdefghijklm";
    String originid = "=.=";
    newId.solution(originid);
  }

  public String solution(String originId) {

    // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환
    originId = originId.toLowerCase(Locale.ROOT);
    System.out.println("1단계 : " + originId);

    // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
    List<Character> lists = new ArrayList<>();
    char[] chars = originId.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char temp = chars[i];
      if (temp == '-' || temp == '_' || temp == '.' || 'a' <= temp && temp <= 'z'
          || '0' <= temp && temp <= '9') {
        lists.add(temp);
      }
    }
    System.out.println("2단계 : " + lists);

    // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
    int n = 0;
    while (n < lists.size() - 1) {
      if (lists.get(n) == '.' && lists.get(n + 1) == '.') {
        lists.remove(n);
      } else {
        n++;
      }
    }
    System.out.println("3단계 : " + lists);

    // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거

    if (lists.get(0) == '.') {
      lists.remove(0);
    }
    if (!lists.isEmpty() && lists.get(lists.size() - 1) == '.') {
      lists.remove(lists.size() - 1);
    }

    // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입
    if (lists.isEmpty()) {
      lists.add('a');
    }
    System.out.println("5단계 : " + lists);

    // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
    // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
    if (lists.size() > 15) {
      while (lists.size() > 15) {
        lists.remove(lists.size() - 1);
      }
    }
    if (lists.get(lists.size() - 1) == '.') {
      lists.remove(lists.size() - 1);
    }
    System.out.println("6단계 : " + lists);

    // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입
    while (lists.size() <= 2) {
      lists.add(lists.get(lists.size() - 1));
    }
    System.out.println("7단계 : " + lists);

    StringBuilder sb = new StringBuilder();
    for (Character list : lists) {
      sb.append(String.valueOf(list));
    }

    return sb.toString();
  }

  // 다른 사람 풀이
  public String solution2(String new_id) {
    String answer = "";
    String temp = new_id.toLowerCase();

    temp = temp.replaceAll("[^-_.a-z0-9]","");
    System.out.println(temp);
    temp = temp.replaceAll("[.]{2,}",".");
    temp = temp.replaceAll("^[.]|[.]$","");
    System.out.println(temp.length());
    if(temp.equals(""))
      temp+="a";
    if(temp.length() >=16){
      temp = temp.substring(0,15);
      temp=temp.replaceAll("^[.]|[.]$","");
    }
    if(temp.length()<=2)
      while(temp.length()<3)
        temp+=temp.charAt(temp.length()-1);

    answer=temp;
    return answer;
  }
}
