package com.neha;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static int add(String input_string) {
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
            for (String number : numbers) {
                Sum += parseInt(number);
            }
        return Sum;
    }
}
