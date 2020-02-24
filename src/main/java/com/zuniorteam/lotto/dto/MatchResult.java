package com.zuniorteam.lotto.dto;

public class MatchResult {

    private int matchCount;
    private boolean hasBonus;
    private long prizeMoney;
    private int lottoCount;

    public MatchResult(int matchCount, boolean hasBonus, long prizeMoney, int lottoCount) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prizeMoney = prizeMoney;
        this.lottoCount = lottoCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getHasBonus() {
        return hasBonus;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
