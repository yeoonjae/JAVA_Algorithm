package week05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class 베스트앨범 {


    /*
    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    */
    public static void main(String[] args) {
        베스트앨범 best = new 베스트앨범();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(best.solution(genres, plays)));
    }

    public int[] solution(String[] genres, int[] plays) {

        // index - 장르 hashMap 생성
        Map<Integer, String> genresMap = new HashMap<>();
        // index - 재생수 hashMap 생성
        Map<Integer, Integer> playsMap = new HashMap<>();

        // 데이터 넣기
        for (int i = 0; i < genres.length; i++) {
            genresMap.put(i, genres[i]);
            playsMap.put(i, plays[i]);
        }

        // 장르 hashSet에 저장
        Set<String> set = new HashSet<>();
        for (int i = 0; i < genres.length; i++) {
            set.add(genres[i]);
        }


        // 장르 - 합계를 저장할 hashMap 생성 및 데이터 저장
        Map<Integer, String> totalMap = new HashMap<>();
        for (String str : set) {
            String temp = str;
            int sum = 0;
            for (Entry<Integer, String> key : genresMap.entrySet()) {
                if (key.getValue().equals(temp)) {
                    sum += playsMap.get(key.getKey());
                }
            }
            totalMap.put(sum, temp);
        }
        
        //플레이 횟수 오름차순 정렬 정렬
        TreeMap sort = new TreeMap(totalMap);
        String[] sortArr = new String[set.size()];
        int index = 0;
        for(Object o : sort.keySet()){
            sortArr[index] = sort.get(o).toString();
            index++;
        }

        // 플레이 된 노래 고유번호
        List<Integer> indexPlay = new ArrayList<Integer>();
        // 장르 수만큼 반복
        for(int i = sortArr.length-1; i >= 0; i--){
            // 장르별 개수를 셀 변수
            int cnt = 0;
            for(int key : genresMap.keySet()){
                if(sortArr[i].equals(genresMap.get(key))){
                    cnt++;
                }
            }

            int[] temp = new int[cnt];
            int k = 0;
            for(int key2 : genresMap.keySet()){
                if(sortArr[i].equals(genresMap.get(key2))){
                    // 만든 배열의 값에 플레이 된 개수를 넣는다 (고유번호로)
                    temp[k] = playsMap.get(key2);
                    k++;
                }
            }

            // 배열의 길이가 1개 이상이라면 오름차순 정렬
            if(temp.length != 1){
                Arrays.sort(temp);
                // 제일 큰 값, 두번째로 큰 값만 저장
                for(int j = temp.length - 1; j >= temp.length - 2; j--){
                    for(int p : playsMap.keySet()){
                        if(temp[j] == playsMap.get(p)){
                            // 값 저장
                            indexPlay.add(p);
                            // 중복으로 저장하지 않게 값 0으로 변경
                            playsMap.put(p, 0);
                            break;
                        }
                    }
                }
            }else{
                for(int p : playsMap.keySet()){
                    if(temp[0] == playsMap.get(p)){
                        // 값 저장
                        indexPlay.add(p);
                        // 중복으로 저장하지 않게 값 0으로 변경
                        playsMap.put(p, 0);
                        break;
                    }
                }
            }
        }

        int[] answer = new int[indexPlay.size()];

        for(int i = 0; i < indexPlay.size(); i++){
            answer[i] = indexPlay.get(i);
        }



        return answer;
    }
}
