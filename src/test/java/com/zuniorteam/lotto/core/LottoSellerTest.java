package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class LottoSellerTest {

    @DisplayName("생성")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new LottoSeller(new LottoAutoMachine()));
    }

    @DisplayName("생성, 인자가 null")
    @Test
    void testNewInstance02() {
        assertThrows(AssertionError.class, () -> new LottoSeller(null));
    }


    @DisplayName("로또 판매")
    @ParameterizedTest
    @ValueSource(ints = {0, 1000, 2000, 3000})
    void testSell01(int insertedAmount) {
        //given
        final Money insertedMoney = Money.of(insertedAmount);
        long expectSize = insertedMoney.divideMoney(LottoSeller.LOTTO_PRICE).amount();
        final LottoAutoMachine lottoAutoMachine = Mockito.mock(LottoAutoMachine.class);

        final Lotto lotto = Mockito.mock(Lotto.class);
        given(lottoAutoMachine.generate()).willReturn(lotto);

        //when
        final List<Lotto> lottos = new LottoSeller(lottoAutoMachine).sell(insertedMoney, Collections.emptyList());

        //then
        assertThat(lottos.size()).isEqualTo(expectSize);
    }

    @DisplayName("로또 판매, 수동번호 포함")
    @Test
    void testSell02() {
        //given
        final Money insertedMoney = Money.of(3000);
        final LottoAutoMachine lottoAutoMachine = Mockito.mock(LottoAutoMachine.class);

        final Lotto appointLotto = Mockito.mock(Lotto.class);
        final Lotto autoLotto = Mockito.mock(Lotto.class);
        given(lottoAutoMachine.generate()).willReturn(autoLotto);

        //when
        final List<Lotto> lottos = new LottoSeller(lottoAutoMachine).sell(insertedMoney, Collections.singletonList(appointLotto));

        //then
        assertThat(lottos).containsExactly(appointLotto, autoLotto, autoLotto);
    }

    @DisplayName("로또 판매, 수동번호 포함, 돈이 부족할때")
    @Test
    void testSell03() {
        //given
        final Money insertedMoney = Money.ZERO;
        final LottoAutoMachine lottoAutoMachine = Mockito.mock(LottoAutoMachine.class);

        final Lotto appointLotto = Mockito.mock(Lotto.class);
        final Lotto autoLotto = Mockito.mock(Lotto.class);
        given(lottoAutoMachine.generate()).willReturn(autoLotto);

        //when, then
        assertThrows(
                RuntimeException.class,
                () -> new LottoSeller(lottoAutoMachine).sell(insertedMoney, Collections.singletonList(appointLotto)));
    }

    @DisplayName("로또 판매, null 주입")
    @Test
    void testSell04() {
        //given
        final LottoAutoMachine lottoAutoMachine = Mockito.mock(LottoAutoMachine.class);
        final LottoSeller lottoSeller = new LottoSeller(lottoAutoMachine);

        //when, then
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> lottoSeller.sell(null, Collections.emptyList())),
                () -> assertThrows(IllegalArgumentException.class, () -> lottoSeller.sell(Money.ZERO, null))
        );
    }

}
