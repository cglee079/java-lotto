package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.dto.MatchResult;
import com.zuniorteam.lotto.util.MathUtils;

import java.util.*;

public class LottoOffice {

    public LottoResult getLottoResult(LottoBuyer lottoBuyer, WinningLotto winningLotto) {
        validate(lottoBuyer, winningLotto);

        final List<MatchResult> matchResults = new ArrayList<>();
        final Integer insertedMoney = lottoBuyer.getInsertedMoney();
        final Map<Integer, Integer> matchLottos = lottoBuyer.checkWinning(winningLotto);
        long totalPrize = 0L;

        for (Integer matchCount : matchLottos.keySet()) {
            final Integer matchedLottoCount = matchLottos.get(matchCount);
            final Long prize = Prize.ofByMatchCount(matchCount).getMoney();

            totalPrize += prize * matchedLottoCount;
            matchResults.add(new MatchResult(matchCount, prize, matchedLottoCount));
        }

        return new LottoResult(matchResults, MathUtils.divide(totalPrize, insertedMoney));
    }

    private void validate(LottoBuyer lottoBuyer, WinningLotto winningLotto) {
        if(Objects.isNull(lottoBuyer)){
            throw new IllegalArgumentException("로또 구매자가 없습니다");
        }

        if(Objects.isNull(winningLotto)){
            throw new IllegalArgumentException("당첨 번호가 없습니다");
        }
    }

}
