package com.neha;

import java.util.LinkedHashSet;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    private static String extractDelimiter(String delimiter_part) {
        if (delimiter_part.startsWith("[") && delimiter_part.endsWith("]")) {
            return delimiter_part.substring(1, delimiter_part.length() - 1);
        }
        return delimiter_part;
    }
    private static int parseAndSum(String[] numbers) {
        int sum = 0;
        Set<String> negativeNumbers = new LinkedHashSet<>();

        for (String number : numbers) {
            number = number.trim();
            int value = parseInt(number);
            if (value < 0) {
                negativeNumbers.add(number);
                continue;
            }
            if (value > 1000) {
                continue;
            }
            sum += value;
        }

        if (!negativeNumbers.isEmpty()) {
            String negativeNumbersList = String.join(", ", negativeNumbers);
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbersList);
        }

        return sum;
    }

    private static String[] splitNumbers(String input, String delimiter) {
        if (delimiter.equals(",|\n")) {
            return input.split(delimiter);
        } else {
            return input.split(java.util.regex.Pattern.quote(delimiter));
        }
    }


    public static int add(String input_string)  {
        if(input_string.isEmpty()) return 0;
        int Sum=0;
        String delimiter=",|\n";
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
