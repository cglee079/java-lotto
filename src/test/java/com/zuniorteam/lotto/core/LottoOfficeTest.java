package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class LottoOfficeTest {

    @DisplayName("생성")
    @Test
    void testNewInstance01(){
        assertDoesNotThrow((LottoOffice::new));
    }

    @DisplayName("결과 테스트")
    @Test
    void testGetResult01(){
        final Lotto lotto1 = Mockito.mock(Lotto.class);
        final Lotto lotto2 = Mockito.mock(Lotto.class);

        given(lotto1.match(any())).willReturn(3);
        given(lotto2.match(any())).willReturn(4);
        final Map<Integer, Integer> result = new LottoOffice().getResult(Arrays.asList(lotto1, lotto2), Collections.emptyList());

        assertThat(result.get(3)).isEqualTo(1);
        assertThat(result.get(4)).isEqualTo(1);

    }

}