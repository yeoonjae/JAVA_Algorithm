package week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class PhoneBook {

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};

        PhoneBook book = new PhoneBook();
        System.out.println(book.solution3(phone_book3));
    }

    // 효율성을 통과 못한 나의 풀이,,, hash로 해봐야겠다,,
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for (int i = 0; i < phone_book.length; i++) {
            String temp = phone_book[i];
            for (int j = 0; j < phone_book.length; j++) {
                // 비교대상이 본인 자신일 땐 건너뜀
                if (i == j) {
                    continue;
                }
                // 다른 번호의 접두어로 쓰일경우 false 리턴
                if (phone_book[j].startsWith(temp)) {
                    answer = false;
                }
                ;
            }
        }
        return answer;
    }

    // hash를 이용해서 풀이하기 역시나 효율성 탈락..
    public boolean solution2(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], 0);
        }

        for (int i = 0; i < phone_book.length; i++) {
            String temp = phone_book[i];

            for (String entry : map.keySet()) {
                if (entry.equals(temp)) {
                    continue;
                }
                if (entry.startsWith(temp)) {
                    return false;
                }
            }
        }
        return answer;
    }

    // 다른 사람 풀이를 참고하여 풀어본 방법,, 통과
    public boolean solution3(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> map = new HashMap<>();
        Arrays.sort(phone_book);

        for (String book : phone_book) {
            map.put(book, book);
        }

        for (String str : phone_book) {

            for (int i = 0; i < str.length(); i++) {
                String temp = str.substring(0, i);
                if (map.containsKey(temp)) {
                    answer = false;
                }
            }
        }
        return answer;
    }

    // 다른사람들이 가장 많이 한 방법 처음에 startsWith을 생각하여 문제를 풀려했지만 아래의 방법으로는 생각을 못했다.
    public boolean solution4(String[] phone_book) {
        boolean answer = true;
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                // 양뱡향 검사 i랑 j이랑 검사
                if (phone_book[i].startsWith(phone_book[j])) {
                    answer = false;
                }
                // 양뱡향 검사 j랑 i랑
                if (phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                }
                ;
            }
        }
        return answer;
    }

}
