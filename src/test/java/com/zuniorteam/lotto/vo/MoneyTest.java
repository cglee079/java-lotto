package com.zuniorteam.lotto.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(longs = {0, 100L, Long.MAX_VALUE})
    void testNewInstance(long amount) {
        assertDoesNotThrow(() -> Money.of(amount));
    }

    @DisplayName("생성, 0보다 작거나 null 일떄")
    @ParameterizedTest
    @NullSource
    @ValueSource(longs = {Long.MIN_VALUE, -1})
    void testNewInstance(Long amount) {
        assertThrows(AssertionError.class, () -> Money.of(amount));
    }

    @DisplayName("더하기")
    @ParameterizedTest
    @CsvSource({"100, 200, 300", "0,200,200"})
    void testAdd(int x, int y, int expected) {
        final Money moneyX = Money.of(x);
        final Money moneyY = Money.of(y);
        assertThat(moneyX.add(moneyY)).isEqualTo(Money.of(expected));
    }

    @DisplayName("더하기, 여러번")
    @ParameterizedTest
    @CsvSource({"100, 200, 3, 700", "0,200,0,0"})
    void testAddMultiple(int x, int y, int count, int expected) {
        final Money moneyX = Money.of(x);
        final Money moneyY = Money.of(y);
        assertThat(moneyX.addMultiple(moneyY, count)).isEqualTo(Money.of(expected));
    }

    @DisplayName("돈으로 나누기")
    @ParameterizedTest
    @CsvSource({"100, 100, 1", "1000, 100, 10"})
    void testDivide01(int x, int y, int expected) {
        final Money moneyX = Money.of(x);
        final Money moneyY = Money.of(y);
        assertThat(moneyX.divideMoney(moneyY)).isEqualTo(Money.of(expected));
    }

    @DisplayName("돈으로 나누기, 0으로 나눌수 없음")
    @ParameterizedTest
    @CsvSource({"100, 0", "1000, 0"})
    void testDivide02(int x, int y) {
        final Money moneyX = Money.of(x);
        final Money moneyY = Money.of(y);
        assertThrows(IllegalArgumentException.class, () -> moneyX.divideMoney(moneyY));
    }

    @DisplayName("돈으로 나누기, 나누어 떨어지지 않음")
    @ParameterizedTest
    @CsvSource({"100, 3", "1000, 21"})
    void testDivide03(int x, int y) {
        final Money moneyX = Money.of(x);
        final Money moneyY = Money.of(y);
        assertThrows(IllegalArgumentException.class, () -> moneyX.divideMoney(moneyY));
    }
}
