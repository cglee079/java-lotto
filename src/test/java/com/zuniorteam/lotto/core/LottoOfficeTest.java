package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.util.MathUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class LottoOfficeTest {

    @DisplayName("생성")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow((LottoOffice::new));
    }

    @DisplayName("결과 테스트")
    @Test
    void testGetResult01() {
        final int insertedMoney = 1000;

        final LottoBuyer lottoBuyer = Mockito.mock(LottoBuyer.class);
        Map<Integer, Integer> results = new HashMap<>();
        results.put(1, 0);
        results.put(2, 0);
        results.put(3, 1);
        results.put(4, 1);
        results.put(5, 0);
        results.put(6, 0);

        given(lottoBuyer.getInsertedMoney()).willReturn(insertedMoney);
        given(lottoBuyer.getResult(any())).willReturn(results);

        final LottoOffice lottoOffice = new LottoOffice();
        //then
        final LottoResult result = lottoOffice.getLottoResult(lottoBuyer, Collections.emptyList());

        assertThat(result.getWinPercent()).isEqualTo(MathUtils.divide(LottoOffice.PRIZE_MONEYS.get(3) + LottoOffice.PRIZE_MONEYS.get(4), insertedMoney));
    }


}
