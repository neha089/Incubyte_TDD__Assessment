package com.neha;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static int add(String intput_string) {
        int length_of_string=intput_string.length();
        if(length_of_string==1) return parseInt(intput_string);
        return 0;
    }
}
