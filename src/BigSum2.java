import java.util.Scanner;

public class BigSum2 {
    public static void main(String[] args) {
//        String a = "9223372036854775807";
//        String b = "9223372036854775808";
//        String b = "92233s72036854775";
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        // 두 배열의 길이 비교
        int defaultLength; // 기준 배열 생성 길이
        if (a.length() > b.length()) {
            // 맨 앞의 자리수가 10이 넘어갈 때를 대비해 +1로 배열 길이를 잡는다.
            defaultLength = a.length()+1;
        }else{
            defaultLength = b.length()+1;
        }

        char[] aArr = new char[defaultLength];
        char[] bArr = new char[defaultLength];

        int miuA = defaultLength - a.length();
        int miuB = defaultLength - b.length();

        // (기준길이 - a배열 길이) != 0
        if(miuA != 0){
            // (기준길이 - a배열 길이)만큼 배열의 값에 0을 세팅
            for (int j = 0; j < miuA; j++) {
                aArr[j] = '0';
            }
            // 그 이후 배열에 차례대로 값 넣기
            for (int i = miuA; i < defaultLength; i++) {
                aArr[i] = a.charAt(i-miuA);
            }
        }else{
            aArr = a.toCharArray();
        }
        // (기준길이 - b배열 길이) != 0
        if(miuB != 0 ){
            // (기준길이 - b배열 길이)만큼 배열의 값에 0을 세팅
            for (int j = 0; j < miuB; j++) {
                bArr[j] = '0';
            }
            // 그 이후 배열에 차례대로 값 넣기
            for (int i = miuB; i < defaultLength; i++) {
                bArr[i] = b.charAt(i-miuB);
            }
        }else{
            bArr = b.toCharArray();
        }

        // 합계 변수 선언
        int sumVal = 0;
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i < defaultLength+1; i++) {
            // 맨 뒤부터 더해야 하니까 생성한 배열의 수 -1이 index
            int index = defaultLength-i;
            int aInt = Character.getNumericValue(aArr[index]);
            int bInt = Character.getNumericValue(bArr[index]);
            // 숫자 합계
            sumVal = aInt + bInt;
            // 합계가 10 이상일 때
            if (sumVal > 9) {
                // 현재 index의 앞의 값에 +1을 해준다.
                aArr[index-1] = (char) (aArr[index-1]+1);
                // 10으로 나눈 나머지 값 buffer에 저장
                sb.append(sumVal%10);
            }else{
                sb.append(sumVal);
            }
        }
        // 문자열 뒤집기
        System.out.println(sb.reverse());
    }

}
