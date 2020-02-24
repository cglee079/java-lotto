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

        if (this.matchCount == matchCount) {
            return matchBonusNumber(hasBonusNumber);
        }
        return false;
    }

    private void validate(int matchCount) {
        if(matchCount < 0){
            throw new IllegalArgumentException("적절하지 않은 매치개수 입니다");
        }
    }

    private boolean matchBonusNumber(boolean hasBonus) {
        switch (bonusMatch) {
            case MATCH:
                return hasBonus;
            case NO_MATCH:
                return !hasBonus;
            case ANYWAY:
                return true;
            default:
                throw new IllegalArgumentException("알 수 없는 Bonus Match 입니다");
        }
    }

    public enum BonusMatch {
        MATCH, NO_MATCH, ANYWAY
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
