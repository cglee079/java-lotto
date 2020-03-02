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
        validate(money , appointLottos);

        final long numberOfLottos = getNumbeOfAutoLottos(money, appointLottos);

        final List<Lotto> autoLottoNumbers = LongStream.range(0, numberOfLottos)
                .mapToObj(i -> lottoMachine.generate())
                .collect(Collectors.toList());

        return CollectionUtil.merge(appointLottos, autoLottoNumbers);

    }

    private long getNumbeOfAutoLottos(Money money, List<Lotto> appointLottos) {
        final long numberOfAutoLottos = money.divideMoney(LOTTO_PRICE).amount() - appointLottos.size();
        if(numberOfAutoLottos < 0){
            throw new IllegalArgumentException("이 돈으로 로또를 살수 있을거라 생각했냐!!!!!!!!!!!!!!!!!!!!!");
        }
        return numberOfAutoLottos;
    }

    private void validate(Money money, List<Lotto> countOfAppointLottos) {
        if(Objects.isNull(money)){
            throw new IllegalArgumentException("금액이 null 입니다.");
        }

        if(Objects.isNull(countOfAppointLottos)){
            throw new IllegalArgumentException("수동 로또가 null 입니다.");
        }
    }
}
