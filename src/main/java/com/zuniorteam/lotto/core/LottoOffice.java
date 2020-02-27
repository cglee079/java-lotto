package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.dto.MatchResult;
import com.zuniorteam.lotto.util.MathUtils;

import java.util.*;

public class LottoOffice {

    public LottoResult getLottoResult(LottoBuyer lottoBuyer, WinningLotto winningLotto) {
        validate(lottoBuyer, winningLotto);

        final List<MatchResult> matchResults = new ArrayList<>();
        final Map<Prize, Integer> matchLottos = lottoBuyer.checkWinning(winningLotto);
        long totalPrize = 0L;

        for (Prize prize : matchLottos.keySet()) {
            final Integer matchedLottoCount = matchLottos.get(prize);
            final Long prizeMoney = prize.getMoney();

            totalPrize += prizeMoney * matchedLottoCount;
            matchResults.add(new MatchResult(prize, matchedLottoCount));
        }

        return new LottoResult(matchResults, MathUtils.divide(totalPrize, lottoBuyer.getInsertedMoney()));
    }

    private void validate(LottoBuyer lottoBuyer, WinningLotto winningLotto) {
        if (Objects.isNull(lottoBuyer)) {
            throw new IllegalArgumentException("로또 구매자가 없습니다");
        }
        if (Objects.isNull(winningLotto)) {

            throw new IllegalArgumentException("당첨 번호가 없습니다");
        }
    }

}
