package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.dto.GameResult;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoCalculator {

    private static final Map<Integer, Long> WIN_MONEYS;

    static {
        final HashMap<Integer, Long> winMoneys = new HashMap<>();

        winMoneys.put(3, 5000L);
        winMoneys.put(4, 50000L);
        winMoneys.put(5, 1500000L);
        winMoneys.put(6, 200000000000L);

        WIN_MONEYS = Collections.unmodifiableMap(winMoneys);
    }

    public static GameResult calculate(Map<Integer, Integer> results, int insertedMoney){

        return new GameResult(results, 0);

    }


}
