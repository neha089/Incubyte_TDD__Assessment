package com.neha;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static int add(String intput_string) {
        if(intput_string.isEmpty()) return 0;
        String [] numbers=intput_string.split(",");
        int Sum=0;
        for(String number:numbers){
            Sum+=parseInt(number);
        }
        return Sum;
    }
}
