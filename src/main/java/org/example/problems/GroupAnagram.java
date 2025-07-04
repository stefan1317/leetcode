package org.example.problems;

import java.util.*;

public class GroupAnagram {
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

    public Map<String, Integer> constructAnagram(String str) {
        HashMap<String, Integer> chars = new HashMap<>();

        for (char c : str.toCharArray()) {
            String cStr = String.valueOf(c);
            if (chars.containsKey(cStr)) {
                chars.put(cStr, chars.get(cStr) + 1);
            } else {
                chars.put(cStr, 1);
            }
        }
        return chars;
    }

    private List<List<String>> groupAnagram(String[] strs) {
        Map<Map<String, Integer>, List<String>> result = new HashMap<>();

        for (String s : strs) {
            Map<String, Integer> chars = constructAnagram(s);

            if (result.containsKey(chars)) {
                List<String> newList = new ArrayList<>(result.get(chars));
                newList.add(s);

                result.put(chars, newList);
            } else {
                result.put(constructAnagram(s), List.of(s));
            }
        }
        return new ArrayList<>(result.values());
    }
}
