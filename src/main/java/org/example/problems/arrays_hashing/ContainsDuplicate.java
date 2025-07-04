package org.example.problems.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1,2,3,2}));
    }

    public static boolean containsDuplicate(int[] numbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (int num : numbers) {
            if (!numberSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}
