package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.LottoNumber;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        assert winningLotto != null;
        assert bonusNumber != null;

        if(winningLotto.contains(bonusNumber)){
            throw new IllegalArgumentException(bonusNumber.value() + "는 이미 당첨번호에 포함되어있는 번호입니다.");
        }
    }

    public Prize match(Lotto lotto) {
        return lotto.match(winningLotto, bonusNumber);
    }
}
