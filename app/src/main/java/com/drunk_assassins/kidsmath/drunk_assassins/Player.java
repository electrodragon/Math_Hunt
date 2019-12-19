package com.drunk_assassins.kidsmath.drunk_assassins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    public static String defaultLevel = "0";
    public static String defaultScore = "0";

    public static String[] choices(String v1, String v2, String op) {
        int val1 = Integer.parseInt(v1);
        int val2 = Integer.parseInt(v2);

        List<Integer> myList = new ArrayList();
        myList.add(Calculator.calculate(val1, val2, op));
        val1 = (val1 > 1) ? val1 - 1 : val1 + 2;
        myList.add(Calculator.calculate(val1, val2, op));
        val2 = val2 + val1;
        myList.add(Calculator.calculate(val1, val2, op));
        Collections.shuffle(myList);

        return new String[] {String.valueOf(myList.get(0)), String.valueOf(myList.get(1)), String.valueOf(myList.get(2))};
    }

    public static String[] getQuestionValues(int lv) {
        int maxRand = (lv > 1) ? 10*lv : 10;

        int qV1 = Assassins.randInt(1, maxRand);
        int qV2 = Assassins.randInt(1, maxRand);

        if (qV1 == qV2) {
            qV2++;
        }

        String op = randOperator();

        int temp;

        if (op == "-") {
            if (qV1 < qV2) {
                temp = qV1;
                qV1 = qV2;
                qV2 = temp;
            }
        }

        return new String[] {String.valueOf(qV1), String.valueOf(qV2), op};
    }

    private static String randOperator() {
        String[] operators = {"+","-","*"};
        return operators[Assassins.randInt(0,2)];
    }

}
