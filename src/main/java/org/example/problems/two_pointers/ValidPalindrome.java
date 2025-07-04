package org.example.problems.two_pointers;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();

        int i = 0;
        int j = chars.length - 1;

        if (chars.length == 1 || chars.length == 0) {
            return true;
        }

        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
