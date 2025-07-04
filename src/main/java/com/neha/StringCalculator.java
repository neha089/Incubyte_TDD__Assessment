package com.neha;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static int add(String intput_string) {
        if(intput_string.isEmpty()) return 0;
        String [] numbers=intput_string.split(",");
        int Sum=0;
        if(numbers.length==1) return parseInt(numbers[0]);
        if(numbers.length==2) return parseInt(numbers[0])+parseInt(numbers[1]);
        for(String number:numbers){
            Sum+=parseInt(number);
        }
        return Sum;
    }
}
