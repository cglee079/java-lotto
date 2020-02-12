package com.zuniorteam.lotto.vo;

import java.util.Set;

public class Lotto {

    public static final int LOTTO_NUMBER_SIZE = 7;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        assert lottoNumbers != null;

        validate(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_NUMBER_SIZE){
            throw new IllegalArgumentException("로또 숫자 사이즈가 다릅니다");
        }

    }

}
