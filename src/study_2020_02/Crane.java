package study_2020_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Crane {

  public static void main(String[] args) {
    Crane crane = new Crane();
    int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2},
        {3, 5, 1, 3, 1}};
    int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
    System.out.println(crane.solution(board, moves));

  }

  public int solution(int[][] board, int[] moves) {
    int answer = 0;
    int moveNumber = 0;
    Stack<Integer> stack = new Stack<>();
    for (int move : moves) {
      for (int j = 0; j < board.length; j++) {
        if (board[j][move - 1] != 0) {
          if (!stack.isEmpty() && stack.peek() == board[j][move - 1]) {
            stack.pop();
            answer += 2;
          } else {
            stack.push(board[j][move - 1]);
          }
          board[j][move - 1] = 0;
          break;
        }
      }
    }
    return answer;
  }

  // 다른사람 풀이
  public int solution2(int[][] board, int[] moves) {
    int answer = 0;
    Stack<Integer> stack = new Stack<>();
    for (int move : moves) {
      for (int j = 0; j < board.length; j++) {
        if (board[j][move - 1] != 0) {
          if (stack.isEmpty()) {
            stack.push(board[j][move - 1]);
            board[j][move - 1] = 0;
            break;
          }
          if (board[j][move - 1] == stack.peek()) {
            stack.pop();
            answer += 2;
          } else
            stack.push(board[j][move - 1]);
          board[j][move - 1] = 0;
          break;
        }
      }
    }
    return answer;
  }
}
