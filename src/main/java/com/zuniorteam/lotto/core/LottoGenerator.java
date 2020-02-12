package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.Lotto;
import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.HashSet;
import java.util.Set;

public class LottoGenerator {

    private final NumberGenerator numberGenerator;

    public LottoGenerator() {
        this.numberGenerator = new NumberGenerator();
    }

    public Lotto generate() {
        final Set<LottoNumber> lottoNumbers = new HashSet<>();

        while (lottoNumbers.size() < Lotto.LOTTO_NUMBER_SIZE) {
            final int rand = numberGenerator.rand(LottoNumber.MAX_VALUE);
            lottoNumbers.add(new LottoNumber(rand));
        }

        return new Lotto(lottoNumbers);
    }


}
