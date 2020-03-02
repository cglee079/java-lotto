package com.zuniorteam.lotto.core;

import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.dto.MatchResult;
import com.zuniorteam.lotto.util.MathUtil;
import com.zuniorteam.lotto.vo.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoOffice {

    public LottoResult getLottoResult(LottoBuyer lottoBuyer, WinningLotto winningLotto) {
        validate(lottoBuyer, winningLotto);

        final List<MatchResult> matchResults = new ArrayList<>();
        final Map<Prize, Integer> matchLottos = lottoBuyer.checkWinning(winningLotto);
        Money totalPrize = Money.ZERO;

        for (Prize prize : matchLottos.keySet()) {
            final Integer matchedLottoCount = matchLottos.get(prize);
            final Money prizeMoney = prize.getMoney();

            totalPrize = totalPrize.addMultiple(prizeMoney, matchedLottoCount);
            matchResults.add(new MatchResult(prize, matchedLottoCount));
        }

        final Money insertedMoney = lottoBuyer.getInsertedMoney();
        return new LottoResult(matchResults, MathUtil.divide(totalPrize.amount(), insertedMoney.amount()));
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
