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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class LottoOfficeTest {

    @DisplayName("생성")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow((LottoOffice::new));
    }

    @DisplayName("로또 결과 조회")
    @Test
    void testGetLottoResult01() {
        final int insertedMoney = 1000;

        final LottoBuyer lottoBuyer = Mockito.mock(LottoBuyer.class);
        final Map<Integer, Integer> results = new HashMap<>();
        results.put(1, 0);
        results.put(2, 0);
        results.put(3, 1);
        results.put(4, 1);
        results.put(5, 0);
        results.put(6, 0);

        given(lottoBuyer.getInsertedMoney()).willReturn(insertedMoney);
        given(lottoBuyer.checkWinning(any())).willReturn(results);

        final LottoOffice lottoOffice = new LottoOffice();
        //then
        final LottoResult result = lottoOffice.getLottoResult(lottoBuyer, Mockito.mock(WinningLotto.class));

        assertThat(result.getWinPercent()).isEqualTo(MathUtils.divide(Prize.ofByMatchCount(3).getMoney() + Prize.ofByMatchCount(4).getMoney(), insertedMoney));
    }

    @DisplayName("로또 결과 조회, 구매자가 또는 당첨번호가 null")
    @Test
    void testGetLottoResult02() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new LottoOffice().getLottoResult(null, Mockito.mock(WinningLotto.class))),
                () -> assertThrows(IllegalArgumentException.class, () -> new LottoOffice().getLottoResult(Mockito.mock(LottoBuyer.class), null)),
                () -> assertThrows(IllegalArgumentException.class, () -> new LottoOffice().getLottoResult(null, null))
        );
    }


}
