package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.*;

public class LottoAutoMachine {

    private static final List<LottoNumber> RESERVE_LOTTO_NUMBERS;

    static {
        RESERVE_LOTTO_NUMBERS = rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                .mapToObj(LottoNumber::new)
                .collect(toList());
    }

    public Lotto generate() {
        Collections.shuffle(RESERVE_LOTTO_NUMBERS);

        final List<LottoNumber> lottoNumbers = RESERVE_LOTTO_NUMBERS.stream()
                .limit(Lotto.LOTTO_NUMBER_LENGTH)
                .collect(toList());

        return new Lotto(lottoNumbers);
    }
}
