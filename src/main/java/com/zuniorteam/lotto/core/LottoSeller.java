package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.util.CollectionUtil;
import com.zuniorteam.lotto.vo.Money;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoSeller {

    public static final Money LOTTO_PRICE = Money.of(1000);

    private final LottoMachine lottoMachine;

    public LottoSeller(LottoMachine lottoMachine) {
        assert lottoMachine != null;

        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> sell(Money money, List<Lotto> appointLottos) {
        validate(money);

        final long numberOfLottos = money.divideMoney(LOTTO_PRICE).amount() - appointLottos.size();

        final List<Lotto> autoLottoNumbers = LongStream.range(0, numberOfLottos)
                .mapToObj(i -> lottoMachine.generate())
                .collect(Collectors.toList());

        return CollectionUtil.merge(appointLottos, autoLottoNumbers);

    }

    private void validate(Money money) {
        if(Objects.isNull(money)){
            throw new IllegalArgumentException("금액이 null 입니다.");
        }
    }
}
