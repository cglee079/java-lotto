package com.zuniorteam.lotto.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    @DisplayName("적절한 Match갯수")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void testOfByMatchCount01(int matchCount) {
        assertDoesNotThrow(() -> Prize.ofByMatchCount(matchCount));
    }

    @DisplayName("적절하지 않은 Match갯수")
    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    void testOfByMatchCount02(int matchCount) {
        assertThrows(IllegalArgumentException.class, () -> Prize.ofByMatchCount(matchCount));
    }

}
