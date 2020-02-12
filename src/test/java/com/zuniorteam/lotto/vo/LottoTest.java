package com.zuniorteam.lotto.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7"})
    void testNewInstance01(String value) {

        final Set<LottoNumber> lottoNumbers = Arrays.stream(value.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        assertDoesNotThrow(() -> new Lotto(lottoNumbers));
    }

    @DisplayName("생성, 사이즈가 틀림")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void testNewInstance02(String value) {

        final Set<LottoNumber> lottoNumbers = Arrays.stream(value.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers));
    }
}
