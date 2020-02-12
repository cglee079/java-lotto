package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class LottoOfficeTest {

    @DisplayName("로또 구입 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    void testBuy01(int insertedMoney){
        //given
        int expectSize = insertedMoney / LottoOffice.LOTTO_PRICE;
        final LottoGenerator lottoGenerator = Mockito.mock(LottoGenerator.class);

        final Lotto lotto = Mockito.mock(Lotto.class);
        given(lottoGenerator.generate()).willReturn(lotto);


        //when
        final List<Lotto> lottos = new LottoOffice(lottoGenerator).buy(insertedMoney);

        //then
        assertThat(lottos.size()).isEqualTo(expectSize);
    }


    @DisplayName("로또 구입 테스트, 실패")
    @ParameterizedTest
    @ValueSource(ints = {1231, 1999, 3001})
    void testBuy02(int insertedMoney){
        //given
        final LottoGenerator lottoGenerator = Mockito.mock(LottoGenerator.class);

        final Lotto lotto = Mockito.mock(Lotto.class);
        given(lottoGenerator.generate()).willReturn(lotto);

        assertThrows(IllegalArgumentException.class, () ->  new LottoOffice(lottoGenerator).buy(insertedMoney));
    }
}
