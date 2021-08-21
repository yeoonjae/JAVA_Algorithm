package week02;

import java.util.Arrays;

public class Marathon {
    public static void main(String[] args) {
        // test01
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        // test02
//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};
//        solution2(participant,completion);
        System.out.println(solution2(participant,completion));
    }

    /*
    * 첫번째 방법 -> 테스트는 통과하였지만 효율성에서 틀림
    * */
   public static String solution(String[] participant, String[] completion) {
        String answer = "";
        for(int i = 0 ; i < completion.length;i++){
            for(int j = 0 ; j < participant.length;j++){
                if(participant[j].equals(completion[i])){
                    participant[j] = "";
                    break;
                }
            }
        }
        for(int i = 0 ; i < participant.length;i++){
            if(participant[i].length()>0){
                answer = participant[i];
            }

        }
        return answer;
    }

    /*
    * 두번째 풀이방법
    * */
    public static String solution2(String[] participant, String[] completion) {
        String answer = "";
        String result = "";
        /*
         문제 풀이 방식
         1. Arrays.sort()를 통해 정렬한다.
         2. 반복문을 실행하여 participant와 completion 다른 값을 return한다.
         */

        Arrays.sort(participant);
        Arrays.sort(completion);

        System.out.println(Arrays.toString(participant));
        System.out.println(Arrays.toString(completion));

        for (int i = 0 ; i<completion.length;i++) {
            if (!completion[i].equals(participant[i])) {
                answer = participant[i];
                break;
            }
        }

        if(answer.equals("")){
            answer = participant[participant.length - 1];
        }
        return answer;
    }
}
