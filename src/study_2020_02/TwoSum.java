package study_2020_02;

import java.util.HashMap;

public class TwoSum {

  public static void main(String[] args) {
    TwoSum twoSome = new TwoSum();
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    twoSome.twoSum(nums, target);
  }

  public int[] twoSum(int[] nums, int target) {
    int[] answer = new int[2];
    for (int i = 0; i < nums.length; i++) {
      int temp = nums[i];
      for (int j = 0; j < nums.length; j++) {
        if (i == j) {
          continue;
        }
        if ((temp + nums[j]) == target) {
          answer[0] = i;
          answer[1] = j;
          return answer;
        }
      }
    }
    return null;
  }

  // 다른사람 풀이 leetcode
  public static int[] twoSum2(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] result = new int[2];

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        result[0] = map.get(target - nums[i]);
        result[1] = i;
        return result;
      }
      map.put(nums[i], i);
    }
    return null;
  }

}
