package study_2020_02.hackerRank.midium;

public class AppendAndDelete {

  public static void main(String[] args) {
    String s = "hackerhappy";
    String t = "hackerrank";
    int k = 9;
    solution(s, t, k);
  }

  public static void solution(String s, String t, int k) {
    char[] sArr = s.toCharArray();
    char[] tArr = t.toCharArray();

    int n = 0;
    int gaps = Math.abs(tArr.length - sArr.length);
    for (int i = 0; i < sArr.length; i++) {
      if ((sArr.length - i) == gaps || sArr[i] != tArr[i]) {
        n = i;
        break;
      }
    }
    int gap = tArr.length - n;
    int plusChar = sArr.length - n;
    if (k >= (gap + plusChar)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
