package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<Integer, Integer> matchLottos(List<LottoNumber> winNumbers) {
        final Map<Integer, Integer> results = new HashMap<>();

        for (int i = 0; i <= Lotto.LOTTO_NUMBER_SIZE; i++) {
            results.put(i, 0);
        }

        for (Lotto lotto : lottos) {
            final int result = lotto.match(winNumbers);
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
