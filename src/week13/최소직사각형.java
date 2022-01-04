package week13;

import java.util.Arrays;

public class 최소직사각형 {
  public static void main(String[] args) {
    최소직사각형 quiz = new 최소직사각형();
    int[][] sizes = {{60, 50}, {70, 30}, {60, 30}, {80, 40}};
    // 4000
    System.out.println(quiz.solution2(sizes));
  }
  public int solution(int[][] sizes) {
    int maxY = 0;
    int maxX = 0;
    for (int i = 0; i < sizes.length; i++) {
      Arrays.sort(sizes[i]);
      if (sizes[i][0] > maxX) {
        maxX = sizes[i][0];
      }
      if (sizes[i][1] > maxY) {
        maxY = sizes[i][1];
      }
    }
    return maxX * maxY;
  }

  public int solution2(int[][] sizes) {
    // {{60, 50}, {70, 30}, {60, 30}, {80, 40}};
    int max = 0;
    int min = 0;
    for (int i = 0; i < sizes.length; i++) {
      int tempMax = Math.max(sizes[i][0], sizes[i][1]);
      int tempMin = Math.min(sizes[i][0], sizes[i][1]);

      if(max < tempMax) max = tempMax;
      if(min < tempMin) min = tempMin;
    }
    return max * min;
  }
}
