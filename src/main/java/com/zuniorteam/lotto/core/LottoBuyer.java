package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

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

    public Map<Prize, Integer> checkWinning(WinningLotto winningLotto) {
        final Map<Prize, Integer> results = new TreeMap<>(Comparator.comparingInt(Prize::getRank).reversed());
        results.putAll(Stream.of(Prize.values()).collect(toMap(t -> t, t -> 0)));

        for (Lotto lotto : lottos) {
            final Prize prize = winningLotto.match(lotto);
            results.put(prize, results.get(prize) + 1);
        }

        return results;
    }


    public List<List<LottoNumber>> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getLottoNumbers)
                .collect(Collectors.toList());
    }
}
