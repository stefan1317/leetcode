package org.example.problems;

import java.util.Arrays;
import java.util.List;

public class Jenea {
    public static void main(String[] args) {
        List<Integer> a_keys = Arrays.asList(1, 3, 5);
        List<Double> a_values = Arrays.asList(10.5, 20.0, 30.75);

        List<Integer> b_keys = Arrays.asList(2, 3, 6);
        List<Double> b_values = Arrays.asList(15.0, 25.5, 35.25);

        System.out.println(cosine_similarity(a_keys, a_values, b_keys, b_values));
    }

    public static double cosine_similarity(List<Integer> a_keys,
                                           List<Double> a_values,
                                           List<Integer> b_keys,
                                           List<Double> b_values) {

       return calculateDotProduct(a_keys, a_values, b_keys, b_values) / (calculateMag(a_values) * calculateMag(b_values));
    }

    public static double calculateDotProduct(List<Integer> a_keys,
                                             List<Double> a_values,
                                             List<Integer> b_keys,
                                             List<Double> b_values) {

        double result = 0;
        int minSize = Integer.min(a_keys.size(), b_keys.size());

        if (a_keys.size() <= b_keys.size()) {
            for (int i = 0; i < minSize; i++) {
                if (b_keys.contains(a_keys.get(i))) {
                    double valueA = a_values.get(i);
                    result +=  valueA * b_values.get(findIndex(b_keys, a_keys.get(i)));
                }
            }
        }

        if (a_keys.size() >= b_keys.size()) {
            for (int i = 0; i < minSize; i++) {
                if (a_keys.contains(b_keys.get(i))) {
                    double valueB = b_values.get(i);
                    result +=  valueB * a_values.get(findIndex(a_keys, b_keys.get(i)));
                }
            }
        }

        return result;
    }

    public static int findIndex(List<Integer> keys, Integer value) {
        for (int i = 0; i < keys.size(); i ++) {
            if (keys.get(i).equals(value)) {
                return i;
            }
        }
        return 0;
    }

    public static double calculateMag(List<Double> values) {
        double result = 0;

        for (Double value: values) {
            result += value * value;
        }
        return Math.sqrt(result);
    }
}
