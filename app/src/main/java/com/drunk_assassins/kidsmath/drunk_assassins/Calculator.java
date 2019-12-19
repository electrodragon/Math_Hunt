package com.drunk_assassins.kidsmath.drunk_assassins;

public class Calculator {
    public static int calculate(int v1, int v2, String op) {
        int result = 0;

        switch(op) {
            case "*":
                result = v1*v2;
                break;
            case "+":
                result = v1+v2;
                break;
            case "-":
                result = v1-v2;
                break;
        }

        return result;
    }
}
