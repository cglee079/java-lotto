package com.zuniorteam.lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MathUtilTest {

    @DisplayName("나누기")
    @ParameterizedTest
    @CsvSource({"1,2,0.5", "10,5,2", "0,1,0"})
    void testDivide(double x, double y, double expected) {
        assertThat(MathUtil.divide(x, y)).isEqualTo(expected);
    }


}
