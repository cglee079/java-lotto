package com.zuniorteam.lotto.dto;

public class MatchResult {

    private int matchCount;
    private long prize;
    private int winnerCount;

    public MatchResult(int matchCount, long prize, int winnerCount) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.winnerCount = winnerCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Long getPrize() {
        return prize;
    }

    public int getWinnerCount() {
        return winnerCount;
    }
}
