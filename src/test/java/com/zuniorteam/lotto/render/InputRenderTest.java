package com.zuniorteam.lotto.render;

import com.zuniorteam.lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputRenderTest {


    @DisplayName("당첨번호 입력 변환")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1, 2, 3", "1,2, 3"})
    void testGetWinningNumbers(String input){
        //when
        final List<LottoNumber> winningNumbers = InputRender.getWinningLotto(input);

        //then
        assertThat(winningNumbers.size()).isEqualTo(3);
        assertThat(winningNumbers).containsAll(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)));

    }

}
