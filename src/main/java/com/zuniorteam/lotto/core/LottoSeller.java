package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.util.CollectionUtil;
import com.zuniorteam.lotto.vo.Money;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoSeller {

    public static final Money LOTTO_PRICE = Money.of(1000);

    private final LottoAutoMachine lottoAutoMachine;

    public LottoSeller(LottoAutoMachine lottoAutoMachine) {
        assert lottoAutoMachine != null;

        this.lottoAutoMachine = lottoAutoMachine;
    }

    public List<Lotto> sell(Money money, List<Lotto> appointLottos) {
        validate(money , appointLottos);

        final long numberOfAutoLottos = getNumberOfAutoLottos(money, appointLottos.size());

        final List<Lotto> autoLottos = LongStream.range(0, numberOfAutoLottos)
                .mapToObj(i -> lottoAutoMachine.generate())
                .collect(Collectors.toList());

        return CollectionUtil.merge(appointLottos, autoLottos);
    }

    private void validate(Money money, List<Lotto> appointLottos) {
        if(Objects.isNull(money)){
            throw new IllegalArgumentException("금액이 null 입니다.");
        }

        if(Objects.isNull(appointLottos)){
            throw new IllegalArgumentException("수동 로또가 null 입니다.");
        }
    }

    private long getNumberOfAutoLottos(Money money, int numberOfAppointLottos) {
        final long numberOfAutoLottos = money.divideMoney(LOTTO_PRICE).amount() - numberOfAppointLottos;
        if(numberOfAutoLottos < 0){
            throw new IllegalArgumentException("이 돈으로 로또를 살수 있을거라 생각했냐!!!!!!!!!!!!!!!!!!!!!");
        }

        return numberOfAutoLottos;
    }
}

