package org.example.problems.arrays_hashing;

import java.util.HashMap;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("ana", "ana"));
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<String, Integer> sChars = new HashMap<>();
        HashMap<String, Integer> tChars = new HashMap<>();

        for (char c : s.toCharArray()) {
            String cStr = String.valueOf(c);
            if (sChars.containsKey(cStr)) {
                sChars.put(cStr, sChars.get(cStr) + 1);
            } else {
                sChars.put(cStr, 1);
            }
        }

        for (char c : t.toCharArray()) {
            String cStr = String.valueOf(c);
            if (tChars.containsKey(cStr)) {
                tChars.put(cStr, tChars.get(cStr) + 1);
            } else {
                tChars.put(cStr, 1);
            }
        }

        return sChars.equals(tChars);
    }
}
