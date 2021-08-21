import java.util.Arrays;
import java.util.Comparator;

public class ArrayQuiz2 {


    public static void main(String[] args) {
        ArrayQuiz2 test = new ArrayQuiz2();
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(test.solution(arr));

    }
    public String solution(int[] numbers) {
        String answer = "";

        String[] sNumbers = new String[numbers.length];

        for(int i=0; i<numbers.length; i++){
            sNumbers[i] = numbers[i] + "";
        }

        Arrays.sort(sNumbers, new Comparator<String>(){
            public int compare(String n1, String n2){

                System.out.println("n1 = " + n1);
                System.out.println("n2 = " + n1);

                System.out.println((n2+n1).compareTo(n1+n2));

                // 더해서 큰 값 만드는 내림 차순
                return (n2+n1).compareTo(n1+n2);
            }
        });

        for(int i=0; i<sNumbers.length; i++){
            answer += sNumbers[i];
        }

        // "000" 과 같이 0이 여러번인 경우 제외
        if(answer.startsWith("0"))
            answer = "0";

        return answer;
    }
}
