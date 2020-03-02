package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("생성")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new WinningLotto(Mockito.mock(Lotto.class), Mockito.mock(LottoNumber.class)));
    }

    @DisplayName("생성 실패")
    @Test
    void testNewInstance02() {
        assertAll(
                () -> assertThrows(AssertionError.class, () -> new WinningLotto(null, Mockito.mock(LottoNumber.class))),
                () -> assertThrows(AssertionError.class, () -> new WinningLotto(Mockito.mock(Lotto.class), null)),
                () -> assertThrows(AssertionError.class, () -> new WinningLotto(null, null))
        );
    }

    @DisplayName("생성 실패, 보너스 번호가 로또번호와 중복됨")
    @Test
    void testNewInstance03() {
        final ArrayList<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));

        final LottoNumber bonusNumber = new LottoNumber(1);
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(new Lotto(lottoNumbers), bonusNumber));
    }

}
