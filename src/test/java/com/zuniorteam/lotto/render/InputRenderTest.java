package com.zuniorteam.lotto.render;

import com.zuniorteam.lotto.core.WinningLotto;
import com.zuniorteam.lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputRenderTest {


    @DisplayName("당첨번호 입력 변환")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6", "1,2, 3,4, 5, 6"})
    void testGetWinningNumbers(String input){
        //given
        final List<LottoNumber> expectWinningNumbers = new ArrayList<>();
        expectWinningNumbers.add(new LottoNumber(1));
        expectWinningNumbers.add(new LottoNumber(2));
        expectWinningNumbers.add(new LottoNumber(3));
        expectWinningNumbers.add(new LottoNumber(4));
        expectWinningNumbers.add(new LottoNumber(5));
        expectWinningNumbers.add(new LottoNumber(6));

        //when
        final WinningLotto winningNumbers = InputRender.getWinningLotto(input);

        //then
        final List<LottoNumber> lottoNumbers = winningNumbers.getLottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(expectWinningNumbers.size());



        assertThat(lottoNumbers).containsAll(expectWinningNumbers);

    }

}
