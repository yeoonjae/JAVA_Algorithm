import java.util.Arrays;

public class k번째_수 {
    public static void main(String[] args) {

        k번째_수 k = new k번째_수();
        int[] arr ={1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};

        System.out.println(Arrays.toString(k.soultionTest2(arr,commands)));
    }

    public int[] soultionTest(int[] arrays, int[][] commands) {
        int[] answers = new int[commands.length];
        int cnt = 0;

        for (int i = 0; i < commands.length;i++) {

            int[] temp = Arrays.copyOfRange(arrays,commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answers[i] = temp[commands[i][2]-1];
        }
        System.out.println(Arrays.toString(answers));
        return answers;
    }

    public int[] soultionTest2(int[] arrays, int[][] commands) {
        int[] answers = new int[commands.length];

        for(int i = 0; i < commands.length;i++){

            int startIndex = commands[i][0];
            int endIndex = commands[i][1];
            int selectIndex = commands[i][2];

            int[] temp = new int[endIndex - startIndex +1];
            int n = 0;
            for (int j = startIndex-1; j < endIndex; j++) {
                temp[n] = arrays[j];
                n++;
            }
            Arrays.sort(temp);
            answers[i] = temp[selectIndex-1];
        }

        return answers;
    }
}
