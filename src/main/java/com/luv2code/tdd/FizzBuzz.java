package com.luv2code.tdd;

public class FizzBuzz {

    public static String computer(int number) {
        String result = null;
        if(number%3==0 && number%5==0) {
            result = "FizzBuzz";
        }
        else if (number%3==0) {
            result = "Fizz";
        }
        else if(number%5==0) {
            result = "Buzz";
        }
        return result == null ? ""+ number : result;
    }
}
