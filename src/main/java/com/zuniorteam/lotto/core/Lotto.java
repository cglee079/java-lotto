package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.util.CollectionUtils;
import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int LOTTO_NUMBER_LENGTH = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);

        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    public boolean contains(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public Prize match(Lotto winningLotto, LottoNumber bonusNumber) {

        int result = 0;
        for (LottoNumber winningNumber : winningLotto.getLottoNumbers()) {
            result += Collections.frequency(lottoNumbers, winningNumber);
        }

        return Prize.ofByMatchCountAndBonus(result, lottoNumbers.contains(bonusNumber));
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        assert lottoNumbers != null;

        if (lottoNumbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("로또 숫자 사이즈가 다릅니다");
        }

        if (!CollectionUtils.isUnique(lottoNumbers)) {
            throw new IllegalArgumentException("중복된 로또 번호가 있습니다");
        }
    }

}
