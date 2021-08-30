package week02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class 기능구현 {

    public static void main(String[] args) {

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] progresses2 = {93, 30, 55};
        int[] speeds = {1, 1, 1, 1, 1, 1};  // [1,3,2]
        int[] speeds2 = {1, 30, 5};  // [1,2]
        기능구현 a = new 기능구현();
        System.out.println(Arrays.toString(a.solution(progresses2, speeds2)));
    }

    public int[] solution(int[] progresses, int[] speeds) {

        // 큐 이용하기
        Queue<Integer> q = new LinkedList<>();

        // 큐에 계산 된 값 넣기
        for (int i = 0; i < progresses.length; i++) {
            int temp = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                temp++;
            }
            q.add(temp);
        }
        System.out.println(q);
        // answer에 담을 list생성
        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        // 첫번째 값
        int n = q.poll();
        while (!q.isEmpty()) {
            // 두번째 값
            int temp = q.poll();
            // 첫번째 값과 두번째 값 비교 첫번째 값 안에 속해있으면 cnt++
            if (n >= temp) {
                cnt++;
            } else {
                n = temp;
                list.add(cnt);
                cnt = 1;
            }
        }
        // 반복문이 끝났을 때 list에 담기
        list.add(cnt);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
