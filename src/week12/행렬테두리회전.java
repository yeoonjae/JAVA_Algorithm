package week12;

import java.util.Arrays;

public class 행렬테두리회전 {

  public static void main(String[] args) {
    행렬테두리회전 quiz = new 행렬테두리회전();
    int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
    quiz.solution(6, 6, queries);
  }

  public int[] solution(int rows, int columns, int[][] queries) {
    int[] answer = new int[queries.length];
    // 행렬 저장
    int[][] matrix = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        matrix[i][j] = i * columns + j + 1;
      }
    }

    // 입력받은 배열값
    for (int i = 0; i < queries.length; i++) {
      int[] tempArr = queries[i];

      int y1 = tempArr[0] - 1;
      int x1 = tempArr[1] - 1;
      int y2 = tempArr[2] - 1;
      int x2 = tempArr[3] - 1;

      int tempValue = matrix[y1][x1];
      int min = tempValue;

      for (int j = y1; j < y2; j++) {
        matrix[j][x1] = matrix[j + 1][x1];
        if (min > matrix[j][x1]) {
          min = matrix[j][x1];
        }
      }
      for (int j = x1; j < x2; j++) {
        matrix[y2][j] = matrix[y2][j + 1];
        if (min > matrix[y2][j]) {
          min = matrix[y2][j];
        }
      }
      for (int j = y2; j > y1; j--) {
        matrix[j][x2] = matrix[j - 1][x2];
        if (min > matrix[j][x2]) {
          min = matrix[j][x2];
        }
      }
      for (int j = x2; j > x1; j--) {
        matrix[y1][j] = matrix[y1][j - 1];
        if (min > matrix[y1][j]) {
          min = matrix[y1][j];
        }
      }
      matrix[y1][x1 + 1] = tempValue;
      answer[i] = min;
    }
    return answer;
  }
}
