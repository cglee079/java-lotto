package com.zuniorteam.lotto.dto;

import com.zuniorteam.lotto.core.Prize;

public class MatchResult {

    private int matchCount;
    private boolean hasBonus;
    private long prizeMoney;
    private int lottoCount;

    public MatchResult(Prize prize, int lottoCount) {
        this.matchCount = prize.getMatchCount();
        this.hasBonus = prize.hasBonus();
        this.prizeMoney = prize.getMoney().amount();
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
