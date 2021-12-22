package week12;

public class 문자열압축 {

  public static void main(String[] args) {
    문자열압축 quiz = new 문자열압축();
    String request = "xababcdcdababcdcd";
    int answer = quiz.solution(request);
    System.out.println("answer : " + answer);
  }

  public int solution(String s) {
    int answer = s.length();
    if(s.length() == 1) return 1;
    // 문자열의 절반이 넘어가면 압축이 불가능하기때문에 2를 나눈 값까지만 반복한다.
    for (int i = 1; i <= s.length() / 2; i++) {
      String tempStr = s.substring(0, i);  // 비교할 문자열 변수
      int count = 1;  // 중복된 숫자 카운트 변수
      String resultStr = "";  // 새롭게 정의된 문자열 저장 변수
      for (int j = i; j <= s.length(); j += i) {
        int from = j;
        int to = j + i;

        if (to > s.length()) to = s.length();
        if (tempStr.equals(s.substring(from, to))) {
          count++;
        } else {
          if (count != 1) {
            resultStr += count + "";
          }
          resultStr += tempStr;
          tempStr = s.substring(from, to);
          count = 1;
        }
      }
      // 나머지 값 처리
      if (count != 1) {
        resultStr += count + "";
      }
      resultStr += tempStr;
      answer = Math.min(resultStr.length(), answer);
    }
    return answer;
  }
}
