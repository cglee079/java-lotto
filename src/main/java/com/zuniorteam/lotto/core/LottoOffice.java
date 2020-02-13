package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.dto.MatchResult;
import com.zuniorteam.lotto.util.MathUtil;
import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.*;

public class LottoOffice {

    public static final Map<Integer, Long> PRIZE_MONEYS;

    static {
        final Map<Integer, Long> prizeMoneys = new HashMap<>();

        prizeMoneys.put(0, 0L);
        prizeMoneys.put(1, 0L);
        prizeMoneys.put(2, 0L);
        prizeMoneys.put(3, 5000L);
        prizeMoneys.put(4, 50000L);
        prizeMoneys.put(5, 1500000L);
        prizeMoneys.put(6, 200000000000L);

        PRIZE_MONEYS = Collections.unmodifiableMap(prizeMoneys);
    }

    public LottoResult getResult(LottoBuyer lottoBuyer, List<LottoNumber> winNumbers) {

        final Integer insertedMoney = lottoBuyer.getInsertedMoney();
        final Map<Integer, Integer> result = lottoBuyer.getResult(winNumbers);

        List<MatchResult> matchResults = new ArrayList<>();
        Long totalPrize = 0L;

        for (Integer matchCount : result.keySet()) {
            final Integer winnerCount = result.get(matchCount);
            final Long prize = PRIZE_MONEYS.get(matchCount);

            totalPrize += prize * winnerCount;
            matchResults.add(new MatchResult(matchCount, prize, winnerCount));
        }

        return new LottoResult(matchResults, MathUtil.divide(totalPrize, insertedMoney));
    }

}
