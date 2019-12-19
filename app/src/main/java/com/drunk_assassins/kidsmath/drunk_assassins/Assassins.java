package com.drunk_assassins.kidsmath.drunk_assassins;

import java.util.Random;

public class Assassins {

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }


}
