package week12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 모의고사 {

    public static void main(String[] args) {
        모의고사 mo = new 모의고사();
        int[] answers = {1, 2, 3, 4, 5};
//        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(mo.solution(answers)));
    }

    private int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;


        List<Integer> list = new ArrayList<>();
        list.add(cnt1);
        list.add(cnt2);
        list.add(cnt3);
        System.out.println(list);
        int index1 = 0, index2 = 0, index3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (index1 == arr1.length) index1 = 0;
            if (answers[i] == arr1[index1]) list.set(0,list.get(0)+1);

            if (index2 == arr2.length) index2 = 0;
            if (answers[i] == arr2[index2]) list.set(1,list.get(1)+1);;

            if (index3 == arr3.length) index3 = 0;
            if (answers[i] == arr3[index3]) list.set(2,list.get(2)+1);;

            index1++;
            index2++;
            index3++;
        }
        int maxValue = Collections.max(list);
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (maxValue == list.get(i)) {
                answerList.add(i + 1);
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
