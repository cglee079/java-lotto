package com.zuniorteam.lotto.view.console;

import com.zuniorteam.lotto.core.Lotto;
import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.dto.MatchResult;

import java.util.List;

public class OutputView {

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨결과");

        for (MatchResult matchResult : lottoResult.getResults()) {
            System.out.println(String.format("%s개 (%s원) - %s", matchResult.getMatchCount(), matchResult.getPrize(), matchResult.getNumberOfWinner()));
        }

        System.out.println("---------------");
        System.out.println("승률 " + lottoResult.getWinPercent());

    }
}
