package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;

    public WinningLotto(Lotto winningLotto) {
        assert winningLotto != null;

        this.winningLotto = winningLotto;
    }

    public List<LottoNumber> getLottoNumbers() {
        return winningLotto.getLottoNumbers();
    }

}
