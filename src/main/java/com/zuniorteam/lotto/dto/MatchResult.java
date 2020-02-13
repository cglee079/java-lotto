package com.zuniorteam.lotto.dto;

public class MatchResult {

    private int matchCount;
    private long prize;
    private int lottoCount;

    public MatchResult(int matchCount, long prize, int lottoCount) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.lottoCount = lottoCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Long getPrize() {
        return prize;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
