package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.*;

public class LottoGenerator {

    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Lotto generate() {
        Collections.shuffle(LOTTO_NUMBERS);

        final List<LottoNumber> lottoNumbers = LOTTO_NUMBERS.stream()
                .limit(Lotto.LOTTO_NUMBER_SIZE)
                .sorted(Comparator.comparingInt(LottoNumber::value))
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }


}
