package week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Printer {

    public static void main(String[] args) {
//        int[] priorities = {1, 1, 9, 1, 1, 1}; ==> 5
//        int location = 0;
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        Printer printer = new Printer();
        System.out.println(printer.solution(priorities, location));
    }

    public int solution(int[] priorities, int location) {
        int answer = 1;
        // location 위치를 어떻게 따라가지..
        int index = 0;

        Queue<Integer> priorityQ = new LinkedList<>();

        // 1. 큐에 데이터 넣기
        for (int i : priorities) {
            priorityQ.add(i);
        }

        // 2. 맨 앞에 위치한 값과 나머지값들을 비교
        while (!priorityQ.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == priorityQ.peek()) {
                    if (i == location) {
                        return answer;
                    }
                    priorityQ.poll();
                    answer++;
                }
            }
        }
        return answer;
//        for (int i = 0; i < priorities.length; i++) {
//            if (qu.peek() < priorities[i]) {
//                // 0번쨰 값을 qu맨뒤에 추가 및 0번째 값 제거
//                qu.offer(qu.poll());
//                System.out.println(qu);
//                // 몇 번 변경이 일어났는지 check
//                cnt++;
//            }
////                index = i;
////                for (int j = 0; j < index; j++) {
////                    qu.add(qu.get(0));
////                    qu.remove(0);
////                    cnt++;
////                }
////            }
//        }

    }
}
