package week12;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {

  public static void main(String[] args) {
    다리를_지나는_트럭 quiz = new 다리를_지나는_트럭();
    int bridgeLength = 100;
    int weight = 100;
    int[] truckWeights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    System.out.println(quiz.solution(bridgeLength, weight, truckWeights));
  }

  public int solution(int bridgeLength, int weight, int[] truckWeights) {
    Queue<Integer> onBridgeQueue = new LinkedList<>();

    int totalWeight = 0;
    int time = 0;
    for (int i : truckWeights) {
      while (true) {
        // 다리에 트럭이 없는 경우
        if (onBridgeQueue.isEmpty()) {
          onBridgeQueue.offer(i);
          totalWeight += i;
          time++;
          break;
        } else if (onBridgeQueue.size() == bridgeLength) {  // 다리에 트럭 추가가 되지 않은 경우
          totalWeight -= onBridgeQueue.poll();
        } else {  // 트럭추가 가능한 경우
          if (weight >= totalWeight + i) { // 최대무게를 넘지 않는 경우
            onBridgeQueue.offer(i);
            totalWeight += i;
            time++;
            break;
          } else {
            onBridgeQueue.offer(0);
            time++;
          }
        }
      }
    }
    return time + bridgeLength;
  }

}
