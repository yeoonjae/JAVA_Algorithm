package study_2020_02;

import java.util.ArrayList;
import java.util.List;

public class IceDrink {

  static int[][] array = {{0, 0, 1, 1, 0}, {0, 0, 0, 1, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}};

  public static void main(String[] args) {

    int count = 0;

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (dfs(i, j)) {
          count++;
        }
      }
    }
    System.out.println(count);
  }

  private static boolean dfs(int x, int y) {
    if (x <= -1 || x >= array.length || y >= array[x].length || y <= -1) {
      return false;
    }

    if (array[x][y] == 0) {
      array[x][y] = 1;
      dfs(x - 1, y);
      dfs(x, y - 1);
      dfs(x + 1, y);
      dfs(x, y + 1);
      return true;
    }
    return false;
  }

}
