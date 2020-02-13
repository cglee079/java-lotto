package com.zuniorteam.lotto.dto;

public class MatchResult {

    private int matchCount;
    private long prize;
    private int numberOfWinner;

    public MatchResult(int matchCount, long prize, int numberOfWinner) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.numberOfWinner = numberOfWinner;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Long getPrize() {
        return prize;
    }

    public int getNumberOfWinner() {
        return numberOfWinner;
    }
}
