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


    @DisplayName("결과 테스트")
    @Test
    void testGetResult01(){
        final Lotto lotto1 = Mockito.mock(Lotto.class);
        final Lotto lotto2 = Mockito.mock(Lotto.class);

        given(lotto1.match(any())).willReturn(3);
        given(lotto2.match(any())).willReturn(4);
        final LottoBuyer lottoBuyer = new LottoBuyer(2000, Arrays.asList(lotto1, lotto2));
        final Map<Integer, Integer> result = lottoBuyer.matchLottos(Collections.emptyList());

        assertThat(result.get(3)).isEqualTo(1);
        assertThat(result.get(4)).isEqualTo(1);
    }

}
