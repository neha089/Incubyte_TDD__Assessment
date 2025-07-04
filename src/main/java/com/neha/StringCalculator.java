package com.neha;

import java.util.LinkedHashSet;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|\n";

    private static String extractDelimiter(String delimiter_part) {
        if (delimiter_part.startsWith("[") && delimiter_part.endsWith("]")) {
            StringBuilder combinedDelimiter = new StringBuilder();
            int i = 0;
            while (i < delimiter_part.length()) {
                int start = delimiter_part.indexOf('[', i);
                int end = delimiter_part.indexOf(']', start);
                if (start == -1 || end == -1) {
                    throw new IllegalArgumentException("Invalid custom delimiter format");
                }
                String delim = delimiter_part.substring(start + 1, end);
                if (combinedDelimiter.length() > 0) combinedDelimiter.append("|");
                combinedDelimiter.append(java.util.regex.Pattern.quote(delim));
                i = end + 1;
            }
            return combinedDelimiter.toString();
        }
        return java.util.regex.Pattern.quote(delimiter_part); // for single-char custom
    }

    private static int parseAndSum(String[] numbers) {
        int sum = 0;
        Set<String> negativeNumbers = new LinkedHashSet<>();

        for (String number : numbers) {
            number = number.trim();
            if (number.isEmpty()) continue;
            int value = parseInt(number);
            if (value < 0) {
                negativeNumbers.add(number);
            } else if (value <= 1000) {
                sum += value;
            }
        }

        if (!negativeNumbers.isEmpty()) {
            String negativeNumbersList = String.join(", ", negativeNumbers);
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbersList);
        }

        return sum;
    }
    private static String[] splitNumbers(String input, String delimiter) {
        return input.split(delimiter);
    }
    public static int add(String input_string)  {
        if(input_string.isEmpty()) return 0;
        String delimiter = DEFAULT_DELIMITER;
        String string_of_number=input_string;
        if (string_of_number.startsWith("//")) {
            int index_of_newline = string_of_number.indexOf("\n");
            String delimiter_part = string_of_number.substring(2, index_of_newline);
            delimiter = extractDelimiter(delimiter_part);
            string_of_number = string_of_number.substring(index_of_newline + 1);
        }
        String[] numbers = splitNumbers(string_of_number, delimiter);
        return parseAndSum(numbers);

    }
}
