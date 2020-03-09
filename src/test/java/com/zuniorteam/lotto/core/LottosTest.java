package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {


    @DisplayName("생성, 성공")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new Lottos(Collections.emptyList()));
    }

    @DisplayName("생성, 실패")
    @Test
    void testNewInstance02() {
        assertThrows(AssertionError.class, () -> new Lottos(null));
    }

    @DisplayName("로또 개수 검증")
    @Test
    void testSize() {
        final Lotto lotto = Mockito.mock(Lotto.class);
        final Lottos lottos = new Lottos(Collections.singletonList(lotto));

        //when, then
        assertThat(lottos.size()).isEqualTo(1);
    }

    @DisplayName("모든 로또 반환")
    @Test
    void testGetLottos() {
        final Lotto lotto = Mockito.mock(Lotto.class);
        final Lottos lottos = new Lottos(Collections.singletonList(lotto));

        //when, then
        assertThat(lottos.getLottos()).containsExactly(lotto);
    }

    @DisplayName("모든 로또번호 반환")
    @Test
    void testGetAllLottoNumbers() {
        final List<LottoNumber> lottoNumbersA = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(toList());
        final List<LottoNumber> lottoNumbersB = Stream.of(10, 11, 12, 13, 14, 15).map(LottoNumber::new).collect(toList());

        final Lotto lottoA = new Lotto(lottoNumbersA);
        final Lotto lottoB = new Lotto(lottoNumbersB);

        final Lottos lottos = new Lottos(Arrays.asList(lottoA, lottoB));

        //when, then
        assertThat(lottos.getAllLottoNumbers().size()).isEqualTo(2);
        assertThat(lottos.getAllLottoNumbers()).containsExactly(lottoNumbersA, lottoNumbersB);
    }

}
