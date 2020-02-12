package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoOffice {

    public Map<Integer, Integer> getResult(List<Lotto> lottos, List<LottoNumber> winNumbers) {
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

}
