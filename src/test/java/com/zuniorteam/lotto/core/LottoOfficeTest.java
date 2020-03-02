package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.util.MathUtils;
import com.zuniorteam.lotto.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        //given
        final Money insertedMoney = Money.of(1000);

        final LottoBuyer lottoBuyer = Mockito.mock(LottoBuyer.class);
        final Map<Prize, Integer> results = new HashMap<>();
        results.put(Prize.LOSER, 0);
        results.put(Prize.SEVENTH_PRIZE, 0);
        results.put(Prize.SIXTH_PRIZE, 0);
        results.put(Prize.FIFTH_PRIZE, 1);
        results.put(Prize.FOURTH_PRIZE, 1);
        results.put(Prize.THIRD_PRIZE, 0);
        results.put(Prize.WINNER, 0);

        given(lottoBuyer.getInsertedMoney()).willReturn(insertedMoney);
        given(lottoBuyer.checkWinning(any())).willReturn(results);

        final Money prizeA = Prize.parseByMatchCountAndBonus(3, false).getMoney();
        final Money prizeB = Prize.parseByMatchCountAndBonus(4, false).getMoney();
        final Money totalPrize = prizeA.add(prizeB);

        //when
        final LottoResult result = new LottoOffice().getLottoResult(lottoBuyer, Mockito.mock(WinningLotto.class));

        //then
        assertThat(result.getWinPercent()).isEqualTo(MathUtils.divide(totalPrize.amount(), insertedMoney.amount()));
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
