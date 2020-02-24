package com.zuniorteam.lotto.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class LottoBuyerTest {

    @DisplayName("생성")
    @Test
    void testNewInstance01(){
        assertDoesNotThrow(() -> new LottoBuyer(1000, Collections.emptyList()));
    }

    @DisplayName("생성, AssertError")
    @Test
    void testNewInstance02(){
        assertAll(
                () -> assertThrows(AssertionError.class, () -> new LottoBuyer(-1, Collections.emptyList())),
                () -> assertThrows(AssertionError.class, () -> new LottoBuyer(1000, null))
        );
    }


    @DisplayName("로또 당첨 체크")
    @Test
    void testCheckWinning01(){
        //given
        final Lotto lotto1 = Mockito.mock(Lotto.class);
        final Lotto lotto2 = Mockito.mock(Lotto.class);
        final WinningLotto winningLotto = Mockito.mock(WinningLotto.class);

        given(winningLotto.match(lotto1)).willReturn(Prize.FIFTH_PRIZE);
        given(winningLotto.match(lotto2)).willReturn(Prize.FOURTH_PRIZE);

        //when
        final LottoBuyer lottoBuyer = new LottoBuyer(2000, Arrays.asList(lotto1, lotto2));
        final Map<Prize, Integer> result = lottoBuyer.checkWinning(winningLotto);

        //then
        assertThat(result.get(Prize.FIFTH_PRIZE)).isEqualTo(1);
        assertThat(result.get(Prize.FOURTH_PRIZE)).isEqualTo(1);
    }

}
