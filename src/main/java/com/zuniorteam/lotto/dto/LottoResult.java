package com.zuniorteam.lotto.dto;

import java.util.List;


public class LottoResult {

    private final List<MatchResult> results;
    private final double winPercent;

    public LottoResult(double winPercent, List<MatchResult> results) {
        this.winPercent = winPercent;
        this.results = results;
    }

    public List<MatchResult> getResults() {
        return results;
    }

    public double getWinPercent() {
        return winPercent;
    }
}
