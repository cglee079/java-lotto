package com.zuniorteam.lotto.core;

import java.util.Random;

public class NumberGenerator {

    public static final Random RANDOM = new Random();

    public int rand(int size){
        return RANDOM.nextInt(size) + 1;
    }
}
