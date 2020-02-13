package com.zuniorteam.lotto.view.console;

import com.zuniorteam.lotto.dto.LottoResult;
import com.zuniorteam.lotto.dto.MatchResult;
import com.zuniorteam.lotto.vo.LottoNumber;

import java.util.List;

public class OutputView {

    public void printLottos(List<List<LottoNumber>> lottos) {
        for (List<LottoNumber> lotto : lottos) {
            System.out.println(lotto);
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
