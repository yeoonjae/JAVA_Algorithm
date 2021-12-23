package week12;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

  public static void main(String[] args) {

    프린터 quiz = new 프린터();
    int[] priorities = {1, 1, 9, 1, 1, 1};
    int location = 0;
    System.out.println(quiz.solution(priorities, location));

  }

  public int solution(int[] priorities, int location) {
    int answer = 0;
    Queue<Task> queue = new LinkedList<>();

    for (int i = 0; i < priorities.length; i++) {
      queue.add(new Task(i, priorities[i]));
    }

    while (!queue.isEmpty()) {
      Task current = queue.poll();
      boolean flag = false;
      for (Task t : queue) {
        if (t.priority > current.priority) {
          flag = true;
        }
      }
      // 우선순위 높은 게 있으면 뒤로 보냄
      if (flag) {
        queue.add(current);
      } else { // 없으면 추가하지 않고 인쇄 진행
        answer++;
        if (current.location == location) { // 만약 찾던 인쇄물인 경우 순서 리턴
          break;
        }
      }
    }
    return answer;
  }

  class Task {

    int location;
    int priority;

    public Task(int location, int priority) {
      this.location = location;
      this.priority = priority;
    }
  }
}
