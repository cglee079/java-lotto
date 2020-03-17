package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.Money;

import java.util.*;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

public class LottoSeller {

    public static final Money LOTTO_PRICE = Money.of(1000);

    private final LottoAutoMachine lottoAutoMachine;

    public LottoSeller(LottoAutoMachine lottoAutoMachine) {
        assert lottoAutoMachine != null;

        this.lottoAutoMachine = lottoAutoMachine;
    }

    public Lottos sell(Money money, Lottos appointLottos) {
        validate(money , appointLottos);

        final long numberOfAutoLottos = getNumberOfAutoLottos(money, appointLottos.size());
        final Lottos autoLottos = generateAutoLottos(numberOfAutoLottos);

        return appointLottos.merge(autoLottos);
    }

    private void validate(Money money, Lottos appointLottos) {
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
            throw new IllegalArgumentException("돈이 부족합니다.");
        }

        return numberOfAutoLottos;
    }

    private Lottos generateAutoLottos(long numberOfAutoLottos) {
        final List<Lotto> autoLottos = LongStream.range(0, numberOfAutoLottos)
                .mapToObj(i -> lottoAutoMachine.generate())
                .collect(toList());

        return new Lottos(autoLottos);
    }
}

