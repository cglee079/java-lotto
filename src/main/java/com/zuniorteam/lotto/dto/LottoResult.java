package com.zuniorteam.lotto.dto;

import java.util.List;
import java.util.Map;


public class LottoResult {

    private final List<MatchResult> results;
    private final double winPercent;

    public LottoResult(List<MatchResult> results, double winPercent) {
        this.results = results;
        this.winPercent = winPercent;
    }

    public List<MatchResult> getResults() {
        return results;
    }

    public double getWinPercent() {
        return winPercent;
    }
}
