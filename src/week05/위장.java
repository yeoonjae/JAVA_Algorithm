package week05;

import java.util.HashMap;
import java.util.Map;

public class 위장 {

    public static void main(String[] args) {
        위장 start = new 위장();
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"},
            {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"},
            {"smoky_makeup", "face"}};
        System.out.println(start.solution(clothes));
    }

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], 1);
            } else {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
        }

        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }

        return answer - 1;
    }
}
