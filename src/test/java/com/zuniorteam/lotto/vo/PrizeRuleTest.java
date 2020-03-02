package com.zuniorteam.lotto.vo;

import com.zuniorteam.lotto.vo.PrizeRule.BonusMatch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizeRuleTest {

    @DisplayName("생성")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new PrizeRule(0, BonusMatch.ANYWAY));
    }

    @DisplayName("생성, MatchCount 0 미만이거나, BonusMatch 가 없을떄")
    @Test
    void testNewInstance02() {
        assertAll(
                () -> assertThrows(AssertionError.class, () -> new PrizeRule(-1, BonusMatch.ANYWAY)),
                () -> assertThrows(AssertionError.class, () -> new PrizeRule(0, null)),
                () -> assertThrows(AssertionError.class, () -> new PrizeRule(-1, null))
        );
    }

    @DisplayName("match(), BonusMatch ANYWAY 일때")
    @ParameterizedTest
    @CsvSource({"1, true, false", "1, false, false", "0, true, true","0, false, true"})
    void testMatch01(int matchCount, boolean hasBonusNumber, boolean expected){
        //given
        final PrizeRule prizeRule = new PrizeRule(0, BonusMatch.ANYWAY);

        //when
        final boolean match = prizeRule.match(matchCount, hasBonusNumber);

        //then
        assertThat(match).isEqualTo(expected);
    }

    @DisplayName("match(), BonusMatch NO_MATCH 일 때")
    @ParameterizedTest
    @CsvSource({"1, true, false", "1, false, false", "0, true, false","0, false, true"})
    void testMatch02(int matchCount, boolean hasBonusNumber, boolean expected){
        //given
        final PrizeRule prizeRule = new PrizeRule(0, BonusMatch.NO_MATCH);

        //when
        final boolean match = prizeRule.match(matchCount, hasBonusNumber);

        //then
        assertThat(match).isEqualTo(expected);
    }

    @DisplayName("match(), BonusMatch ANYWAY 일 때")
    @ParameterizedTest
    @CsvSource({"1, true, false", "1, false, false", "0, true, true","0, false, true"})
    void testMatch03(int matchCount, boolean hasBonusNumber, boolean expected){
        //given
        final PrizeRule prizeRule = new PrizeRule(0, BonusMatch.ANYWAY);

        //when
        final boolean match = prizeRule.match(matchCount, hasBonusNumber);

        //then
        assertThat(match).isEqualTo(expected);
    }

}
