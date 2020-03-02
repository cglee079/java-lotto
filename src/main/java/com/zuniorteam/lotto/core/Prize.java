package com.zuniorteam.lotto.core;


import com.zuniorteam.lotto.vo.Money;
import com.zuniorteam.lotto.vo.PrizeRule;

import java.util.stream.Stream;

import static com.zuniorteam.lotto.vo.PrizeRule.BonusMatch.*;

public enum Prize {

    WINNER(1, new PrizeRule(6, ANYWAY), Money.of(20000000000L)),
    BONUS_WINNER(2, new PrizeRule(5, MATCH), Money.of(30000000L)),
    THIRD_PRIZE(3, new PrizeRule(5, NO_MATCH), Money.of(1500000L)),
    FOURTH_PRIZE(4, new PrizeRule(4, ANYWAY), Money.of(50000L)),
    FIFTH_PRIZE(5, new PrizeRule(3, ANYWAY), Money.of(5000L)),
    SIXTH_PRIZE(6, new PrizeRule(2, ANYWAY), Money.ZERO),
    SEVENTH_PRIZE(7, new PrizeRule(1, ANYWAY), Money.ZERO),
    LOSER(8, new PrizeRule(0, ANYWAY), Money.ZERO);

    private final int rank;
    private final PrizeRule prizeRule;
    private final Money money;

    Prize(int rank, PrizeRule prizeRule, Money money) {
        this.rank = rank;
        this.prizeRule = prizeRule;
        this.money = money;
    }

    public Money getMoney() {
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

    public static Prize parseByMatchCountAndBonus(int matchCount, boolean hasBonusNumber) {
        return Stream.of(Prize.values())
                .filter(p -> p.prizeRule.match(matchCount, hasBonusNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("적절하지 않은 매칭 갯수입니다."));
    }

}
