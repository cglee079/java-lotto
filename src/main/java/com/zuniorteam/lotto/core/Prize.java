package com.zuniorteam.lotto.core;


import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Prize {

    ZERO(0, 0L),
    ONE(1, 0L),
    TWO(2, 0L),
    THREE(3, 5000L),
    FOUR(4, 50000L),
    FIVE(5, 1500000L),
    SIX(6, 20000000000L);

    private static final Map<Integer, Prize> MATCH_COUNT_TO_PRIZE;

    static {
        final Map<Integer, Prize> matchCountToPrize = Stream.of(values())
                .collect(Collectors.toMap(Prize::getMatchCount, e -> e));

        MATCH_COUNT_TO_PRIZE = Collections.unmodifiableMap(matchCountToPrize);
    }

    private final int matchCount;
    private final long money;

    Prize(int matchCount, long money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getMoney() {
        return money;
    }

    public static Prize ofByMatchCount(Integer matchCount) {
        if (!MATCH_COUNT_TO_PRIZE.containsKey(matchCount)) {
            throw new IllegalArgumentException("적절하지 않은 매칭 갯수입니다.");
        }

        return MATCH_COUNT_TO_PRIZE.get(matchCount);
    }
}
