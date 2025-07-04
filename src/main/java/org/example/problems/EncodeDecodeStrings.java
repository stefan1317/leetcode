package org.example.problems;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    public static void main(String[] args) {
        List<String> strings = List.of("we","say",":","yes","!@#$%^&*()");

        String str = encode(strings);

        System.out.println(str);
        System.out.println(decode(str));
    }

    public static String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String str: strs) {
            stringBuilder.append(str.length()).append("#").append(str);
        }

        return stringBuilder.toString();
    }

    public static List<String> decode(String str) {
        List<String> strings = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        char[] chars = str.toCharArray();
        int i = 0;
        while (i < chars.length) {
//        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '#') {
                StringBuilder stringBuilder = new StringBuilder();
                int lastIndexForWord = i + Integer.parseInt(number.toString()) + 1;

                for (int j = i + 1; j < lastIndexForWord; j++) {
                    stringBuilder.append(chars[j]);
                }
                strings.add(stringBuilder.toString());
                i+= Character.getNumericValue(Integer.parseInt(number.toString()));
                number = new StringBuilder();
            } else {
                number.append(chars[i]);
                i++;
            }
        }
        return strings;
    }
}
