package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;
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
        final Map<Prize, Integer> results = initResults();

        for (Lotto lotto : lottos) {
            final Prize prize = winningLotto.match(lotto);
            results.put(prize, results.get(prize) + 1);
        }

        return results;
    }

    private Map<Prize, Integer> initResults() {
        final Map<Prize, Integer> sortedResults = new TreeMap<>(comparingInt(Prize::getRank).reversed());
        final Map<Prize, Integer> result = Stream.of(Prize.values())
                .collect(toMap(p -> p, p -> 0));

        sortedResults.putAll(result);

        return sortedResults;
    }


    public List<List<LottoNumber>> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getLottoNumbers)
                .collect(toList());
    }
}
