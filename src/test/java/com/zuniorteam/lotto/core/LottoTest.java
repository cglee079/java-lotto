package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.core.Lotto;
import com.zuniorteam.lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void testNewInstance01(String value) {

        final List<LottoNumber> lottoNumbers = Arrays.stream(value.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertDoesNotThrow(() -> new Lotto(lottoNumbers));
    }

    @DisplayName("생성, 사이즈가 틀림")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7"})
    void testNewInstance02(String value) {

        final List<LottoNumber> lottoNumbers = Arrays.stream(value.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers));
    }

    @DisplayName("생성, 중복된 숫자가 있음")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,3,4,5,6"})
    void testNewInstance03(String value) {

        final List<LottoNumber> lottoNumbers = Arrays.stream(value.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers));
    }

    @DisplayName("로또 매치 테스트")
    @Test
    void testMatch01(){

        final List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(int i = 1; i < Lotto.LOTTO_NUMBER_SIZE + 1; i++){
            lottoNumbers.add(new LottoNumber(i));
        }

        final Lotto lotto = new Lotto(lottoNumbers);

        final int match = lotto.match(Arrays.asList(new LottoNumber(2), new LottoNumber(3)));

        assertThat(match).isEqualTo(2);

    }
}
