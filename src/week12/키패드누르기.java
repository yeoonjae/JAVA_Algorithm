package week12;

public class 키패드누르기 {

  public static void main(String[] args) {
    키패드누르기 quiz = new 키패드누르기();
    int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
    String hand = "left";
    System.out.println(quiz.solution(numbers, hand));
  }

  public String solution(int[] numbers, String hand) {
    String defaultHand = hand.equals("right") ? "R" : "L";
    int left = 10;
    int right = 12;
    int leftGap;
    int rightGap;
    StringBuffer br = new StringBuffer();
    for (int i = 0; i < numbers.length; i++) {
      int number = numbers[i];
      if (number == 1 || number == 4 || number == 7) {
        left = number;
        br.append("L");
      } else if (number == 3 || number == 6 || number == 9) {
        right = number;
        br.append("R");
      } else {
        if (number == 0) {
          number = 11;
        }
        leftGap = (Math.abs(number-left))/3 + (Math.abs(number-left))%3;
        rightGap = (Math.abs(number-right))/3 + (Math.abs(number-right))%3;
        if (leftGap == rightGap) {
          br.append(defaultHand);
          if (defaultHand.equals("R")) {
            right = number;
          }else{
            left = number;
          }
        } else if (leftGap > rightGap) {
          br.append("R");
          right = number;
        } else {
          br.append("L");
          left = number;
        }
      }
    }
    return br.toString();
  }
}
