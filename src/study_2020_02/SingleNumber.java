package study_2020_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SingleNumber {

  public static void main(String[] args) {
    SingleNumber singleNumber = new SingleNumber();
    int[] nums = {4, 1, 2, 1, 2};
    singleNumber.singleNumber(nums);

  }

  public int singleNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      int i = map.getOrDefault(num, 0);
      map.put(num, i + 1);
    }
    System.out.println(map);
    List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
    int result = 0;
    for (Entry<Integer, Integer> value : list) {
      if (value.getValue() == 1) {
        result = value.getKey();
      }
    }
    return result;
  }

  // 다른사람 풀이 (xor) leetcode
  public int singleNumber2(int[] nums) {
    int x=0;
    for(int y:nums)
      x^=y;
    return x;
  }
}
