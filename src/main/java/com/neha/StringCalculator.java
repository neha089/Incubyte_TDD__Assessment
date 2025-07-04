package com.neha;

import java.util.LinkedHashSet;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static int add(String input_string)  {
        if(input_string.isEmpty()) return 0;
        int Sum=0;
        String[] numbers;
        String delimiter=",|\n";
        String string_of_number=input_string;
        if(string_of_number.startsWith("//")){
            int index_of_newline=string_of_number.indexOf("\n");
            delimiter=string_of_number.substring(2,index_of_newline);
            string_of_number=string_of_number.substring(index_of_newline+1);
        }
        numbers=string_of_number.split(delimiter);
        Set<String> negative_numbers=new LinkedHashSet<>();

            for (String number : numbers) {
                number=number.trim();
                int value=parseInt(number);
                if(value<0) {
                    negative_numbers.add(number);
                    continue;
                }
                else if(value>1000){
                    continue;
                }
                else {
                    Sum += parseInt(number);
                }
            }
        if(!negative_numbers.isEmpty()){
            String negativeNumbersList = String.join(", ", negative_numbers);
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbersList);
        }
        return Sum;
    }
}
