package com.zuniorteam.lotto.dto;

import java.util.List;


public class LottoResult {

    private final List<MatchResult> matchResults;
    private final double winPercent;

    public LottoResult(List<MatchResult> matchResults, double winPercent) {
        this.winPercent = winPercent;
        this.matchResults = matchResults;
    }

    public List<MatchResult> getMatchResults() {
        return matchResults;
    }

    public double getWinPercent() {
        return winPercent;
    }
}
