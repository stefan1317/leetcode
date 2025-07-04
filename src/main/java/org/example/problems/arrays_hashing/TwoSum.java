package org.example.problems.arrays_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4}, 7)));
        System.out.println(Arrays.toString(twoSum2(new int[]{1, 2, 3, 4}, 7)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] sol = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    sol[0] = i;
                    sol[1] = j;
                }
            }
        }
        return sol;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> integerMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            integerMap.put(target - nums[i], i);
        }

        int[] sol = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (integerMap.containsKey(nums[i]) && i != integerMap.get(nums[i])) {
                sol[0] = i;
                sol[1] = integerMap.get(nums[i]);
            }
        }
        return sol;
    }
}
