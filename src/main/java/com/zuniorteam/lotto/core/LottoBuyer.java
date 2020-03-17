package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.LottoNumber;
import com.zuniorteam.lotto.vo.Money;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

public class LottoBuyer {

    private final Money insertedMoney;
    private final Lottos lottos;

    public LottoBuyer(Money insertedMoney, Lottos lottos) {
        assert insertedMoney != null;
        assert lottos != null;

        this.insertedMoney = insertedMoney;
        this.lottos = lottos;
    }

    public Money getInsertedMoney() {
        return insertedMoney;
    }

    public Map<Prize, Integer> checkWinning(WinningLotto winningLotto) {
        final Map<Prize, Integer> results = initResults();

        for (Lotto lotto : lottos.getLottos()) {
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

    public List<List<LottoNumber>> getAllLottoNumbers() {
        return lottos.getAllLottoNumbers();
    }
}
