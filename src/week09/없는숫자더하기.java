package week09;


public class 없는숫자더하기 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        없는숫자더하기 quiz = new 없는숫자더하기();
        System.out.println(quiz.solution(numbers));
    }

    public int solution(int[] numbers) {
        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += i;
        }

        for (int number : numbers) {
            sum -= number;
        }
        return sum;
    }
}
