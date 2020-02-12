package com.zuniorteam.lotto.dto;

import java.util.Map;

public class GameResult {

    private final Map<Integer, Integer> results;
    private final double winPercent;

    public GameResult(Map<Integer, Integer> results, double winPercent) {
        this.results = results;
        this.winPercent = winPercent;
    }
}
