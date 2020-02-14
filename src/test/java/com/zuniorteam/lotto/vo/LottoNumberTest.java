package com.zuniorteam.lotto.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void testNewInstance01(int value) {
        assertDoesNotThrow(() -> new LottoNumber(value));
    }

    @DisplayName("생성, 실패")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void testNewInstance02(int value) {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(value));
    }
}
