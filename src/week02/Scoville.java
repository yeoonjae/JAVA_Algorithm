package week02;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Scoville {

    //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    public static void main(String[] args) {
        int[] q = {1, 2, 8, 3, 9, 10, 12};
        int k = 7;
        Scoville sc = new Scoville();
        System.out.println(sc.solution2(q, k));
    }

    // 힙정렬..? 큐를 사용하지 않고 풀어본 문제 테스트 케이스는 2개 통과 못했고 효율성은 모두 통과못했다.
    public int solution1(int[] scoville, int K) {
        int answer = 0;

        for (int i = 0; i < scoville.length; i++) {
            Arrays.sort(scoville);
            if (scoville[i] >= K) {
                break;
            }
            scoville[i] = scoville[i] + (scoville[i + 1] * 2);
            answer++;
        }

        return answer;
    }

    // 큐를 사용해야한다는 것을 알고 큐를 사용하여 풀었다.
    public int solution2(int[] scoville, int k) {
        int answer = 0;

        Queue<Integer> q = new PriorityQueue<>();
        for (int n : scoville) {
            q.offer(n);
        }

        while (q.peek() < k) {
            if (q.size() == 1) {
                return -1;
            }

            q.offer(q.poll() + (q.poll() * 2));
            answer++;
        }

        return answer;
    }
}

