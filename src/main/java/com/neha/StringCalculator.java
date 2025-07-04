package com.neha;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static int add(String intput_string) {
        int length_of_string=intput_string.length();
        if(length_of_string==0) return 0;
        String [] numbers=intput_string.split(",");
        int Sum=0;
        if(length_of_string==1) return parseInt(intput_string);
        if(length_of_string==3) return parseInt(numbers[0])+parseInt(numbers[1]);
        for(String number:numbers){
            Sum+=parseInt(number);
        }
        return Sum;
    }
}
