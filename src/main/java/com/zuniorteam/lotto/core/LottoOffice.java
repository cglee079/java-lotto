package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.dto.MatchResult;
import com.zuniorteam.lotto.util.MathUtils;
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

    public LottoResult getLottoResult(LottoBuyer lottoBuyer, List<LottoNumber> winningNumbers) {
        validate(lottoBuyer);

        final List<MatchResult> matchResults = new ArrayList<>();
        final Integer insertedMoney = lottoBuyer.getInsertedMoney();
        final Map<Integer, Integer> matchLottos = lottoBuyer.checkWinning(winningNumbers);
        long totalPrize = 0L;

        for (Integer matchCount : matchLottos.keySet()) {
            final Integer matchedLottoCount = matchLottos.get(matchCount);
            final Long prize = PRIZE_MONEYS.get(matchCount);

            totalPrize += prize * matchedLottoCount;
            matchResults.add(new MatchResult(matchCount, prize, matchedLottoCount));
        }

        return new LottoResult(MathUtils.divide(totalPrize, insertedMoney), matchResults);
    }

    private void validate(LottoBuyer lottoBuyer) {
        if(Objects.isNull(lottoBuyer)){
            throw new IllegalArgumentException("로또 구매자가 없습니다");
        }
    }

}
