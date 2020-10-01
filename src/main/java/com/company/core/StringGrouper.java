package com.company.core;

import java.util.ArrayList;
import java.util.List;

public class StringGrouper {

    public static void main(String... arg) {
        String input1 = "1 54 85 678 9099 23 6";
        String input2 = "abc uzh o ops we la q";

        final List<String> process = process(2, input2);
        process.forEach(System.out::println);
    }

    private static List<String> process(int interval, String input) {
        List<String> result = new ArrayList<>();

        final String inputString = input.replaceAll("\\s+", "");

        int index = 0;
        while (index < inputString.length()) {
            if (index == 0) {
                result.add(inputString.substring(index, interval));
            } else {
                if (index + interval >= inputString.length()) {
                    result.add(inputString.substring(index, inputString.length()));
                    break;
                }
                result.add(inputString.substring(index, index + interval));
            }
            index = index + interval;
        }
        return result;
    }
}
