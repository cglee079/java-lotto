package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBuyer {

    private final int insertedMoney;
    private final List<Lotto> lottos;

    public LottoBuyer(int insertedMoney, List<Lotto> lottos) {
        assert insertedMoney > 0;
        assert lottos != null;

        this.insertedMoney = insertedMoney;
        this.lottos = lottos;
    }

    public Integer getInsertedMoney() {
        return insertedMoney;
    }

    public Map<Integer, Integer> checkWinning(WinningLotto winningLotto) {
        final Map<Integer, Integer> results = IntStream.rangeClosed(0, Lotto.LOTTO_NUMBER_LENGTH)
                .boxed()
                .collect(Collectors.toMap(i -> i, t -> 0));

        for (Lotto lotto : lottos) {
            final int result = lotto.match(winningLotto);
            results.put(result, results.get(result) + 1);
        }

        return results;
    }


    public List<List<LottoNumber>> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getLottoNumbers)
                .collect(Collectors.toList());
    }
}
