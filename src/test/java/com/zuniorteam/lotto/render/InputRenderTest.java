package com.zuniorteam.lotto.render;

import com.zuniorteam.lotto.core.Lotto;
import com.zuniorteam.lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputRenderTest {

    @DisplayName("당첨번호 입력 변환")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6", "1,2, 3,4, 5, 6"})
    void testGetWinningNumbers(String input) {
        //given
        final List<LottoNumber> expectWinningNumbers = new ArrayList<>();
        expectWinningNumbers.add(new LottoNumber(1));
        expectWinningNumbers.add(new LottoNumber(2));
        expectWinningNumbers.add(new LottoNumber(3));
        expectWinningNumbers.add(new LottoNumber(4));
        expectWinningNumbers.add(new LottoNumber(5));
        expectWinningNumbers.add(new LottoNumber(6));

        //when
        final Lotto winningNumbers = InputRender.getWinningLotto(input);

        //then
        final List<LottoNumber> lottoNumbers = winningNumbers.getLottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(expectWinningNumbers.size());
        assertThat(lottoNumbers).containsAll(expectWinningNumbers);
    }

    @DisplayName("수동번호 개수 반환, 음수 일 때")
    @Test
    void testGetNumberOfAppointLottos(){
        assertThrows(IllegalArgumentException.class,  () -> InputRender.getNumberOfAppointLottos(-1));
    }

}

