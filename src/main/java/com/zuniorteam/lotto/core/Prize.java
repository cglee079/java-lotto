package com.zuniorteam.lotto.core;


import com.zuniorteam.lotto.vo.PrizeRule;
import com.zuniorteam.lotto.vo.PrizeRule.BonusMatch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Prize {

    WINNER(1, new PrizeRule(6, BonusMatch.ANYWAY), 20000000000L),
    BONUS_WINNER(2, new PrizeRule(5, BonusMatch.MATCH), 30000000L),
    THIRD_PRIZE(3, new PrizeRule(5, BonusMatch.NO_MATCH), 1500000L),
    FOURTH_PRIZE(4, new PrizeRule(4, BonusMatch.ANYWAY), 50000L),
    FIFTH_PRIZE(5, new PrizeRule(3, BonusMatch.ANYWAY), 5000L),
    SIXTH_PRIZE(6, new PrizeRule(2, BonusMatch.ANYWAY), 0L),
    SEVENTH_PRIZE(7, new PrizeRule(1, BonusMatch.ANYWAY), 0L),
    LOSER(8, new PrizeRule(0, BonusMatch.ANYWAY), 0L);

    private final int rank;
    private final PrizeRule prizeRule;
    private final long money;

    Prize(int rank, PrizeRule prizeRule, long money) {
        this.rank = rank;
        this.prizeRule = prizeRule;
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return prizeRule.getMatchCount();
    }

    public boolean hasBonus() {
        return prizeRule.hasBonus();
    }

    public static Prize ofByMatchCountAndBonus(int matchCount, boolean hasBonusNumber) {
        return Stream.of(Prize.values())
                .filter(p -> p.prizeRule.match(matchCount, hasBonusNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("적절하지 않은 매칭 갯수입니다."));
    }

}
