package org.example.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Apple {
    public static void main(String[] args) {
        int[] test = {1,2,2,3,3,3};
        System.out.println(containsDuplicate(test));
    }

    public static boolean containsDuplicate(int[] numbers) {
        Map<Integer, Integer> numberSet = new HashMap<>();

        for (int num : numbers) {
            if (numberSet.containsKey(num)) {
                numberSet.put(num, numberSet.get(num) + 1);
            } else {
                numberSet.put(num, 1);
            }
        }

        Iterator<Integer> iterator = numberSet.values().iterator();

        Integer first = iterator.next();

        while (iterator.hasNext()) {
            if (Objects.equals(first, iterator.next())) {
                return false;
            }
        }
        return true;
    }
}
