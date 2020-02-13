package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.util.CollectionUtils;
import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        assert lottoNumbers != null;

        validate(lottoNumbers);

        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 숫자 사이즈가 다릅니다");
        }

        if (!CollectionUtils.isUnique(lottoNumbers)) {
            throw new IllegalArgumentException("중복된 로또 번호가 있습니다");
        }
    }

    public int match(List<LottoNumber> winNumbers) {
        int result = 0;
        for (LottoNumber winNumber : winNumbers) {
            result += Collections.frequency(this.lottoNumbers, winNumber);
        }

        return result;
    }


}
