package com.neha;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static int add(String input_string) {
        if(input_string.isEmpty()) return 0;
        int Sum=0;
        if(input_string.startsWith("//")){
            int index_of_newline=input_string.indexOf("\n");
            String delimiter=input_string.substring(2,index_of_newline);
            input_string=input_string.substring(index_of_newline+1);
            String numbers1[]=input_string.split(delimiter);
            for(String number:numbers1){
                Sum+=parseInt(number);
            }
        }
        else {
            String[] numbers = input_string.split("[,\\n]");

            for (String number : numbers) {
                Sum += parseInt(number);
            }
        }
        return Sum;
    }
}
