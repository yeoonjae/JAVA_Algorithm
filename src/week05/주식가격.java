package week05;

import java.util.Arrays;

public class 주식가격 {

    public static void main(String[] args) {
        int[] price = {1, 2, 3, 2, 3};
        int[] result = {4, 3, 1, 1, 0};
        주식가격 start = new 주식가격();
        System.out.println(Arrays.toString(start.solution(price)));


    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }

            }
        }

        return answer;
    }


}
