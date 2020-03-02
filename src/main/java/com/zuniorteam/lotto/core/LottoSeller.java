package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.util.CollectionUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSeller {

    public static final int LOTTO_PRICE = 1000;

    private final LottoMachine lottoMachine;

    public LottoSeller(LottoMachine lottoMachine) {
        assert lottoMachine != null;

        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> sell(int money, List<Lotto> appointLottos) {
        validate(money);

        final int numberOfLottos = (money / LOTTO_PRICE) - appointLottos.size();

        final List<Lotto> autoLottoNumbers = IntStream.range(0, numberOfLottos)
                .mapToObj(i -> lottoMachine.generate())
                .collect(Collectors.toList());

        return CollectionUtil.merge(appointLottos, autoLottoNumbers);

    }

    private void validate(int money) {
        if(money <= 0){
            throw new IllegalArgumentException("금액은 0원 이상이어야합니다");
        }

        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("금액이 나누어 떨어지지 않습니다");
        }
    }
}
