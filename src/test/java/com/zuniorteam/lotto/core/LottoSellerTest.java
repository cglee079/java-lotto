package com.zuniorteam.lotto.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class LottoSellerTest {

    @DisplayName("생성")
    @Test
    void testNewInstance01(){
        assertDoesNotThrow(() -> new LottoSeller(new LottoMachine()));
    }

    @DisplayName("생성, 인자가 null")
    @Test
    void testNewInstance02(){
        assertThrows(AssertionError.class, () -> new LottoSeller(null));
    }


    @DisplayName("로또 판매")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    void testSell01(int insertedMoney){
        //given
        int expectSize = insertedMoney / LottoSeller.LOTTO_PRICE;
        final LottoMachine lottoMachine = Mockito.mock(LottoMachine.class);

        final Lotto lotto = Mockito.mock(Lotto.class);
        given(lottoMachine.generate()).willReturn(lotto);

        //when
        final List<Lotto> lottos = new LottoSeller(lottoMachine).sell(insertedMoney, Collections.emptyList());

        //then
        assertThat(lottos.size()).isEqualTo(expectSize);
    }

    @DisplayName("로또 판매, 수동번호 포함")
    @Test
    void testSell02(){
        //given
        final int insertedMoney = 3000;
        final LottoMachine lottoMachine = Mockito.mock(LottoMachine.class);

        final Lotto appointLotto = Mockito.mock(Lotto.class);
        final Lotto autoLotto = Mockito.mock(Lotto.class);
        given(lottoMachine.generate()).willReturn(autoLotto);

        //when
        final List<Lotto> lottos = new LottoSeller(lottoMachine).sell(insertedMoney, Collections.singletonList(appointLotto));

        //then
        assertThat(lottos).containsExactly(appointLotto, autoLotto, autoLotto);
    }

    @DisplayName("로또 판매, 금액이 나눠어 떨어지지 않거나, 0인경우")
    @ParameterizedTest
    @ValueSource(ints = {0, 1231, 1999, 3001})
    void testSell02(int insertedMoney){
        //given
        final LottoMachine lottoMachine = Mockito.mock(LottoMachine.class);

        final Lotto lotto = Mockito.mock(Lotto.class);
        given(lottoMachine.generate()).willReturn(lotto);

        assertThrows(IllegalArgumentException.class, () ->  new LottoSeller(lottoMachine).sell(insertedMoney, Collections.emptyList()));
    }
}
