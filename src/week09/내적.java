package week09;

public class 내적 {

    public static void main(String[] args) {
        내적 quiz = new 내적();
        int[] a = {-1,0,1};
        int[] b = {1,0,-1};
        System.out.println(quiz.solution(a, b));
    }
    public int solution(int[] a, int[] b) {

        int sum = 0 ;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] * b[i]);
        }
        return sum;
    }
}
