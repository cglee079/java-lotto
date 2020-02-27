package com.zuniorteam.lotto.vo;

import java.util.Objects;

public class PrizeRule {

    private int matchCount;
    private BonusMatch bonusMatch;

    public PrizeRule(int matchCount, BonusMatch bonusMatch) {
        assert matchCount >= 0;
        assert bonusMatch != null;

        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonus() {
        return bonusMatch == BonusMatch.MATCH;
    }

    public boolean match(int matchCount, boolean hasBonusNumber) {
        validate(matchCount);

        if (this.matchCount != matchCount) {
            return false;
        }

        return bonusMatch.match(hasBonusNumber);
    }

    private void validate(int matchCount) {
        if (matchCount < 0) {
            throw new IllegalArgumentException("적절하지 않은 매치개수 입니다");
        }
    }

    public enum BonusMatch {
        MATCH {
            @Override
            public boolean match(boolean hasBonusNumber) {
                return hasBonusNumber;
            }

        },

        NO_MATCH {
            @Override
            public boolean match(boolean hasBonusNumber) {
                return !hasBonusNumber;
            }
        },

        ANYWAY {
            @Override
            public boolean match(boolean hasBonusNumber) {
                return true;
            }
        };

        public abstract boolean match(boolean hasBonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrizeRule prizeRule = (PrizeRule) o;
        return matchCount == prizeRule.matchCount &&
                bonusMatch == prizeRule.bonusMatch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, bonusMatch);
    }
}
