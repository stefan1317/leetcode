package org.example.problems;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
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
