package aa;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(
                Arrays.toString(
                twoSum.twoSum(new int[]{2,7,11,15}, 9)));
    }
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> numsSet = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            int difference = target - num;
            if (numsSet.containsKey(difference)){
                return new int[]{numsSet.get(difference), i};
            }
            numsSet.put(nums[i], i);
        }
        return new int[]{0,0 };
    }
}
